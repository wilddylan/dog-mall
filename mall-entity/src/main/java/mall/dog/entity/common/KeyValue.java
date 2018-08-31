package mall.dog.entity.common;

/**
 * 2018/8/28 mall.dog.entity.common
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class KeyValue {

	private String key;
	private String value;

	public KeyValue(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public KeyValue() {
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
