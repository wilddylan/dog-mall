package mall.dog.service.admin.user.entity;

import javax.validation.constraints.NotNull;

/**
 * 2018/8/29 mall.dog.service.admin.user.entity
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class AdminUserLoginRequest {

	@NotNull
	private String username;
	@NotNull
	private String password;

	public AdminUserLoginRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
