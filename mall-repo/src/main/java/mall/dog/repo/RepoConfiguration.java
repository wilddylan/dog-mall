package mall.dog.repo;

import com.alibaba.fastjson.parser.ParserConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * 2018/8/28 mall.dog.repo
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@MapperScan("mall.dog.repo")
@Configuration
public class RepoConfiguration {

	public RepoConfiguration() {
		ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
	}

}
