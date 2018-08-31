package mall.dog.web.configuration;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 2018/8/8 channels.configuration
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@Aspect
@Component
public class Logger {

	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(Logger.class);

	@Pointcut("execution(* mall.dog.web.controller..*.*(..))")
	public void pointCut() { }

	@Pointcut("@annotation(mall.dog.web.annotation.LogResult)")
	public void logResultPointCut() {

	}

	@Before("pointCut()")
	public void in(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (attributes != null) {
			HttpServletRequest request = attributes.getRequest();
			LOG.info("\033[32m[{}] {}: {} \033[0m",
					request.getMethod(),
					request.getRequestURI(),
					JSON.toJSONString(joinPoint.getArgs()));
		}
	}

	@AfterReturning(pointcut = "pointCut()", returning = "object")
	public void out(Object object) {
		logResult(object);
	}

	@AfterReturning(pointcut = "logResultPointCut()", returning = "object")
	public void exceptionOut(Object object) {
		logResult(object);
	}

	private void logResult(Object object) {
		if (object != null) {
			LOG.info("\033[34m[请求结果] {}\033[0m", JSON.toJSONString(object));
		}
	}

}
