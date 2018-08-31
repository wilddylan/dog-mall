package mall.dog.service.order;

import com.alibaba.fastjson.JSON;
import mall.dog.common.constants.MallConstant;
import mall.dog.common.request.TokenRequest;
import mall.dog.common.tools.NullUtil;
import mall.dog.common.tools.OrderUtil;
import mall.dog.entity.common.Special;
import mall.dog.entity.common.Values;
import mall.dog.entity.order.Address;
import mall.dog.entity.order.Express;
import mall.dog.entity.order.Order;
import mall.dog.entity.order.enums.ExpressState;
import mall.dog.entity.order.enums.OrderState;
import mall.dog.entity.product.ProductInfo;
import mall.dog.entity.response.Entity;
import mall.dog.repo.order.OrderMapper;
import mall.dog.service.order.entity.CreateOrderRequest;
import mall.dog.service.order.entity.OrderResponse;
import mall.dog.service.product.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * 2018/8/28 mall.dog.service.order
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@Service
public class OrderService {

	private final ProductService productService;
	private final OrderMapper orderMapper;

	@Autowired
	public OrderService(ProductService productService, OrderMapper orderMapper) {
		this.productService = productService;
		this.orderMapper = orderMapper;
	}

	public Entity create(CreateOrderRequest createOrderRequest) {
		// 下单，首先计算商品价格
		ProductInfo productInfo = productService.query(createOrderRequest.getProductId());
		if (!NullUtil.isNull(productInfo)) {
			if (createOrderRequest.getPiece() <= productInfo.getLeft()) {
				List<Special> requestSpecials = createOrderRequest.getSpecials();
				List<Special> originSpecials = productInfo.getSpecials();
				// 对比请求提交的 special 与 查询出来的 special 是否一致，不一致的话直接返回错误
				if ( requestSpecials.size() == originSpecials.size() ) {
					// 1. 获取选中的规格的价格, 需要分别获取 Multiple 和 Single 的商品价格
					List<Special> multiOriginSpecial = new ArrayList<>();
					List<Special> singleOriginSpecial = new ArrayList<>();

					List<Special> multiRequestSpecial = new ArrayList<>();
					List<Special> singleRequestSpecial = new ArrayList<>();

					originSpecials.forEach(special -> {
						if (MallConstant.MULTIPLE.equals(special.getType())) {
							multiOriginSpecial.add(special);
						} else {
							singleOriginSpecial.add(special);
						}
					});

					requestSpecials.forEach(special -> {
						if (MallConstant.SINGLE.equals(special.getType())) {
							singleRequestSpecial.add(special);
						} else {
							multiRequestSpecial.add(special);
						}
					});
					// 2. 计算价格, 并且记录选择的规格
					AtomicReference<Float> price = new AtomicReference<>(0f);
					// 多选的规格，直接加价就好了
					multiOriginSpecial.forEach(special -> {
						price.updateAndGet(v -> v + special.getPrice());
					});
					// 单选的规格，需要遍历找出
					singleOriginSpecial.forEach(special -> {
						singleRequestSpecial.forEach(requestSpecial -> {
							// 2.1 key 相同
							if ( special.getKey().equals(requestSpecial.getKey()) ) {
								// 2.2 找出选择的项目
								Values selectValue = null;
								List<Values> valuesList = requestSpecial.getValue().stream().filter(Values::getSelect).collect(Collectors.toList());
								if ( valuesList.size() > 0 ) {
									selectValue = valuesList.get(0);
								}
								if (selectValue != null) {
									// 2.3 选择项在源数据中的价格
									Values originValue = null;
									Values finalSelectValue = selectValue;
									List<Values> originValueList = special.getValue().stream().filter(item -> item.getName().equals(finalSelectValue.getName())).collect(Collectors.toList());
									if (originValueList.size() > 0) {
										// 2.4 找到了源价格
										originValue = originValueList.get(0);
									}
									if (originValue != null) {
										// 2.5 增加价格
										Values finalOriginValue = originValue;
										price.updateAndGet(v -> v + finalOriginValue.getPrice());
									}
								}
							}
						});
					});
					// 2.6 选择规格的描述数组
					List<String> chooseSpecials = new ArrayList<>();
					getSelectSpecial(multiRequestSpecial, chooseSpecials);
					getSelectSpecial(singleRequestSpecial, chooseSpecials);

					// 3. 确定最终价格
					Float realPrice = price.get() * createOrderRequest.getPiece();
					// 4. 确定订单 ID
					Integer productId = productInfo.getId();
					String orderId = OrderUtil.getOrderIdByTime() + productId;

					// 5. 生成订单
					Order order = new Order();

					order.setOpenId(createOrderRequest.getToken());
					order.setOrderId(orderId);
					order.setProductId(productInfo.getId());
					order.setShareId(createOrderRequest.getShareOrderId());

					order.setOrderState(OrderState.WAIT_PAY);
					order.setPiece(createOrderRequest.getPiece());
					order.setSpecials(chooseSpecials);
					order.setSpecialJsonString(JSON.toJSONString(chooseSpecials));

					order.setPrice(realPrice);
					order.setOriginPrice(realPrice);

					order.setInvite(0);
					order.setInviteInfo(new ArrayList<>());

					order.setExpressState(ExpressState.NONE);
					Express express = new Express();
					Address address = createOrderRequest.getAddress();
					express.setName("");
					express.setCurrent("");
					express.setExpect("");
					express.setPhone(address.getTelNumber());
					express.setContact(address.getUserName());
					express.setPostCode(address.getPostalCode());

					express.setAddress(
							address.getProvinceName() +
							address.getCityName() +
							address.getCountyName() +
							address.getDetailInfo() +
							"[" + address.getPostalCode() + "]");

					order.setExpressInfo(express);

					// 订单入库
					int result = orderMapper.create(order);
					if (result == 1) {
						return Entity.Success();
					}
				}
			}
		}
		return Entity.Failure();
	}

	private void getSelectSpecial(List<Special> singleRequestSpecial, List<String> chooseSpecials) {
		singleRequestSpecial.forEach(special -> {
			StringBuilder stringBuilder = new StringBuilder(special.getKey());
			stringBuilder.append("：");
			special.getValue().forEach(v -> {
				if (v.getSelect()) {
					stringBuilder.append(v.getName());
					stringBuilder.append("、");
				}
			});
			chooseSpecials.add(stringBuilder.toString());
		});
	}

	public Entity query(TokenRequest tokenRequest) {
		List<OrderResponse> responseList = new ArrayList<>();

		List<Order> queryList = orderMapper.query(tokenRequest.getToken());
		if (queryList != null && queryList.size() > 0) {
			// 处理 queryList
			queryList.forEach(order -> {
				// 1. orderState -> 文字
				OrderResponse response = new OrderResponse();

				response.setOpenId(order.getOpenId());
				response.setOrderId(order.getOrderId());
				response.setProductId(order.getProductId());
				response.setOrderState(order.getOrderState().getDescription());
				response.setPiece(order.getPiece());
				response.setSpecials(order.getSpecials());

				ProductInfo productInfo = productService.query(order.getProductId());

				response.setOriginPrice(order.getOriginPrice());
				response.setPrice("目前还需付款：￥" + order.getPrice() + " 元");

				if (order.getInvite() == 0) {
					// 您还没有邀请好友呢
					response.setInvite("您还没有邀请好友呢，快去邀请好友，减免订单费用吧！每次邀请成功可减免￥" + productInfo.getInvitePrice());
				} else {
					Float rev = order.getInvite() * productInfo.getInvitePrice();
					if (rev >= order.getOriginPrice()) {
						response.setPrice("免费获得");
					} else {
						response.setPrice("目前还需付款：￥ " + (order.getOriginPrice() - rev) + " 元");
					}
					response.setInvite("您已经邀请 " + order.getInvite() + " 位好友下单并付款成功，这将为您减免：￥" + rev);
				}
				response.setInviteInfo(order.getInviteInfo());
				response.setExpressInfo(order.getExpressInfo());
				if (StringUtils.isNotBlank(order.getExpressInfo().getExpressNumber())) {
					response.setExpressState(order.getExpressState().getDescription() + " [" + order.getExpressInfo().getExpressNumber() + "]");
				} else {
					response.setExpressState(order.getExpressState().getDescription());
				}
				response.setProductInfo(productInfo);

				responseList.add(response);
			});
		}

		return Entity.Success(responseList, responseList.size());
	}

}
