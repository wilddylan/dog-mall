package mall.dog.entity.order.enums;

/**
 * 2018/8/28 mall.dog.entity.order.enums
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public enum OrderState {

	/**
	 * 等待支付
	 */
	WAIT_PAY(0, "等待支付"),

	/**
	 * 等待发货
	 */
	WAIT_SEND(1, "等待发货"),

	/**
	 * 等待收货
	 */
	WAIT_RECEIVE(2, "等待收货"),

	/**
	 * 订单结束
	 */
	END(3, "订单完成");

	private Integer value;
	private String description;

	OrderState(Integer value, String description) {
		this.value = value;
		this.description = description;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
