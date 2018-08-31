package mall.dog.common.request;

import javax.validation.constraints.NotNull;

/**
 * 2018/8/29 mall.dog.common.request
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class TokenRequest {

	@NotNull
	private String token;

	public TokenRequest(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
