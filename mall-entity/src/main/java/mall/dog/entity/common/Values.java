package mall.dog.entity.common;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * 2018/8/28 mall.dog.entity.common
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class Values {

	private String name;
	private Boolean select;
	private Float price = 0f;

	public Values(String name, Boolean select, Float price) {
		this.name = name;
		this.select = select;
		this.price = price;
	}

	public Values() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getSelect() {
		return select;
	}

	public void setSelect(Boolean select) {
		this.select = select;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
}
