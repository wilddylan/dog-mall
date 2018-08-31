package mall.dog.entity.order.enums;

import java.security.PrivateKey;

/**
 * 2018/8/28 mall.dog.entity.order.enums
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public enum ExpressState {

	/**
	 * 还没有快递信息
	 */
	NONE(0, "暂无快递信息"),
	/**
	 * 已经发货
	 */
	SENT(1, "快递已发出");

	private Integer value;
	private String description;

	ExpressState(Integer value, String description) {
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
