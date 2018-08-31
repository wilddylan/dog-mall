package mall.dog.service.admin.entity;

import mall.dog.entity.order.Express;
import mall.dog.service.admin.user.entity.AdminUserLoginRequest;

import javax.validation.constraints.NotNull;

/**
 * 2018/8/29 mall.dog.service.admin.entity
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class OrderListRequest extends AdminUserLoginRequest {

	private String orderId;
	private Integer orderState = 0;
	@NotNull
	private Integer pageNo;
	@NotNull
	private Integer pageSize;

	private Express express;
	private Integer expressState;

	public OrderListRequest(String username, String password) {
		super(username, password);
	}

	public OrderListRequest(String username, String password, String orderId, Integer orderState, @NotNull Integer pageNo, @NotNull Integer pageSize, Express express, Integer expressState) {
		super(username, password);
		this.orderId = orderId;
		this.orderState = orderState;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.express = express;
		this.expressState = expressState;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Express getExpress() {
		return express;
	}

	public void setExpress(Express express) {
		this.express = express;
	}

	public Integer getExpressState() {
		return expressState;
	}

	public void setExpressState(Integer expressState) {
		this.expressState = expressState;
	}
}
