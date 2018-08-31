package mall.dog.web.exception;

import mall.dog.entity.response.Entity;
import mall.dog.web.annotation.LogResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 2018/7/18 channels.exception
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	@LogResult
	public Entity exception(Exception exception) {
		exception.printStackTrace();
		return Entity.Failure();
	}

}
