package mall.dog.web.exception;

import mall.dog.entity.response.Entity;
import mall.dog.web.annotation.LogResult;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2018/7/18 channels.exception
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@RestController
public class FinalErrorHandler implements ErrorController {

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping(value = "/error")
	@LogResult
	public Entity error() {
		return Entity.Failure();
	}

}
