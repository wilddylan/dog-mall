package mall.dog.service.user.entity;

/**
 * 2018/8/28 mall.dog.service.user.entity
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class TokenResponse {

	private String token;

	public TokenResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
