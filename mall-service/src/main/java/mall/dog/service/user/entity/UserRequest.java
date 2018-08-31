package mall.dog.service.user.entity;

import mall.dog.entity.user.UserInfo;

import javax.validation.constraints.NotNull;

/**
 * 2018/8/28 mall.dog.service.user.entity
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class UserRequest {

	@NotNull
	private String code;
	private String encryptedData;
	private String errMsg;
	private String iv;
	private String rawData;
	private String signature;
	@NotNull
	private UserInfo userInfo;

	public UserRequest() {
	}

	public UserRequest(String code, String encryptedData, String errMsg, String iv, String rawData, String signature, UserInfo userInfo) {
		this.code = code;
		this.encryptedData = encryptedData;
		this.errMsg = errMsg;
		this.iv = iv;
		this.rawData = rawData;
		this.signature = signature;
		this.userInfo = userInfo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEncryptedData() {
		return encryptedData;
	}

	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getIv() {
		return iv;
	}

	public void setIv(String iv) {
		this.iv = iv;
	}

	public String getRawData() {
		return rawData;
	}

	public void setRawData(String rawData) {
		this.rawData = rawData;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
}
