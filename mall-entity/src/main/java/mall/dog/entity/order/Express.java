package mall.dog.entity.order;

import org.apache.commons.lang3.StringUtils;

/**
 * 2018/8/28 mall.dog.entity.order
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class Express {

	private String name;
	private String current;
	private String expect;
	private String address;
	private String phone;
	private String contact;
	private String postCode;
	private String expressNumber;

	public Express(String name, String current, String expect, String address, String phone, String contact, String postCode, String expressNumber) {
		this.name = name;
		this.current = current;
		this.expect = expect;
		this.address = address;
		this.phone = phone;
		this.contact = contact;
		this.postCode = postCode;
		this.expressNumber = expressNumber;
	}

	public Express() {
	}

	public String getExpressNumber() {
		return expressNumber;
	}

	public void setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}

	public String getExpect() {
		return expect;
	}

	public void setExpect(String expect) {
		this.expect = expect;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}
