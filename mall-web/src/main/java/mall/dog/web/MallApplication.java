package mall.dog.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 2018/8/26 mall.dog
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@SpringBootApplication(scanBasePackages = {
		"mall.dog.web",
		"mall.dog.service",
		"mall.dog.repo",
})
public class MallApplication {

	public static void main(String[] args) {
		SpringApplication.run(MallApplication.class, args);
	}

}
