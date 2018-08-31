package mall.dog.service.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import mall.dog.common.constants.MallConstant;
import mall.dog.common.tools.Fetch;
import mall.dog.entity.response.Entity;
import mall.dog.entity.user.UserInfo;
import mall.dog.repo.user.UserMapper;
import mall.dog.service.user.entity.TokenResponse;
import mall.dog.service.user.entity.UserRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 2018/8/28 mall.dog.service.user
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@Service
public class UserService {

	private final UserMapper userMapper;
	private ConcurrentHashMap<String, UserInfo> users = new ConcurrentHashMap<>();

	@Autowired
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public Entity login(UserRequest request) {
		// 请求小程序进行用户授权
		String requestURL = String.format(MallConstant.WX_LOGIN_URL_FORMAT, MallConstant.WX_APP_ID, MallConstant.WX_APP_SECRET, request.getCode());
		String resultString = Fetch.GET(requestURL);
		if (!StringUtils.isBlank(resultString)) {
			JSONObject resultObject = JSON.parseObject(resultString);
			// 小程序用户登录
			String openid = resultObject.getString("openid");
			String unionid = resultObject.getString("unionid");
 			int result = userMapper.upsert(openid, unionid);
 			if (result == 1) {
 				// 插入或者更新成功，返回客户端token, token 为 openid
				UserInfo userInfo = new UserInfo();
				userInfo.setOpenId(openid);
				userInfo.setUnionId(unionid);
				users.put(openid, userInfo);
				return Entity.Success(new TokenResponse(openid));
			}
		}
		return Entity.Failure();
	}

	public Boolean validated(String token) {
		if (StringUtils.isBlank(token)) {
			return false;
		}
		return users.containsKey(token);
	}

	public UserInfo getUserInfo(String token) {
		return users.get(token);
	}

	public Entity update(UserInfo userInfo) {
		// 更新用户信息到数据库中
		String openId = userInfo.getOpenId();
		if (StringUtils.isNotBlank(openId)) {
			UserInfo savedUserInfo = getUserInfo(openId);

			savedUserInfo.setLanguage(userInfo.getLanguage());
			savedUserInfo.setCity(userInfo.getCity());
			savedUserInfo.setCountry(userInfo.getCountry());
			savedUserInfo.setProvince(userInfo.getProvince());
			savedUserInfo.setGender(userInfo.getGender());
			savedUserInfo.setAvatarUrl(userInfo.getAvatarUrl());
			savedUserInfo.setNickName(userInfo.getNickName());

			int result = userMapper.update(savedUserInfo);
			if ( result == 1 ) {
				users.put(openId, savedUserInfo);
				return Entity.Success();
			}
		}
		return Entity.Failure();
	}
}
