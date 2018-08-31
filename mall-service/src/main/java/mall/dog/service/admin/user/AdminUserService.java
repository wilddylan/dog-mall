package mall.dog.service.admin.user;

import mall.dog.common.tools.NullUtil;
import mall.dog.entity.admin.AdminUser;
import mall.dog.entity.response.Entity;
import mall.dog.repo.admin.user.AdminUserMapper;
import mall.dog.service.admin.user.entity.AdminUserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 2018/8/29 mall.dog.service.admin.user
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@Service
public class AdminUserService {

	private final AdminUserMapper adminUserMapper;

	@Autowired
	public AdminUserService(AdminUserMapper adminUserMapper) {
		this.adminUserMapper = adminUserMapper;
	}

	public Entity login(AdminUserLoginRequest loginRequest) {
		AdminUser adminUser = adminUserMapper.query(loginRequest.getUsername());
		if (!NullUtil.isNull(adminUser)) {
			// 对比密码是否相同
			if (loginRequest.getPassword().equals(adminUser.getPassword())) {
				return Entity.Success();
			}
		}
		return Entity.Failure();
	}

}
