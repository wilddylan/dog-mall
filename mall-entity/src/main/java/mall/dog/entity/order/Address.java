package mall.dog.entity.order;

/**
 * 2018/8/28 mall.dog.entity.order
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class Address {

	private String userName;
	private String postalCode;
	private String provinceName;
	private String cityName;
	private String countyName;
	private String detailInfo;
	private String nationalCode;
	private String telNumber;

	public Address(String userName, String postalCode, String provinceName, String cityName, String countyName, String detailInfo, String nationalCode, String telNumber) {
		this.userName = userName;
		this.postalCode = postalCode;
		this.provinceName = provinceName;
		this.cityName = cityName;
		this.countyName = countyName;
		this.detailInfo = detailInfo;
		this.nationalCode = nationalCode;
		this.telNumber = telNumber;
	}

	public Address() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public String getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(String detailInfo) {
		this.detailInfo = detailInfo;
	}

	public String getNationalCode() {
		return nationalCode;
	}

	public void setNationalCode(String nationalCode) {
		this.nationalCode = nationalCode;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
}
