package mall.dog.repo.admin.user;

import mall.dog.entity.admin.AdminUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 2018/8/29 mall.dog.repo.admin.user
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@Repository
public interface AdminUserMapper {

	@Select(
			"SELECT * FROM t_admin_user where username = #{username} limit 1"
	)
	AdminUser query(@Param("username") String username);

}
