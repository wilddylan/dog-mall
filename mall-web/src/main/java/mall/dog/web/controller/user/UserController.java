package mall.dog.web.controller.user;

import mall.dog.entity.response.Entity;
import mall.dog.entity.user.UserInfo;
import mall.dog.service.user.UserService;
import mall.dog.service.user.entity.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 2018/8/26 mall.dog.web.controller.user
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@Valid
@RestController
@RequestMapping("user")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 小程序登录接口
	 * @return 是否登录成功
	 */
	@PostMapping("login")
	public Entity login(@RequestBody UserRequest request) {
		return userService.login(request);
	}

	@PostMapping("update")
	public Entity update(@RequestBody UserInfo userInfo) {
		return userService.update(userInfo);
	}

}
