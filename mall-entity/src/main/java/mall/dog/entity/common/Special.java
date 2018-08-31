package mall.dog.entity.common;

import java.util.List;

/**
 * 2018/8/28 mall.dog.entity.common
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class Special {

	private String key;
	private List<Values> value;
	private String extra;
	private String type;
	private Float price = 0f;

	public Special(String key, List<Values> value, String extra, String type, Float price) {
		this.key = key;
		this.value = value;
		this.extra = extra;
		this.type = type;
		this.price = price;
	}

	public Special() {
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<Values> getValue() {
		return value;
	}

	public void setValue(List<Values> value) {
		this.value = value;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
}
