package mall.dog.repo.user;

import mall.dog.entity.product.ProductInfo;
import mall.dog.entity.user.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 2018/8/28 mall.dog.repo.user
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@Repository
public interface UserMapper {

	@Insert(
			"INSERT INTO t_user (open_id, union_id)" +
					"VALUES (#{openid}, #{union})" +
					"ON DUPLICATE KEY UPDATE " +
					"union_id=#{union}"
	)
	int upsert(@Param("openid") String openid, @Param("union") String union);

	@Select(
			"SELECT * from t_user where open_id = #{openId}"
	)
	@Results(
			id = "userMap",
			value = {
					@Result(column = "open_id", property = "openId"),
					@Result(column = "union_id", property = "unionId"),
					@Result(column = "avatar_url", property = "avatarUrl"),
					@Result(column = "nick_name", property = "nickName")
			}
	)
	UserInfo queryOne(@Param("openId") String openId);

	@Select(
			"SELECT * from t_user"
	)
	@ResultMap("userMap")
	List<UserInfo> queryList();

	@Update(
			"UPDATE t_user SET avatar_url=#{savedUserInfo.avatarUrl}, nick_name=#{savedUserInfo.nickName}, city=#{savedUserInfo.city}, country=#{savedUserInfo.country}, gender=#{savedUserInfo.gender}, language=#{savedUserInfo.language}, province=#{savedUserInfo.province} " +
					"where open_id = #{savedUserInfo.openId}"
	)
	int update(@Param("savedUserInfo") UserInfo savedUserInfo);
}
