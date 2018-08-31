package mall.dog.web.controller.admin;

import mall.dog.entity.product.ProductInfo;
import mall.dog.entity.response.Entity;
import mall.dog.entity.user.UserInfo;
import mall.dog.service.admin.AdminService;
import mall.dog.service.admin.entity.OrderListRequest;
import mall.dog.service.admin.entity.ProductListRequest;
import mall.dog.service.admin.entity.UserListRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 2018/8/29 mall.dog.web.controller.admin
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@Valid
@RestController
@RequestMapping("admin")
public class AdminController {

	private final AdminService adminService;

	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}

	// v1.0 后台的全部功能

	// [x] 1. 订单
	// [x] 1.1 订单列表（已支付这些）
	// [x] 1.2 修改订单状态
	// [x] 1.3 更新物流信息

	// [x] 2. 产品
	// [x] 2.0 产品列表
	// [x] 2.1 新增产品
	// [x] 2.2 删除产品
	// [x] 2.3 修改产品信息

	// [x] 3. 用户
	// [x] 3.1 用户列表

	// [ ] 4. 统计
	// [ ] 4.1 共多少订单
	// [ ] 4.3 注册用户数量
	// [ ] 4.4 商品总数

	// 订单

	@PostMapping("order/list")
	public Entity orderList(@RequestBody OrderListRequest orderListRequest) {
		return adminService.orderList(orderListRequest);
	}

	@PostMapping("order/update/state")
	public Entity orderUpdateState(@RequestBody OrderListRequest orderListRequest) {
		return adminService.orderUpdateState(orderListRequest);
	}

	@PostMapping("order/update/express")
	public Entity orderUpdateExpress(@RequestBody OrderListRequest orderListRequest) {
		return adminService.orderUpdateExpress(orderListRequest);
	}

	// 商品

	@PostMapping("product/list")
	public Entity productList(@RequestBody ProductListRequest productListRequest) {
		return adminService.productList(productListRequest);
	}

	@PostMapping("product/create")
	public Entity productCreate(@RequestBody ProductListRequest productListRequest) {
		return adminService.productCreate(productListRequest);
	}

	@PostMapping("product/delete")
	public Entity productDelete(@RequestBody ProductListRequest productListRequest) {
		return adminService.productDelete(productListRequest);
	}

	@PostMapping("product/update")
	public Entity productUpdate(@RequestBody ProductListRequest productListRequest) {
		return adminService.productUpdate(productListRequest);
	}

	// 用户

	@PostMapping("user/list")
	public Entity userList(@RequestBody UserListRequest userListRequest) {
		return adminService.userList(userListRequest);
	}

	@PostMapping("user/update")
	public Entity userUpdate(@RequestBody UserInfo userInfo) {
		return adminService.userUpdate(userInfo);
	}

	// 统计

	@PostMapping("data")
	public Entity data() {
		return adminService.data();
	}

}
