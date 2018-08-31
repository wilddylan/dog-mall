package mall.dog.web.controller.admin.user;

import mall.dog.entity.response.Entity;
import mall.dog.service.admin.user.AdminUserService;
import mall.dog.service.admin.user.entity.AdminUserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 2018/8/29 mall.dog.web.controller.admin.user
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@Valid
@RestController
@RequestMapping("admin/user")
public class AdminUserController {

	private final AdminUserService adminUserService;

	@Autowired
	public AdminUserController(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	@PostMapping("login")
	public Entity login(@RequestBody AdminUserLoginRequest loginRequest) {
		return adminUserService.login(loginRequest);
	}

}
