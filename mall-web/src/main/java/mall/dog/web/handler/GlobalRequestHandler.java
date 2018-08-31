package mall.dog.web.handler;

import com.alibaba.fastjson.JSON;
import mall.dog.common.constants.MallConstant;
import mall.dog.entity.response.Entity;
import mall.dog.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 2018/8/8 channels.handler
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@Component
public class GlobalRequestHandler implements HandlerInterceptor {

	private final UserService userService;

	@Autowired
	public GlobalRequestHandler(UserService userService) {
		this.userService = userService;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if ( !userService.validated(request.getHeader(MallConstant.TOKEN)) ) {
			responseResult(response, Entity.NeedLogin());
			return false;
		}
		return true;
	}

	private void responseResult(HttpServletResponse response, Entity resp) {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "application/json;charset=UTF-8");
		response.setStatus(200);
		try {
			response.getWriter().write(JSON.toJSONString(resp));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
