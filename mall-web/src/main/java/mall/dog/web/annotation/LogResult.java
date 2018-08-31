package mall.dog.web.annotation;

import java.lang.annotation.*;

/**
 * 2018/8/9 channels.annotation
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogResult {
	String value() default "";
}
