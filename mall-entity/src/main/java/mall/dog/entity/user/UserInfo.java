package mall.dog.entity.user;

/**
 * 2018/8/28 mall.dog.entity.user
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class UserInfo {

	private String openId;
	private String unionId;
	private String avatarUrl;
	private String city;
	private String country;
	private String gender;
	private String language;
	private String nickName;
	private String province;

	public UserInfo() {
	}

	public UserInfo(String openId, String unionId, String avatarUrl, String city, String country, String gender, String language, String nickName, String province) {
		this.openId = openId;
		this.unionId = unionId;
		this.avatarUrl = avatarUrl;
		this.city = city;
		this.country = country;
		this.gender = gender;
		this.language = language;
		this.nickName = nickName;
		this.province = province;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
}
