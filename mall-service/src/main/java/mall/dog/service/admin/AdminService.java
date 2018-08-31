package mall.dog.service.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mall.dog.common.tools.NullUtil;
import mall.dog.entity.admin.OrderAnalysis;
import mall.dog.entity.admin.ProductAnalysis;
import mall.dog.entity.admin.UserAnalysis;
import mall.dog.entity.order.Order;
import mall.dog.entity.product.ProductInfo;
import mall.dog.entity.response.Entity;
import mall.dog.entity.user.UserInfo;
import mall.dog.repo.admin.AdminMapper;
import mall.dog.repo.order.OrderMapper;
import mall.dog.repo.product.ProductMapper;
import mall.dog.repo.user.UserMapper;
import mall.dog.service.admin.entity.OrderListRequest;
import mall.dog.service.admin.entity.ProductListRequest;
import mall.dog.service.admin.entity.UserListRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2018/8/29 mall.dog.service.admin
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@Service
public class AdminService {

	private final OrderMapper orderMapper;
	private final ProductMapper productMapper;
	private final UserMapper userMapper;
	private final AdminMapper adminMapper;

	@Autowired
	public AdminService(OrderMapper orderMapper, ProductMapper productMapper, UserMapper userMapper, AdminMapper adminMapper) {
		this.orderMapper = orderMapper;
		this.productMapper = productMapper;
		this.userMapper = userMapper;
		this.adminMapper = adminMapper;
	}

	// 订单

	public Entity orderList(OrderListRequest orderListRequest) {
		PageHelper.startPage(orderListRequest.getPageNo(), orderListRequest.getPageSize());
		List<Order> orderList = orderMapper.queryList(orderListRequest.getOrderState(), orderListRequest.getOrderId());
		orderList.forEach(order -> {
			order.setProductInfo(productMapper.queryOne(order.getProductId()));
			order.setUserInfo(userMapper.queryOne(order.getOpenId()));
		});
		PageInfo<Order> pageInfo = new PageInfo<>(orderList);
		return Entity.Success(orderList, (int) pageInfo.getTotal());
	}

	public Entity orderUpdateState(OrderListRequest orderListRequest) {
		String orderId = orderListRequest.getOrderId();
		Integer state = orderListRequest.getOrderState();

		if ( !StringUtils.isAnyBlank(orderId, state + "") ) {
			// 1. 查询订单信息，只可以往大修改，不可以撤回状态
			Order order = orderMapper.queryOne(orderId);
			if ( state > order.getOrderState().getValue() && state < 4 ) {
				// 2. 修改订单信息
				int result = orderMapper.updateState(orderId, state);
				if ( result == 1 ) {
					// 3. 增加 share_id 订单的 invite 信息
					if ( state == 1 && StringUtils.isNotBlank(order.getShareId()) ) { // 从已支付状态 修改为 待发货状态
						Order sharedOrder = orderMapper.queryOne(order.getShareId());
						if ( !NullUtil.isNull(sharedOrder) ) {
							// 3.1 查询购买当前订单的用户信息
							UserInfo inviteInfo = userMapper.queryOne(order.getOpenId());
							List<UserInfo> inviteList = new ArrayList<>();
							if ( !NullUtil.isNull(sharedOrder.getInviteInfo()) ) {
								inviteList.addAll(sharedOrder.getInviteInfo());
							}
							inviteList.add(inviteInfo);
							// 3.2 增加订单的 invite, inviteInfo 信息
							int inviteNumber = sharedOrder.getInvite() + 1;
							// 3.3 更新 shareOrder 到数据库中
							orderMapper.updateInviteInfo(sharedOrder.getOrderId(), inviteList, inviteNumber);
						}
					}

					return Entity.Success();
				}
			}
		}
		return Entity.Failure();
	}

	public Entity orderUpdateExpress(OrderListRequest orderListRequest) {
		if (
				!NullUtil.isNull(orderListRequest.getExpress()) &&
				!NullUtil.isNull(orderListRequest.getExpressState()) &&
				StringUtils.isNotBlank(orderListRequest.getOrderId())
		) {
			int result = orderMapper.updateExpress(orderListRequest.getOrderId(), orderListRequest.getExpress(), orderListRequest.getExpressState());
			if ( result == 1 ) {
				return Entity.Success();
			}
		}
		return Entity.Failure();
	}

	// 产品

	public Entity productList(ProductListRequest productListRequest) {
		PageHelper.startPage(productListRequest.getPageNo(), productListRequest.getPageSize());
		List<ProductInfo> productList = productMapper.queryList(productListRequest.getProductId());
		PageInfo<ProductInfo> pageInfo = new PageInfo<>(productList);
		return Entity.Success(productList, (int) pageInfo.getTotal());
	}

	public Entity productCreate(ProductListRequest productListRequest) {
		ProductInfo productInfo = productListRequest.getProductInfo();
		if ( !NullUtil.isNull(productInfo) ) {
			int result = productMapper.insert(productInfo);
			if ( result == 1 ) {
				return Entity.Success();
			}
		}
		return Entity.Failure();
	}

	public Entity productDelete(ProductListRequest productListRequest) {
		int result = productMapper.delete(productListRequest.getProductId(), productListRequest.getDelete());
		if ( result == 1 ) {
			return Entity.Success();
		}
		return Entity.Failure();
	}

	public Entity productUpdate(ProductListRequest productListRequest) {
		ProductInfo productInfo = productListRequest.getProductInfo();
		if ( !NullUtil.isNull(productInfo) ) {
			if ( StringUtils.isNotBlank(productInfo.getId() + "") ) {
				// 1. 准备更新商品信息
				int result = productMapper.update(productInfo);
				if ( result == 1 ) {
					return Entity.Success();
				}
			}
		}
		return Entity.Failure();
	}

	// 用户

	public Entity userList(UserListRequest userListRequest) {
		PageHelper.startPage(userListRequest.getPageNo(), userListRequest.getPageSize());
		List<UserInfo> userInfoList = userMapper.queryList();
		PageInfo<UserInfo> pageInfo = new PageInfo<>(userInfoList);
		return Entity.Success(userInfoList, (int) pageInfo.getTotal());
	}

	public Entity userUpdate(UserInfo userInfo) {
		return Entity.Failure();
	}

	// 统计

	public Entity data() {
		// 1. 订单数量（昨日 今日 总共）
		List<Integer> number = adminMapper.analysisOrderNumber();
		List<Float> price = adminMapper.analysisOrderPrice();

		// 3. 注册用户数（昨日 今日 总共）
		List<Integer> userNumber = adminMapper.analysisUser();
		// 4. 商品总数
		int productNumber = adminMapper.analysisProduct();

		Map<String, Object> result = new HashMap<>();
		result.put("orderAnalysis", new OrderAnalysis(
				number.get(0), number.get(1), number.get(2),
				price.get(0), price.get(1), price.get(2)
		));
		result.put("userAnalysis", new UserAnalysis(
				userNumber.get(0),userNumber.get(1),userNumber.get(2)
		));
		result.put("productAnalysis", new ProductAnalysis(productNumber));

		return Entity.Success(result);
	}

}
