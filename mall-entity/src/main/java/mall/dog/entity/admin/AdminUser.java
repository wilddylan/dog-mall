package mall.dog.entity.admin;

/**
 * 2018/8/29 mall.dog.entity.admin
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class AdminUser {

	private String username;
	private String password;

	public AdminUser(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public AdminUser() {
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
