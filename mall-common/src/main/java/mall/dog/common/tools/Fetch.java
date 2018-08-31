package mall.dog.common.tools;

import com.github.kevinsawicki.http.HttpRequest;

/**
 * 2018/8/28 mall.dog.common.tools
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class Fetch {

	public static String GET(String url) {
		return HttpRequest.get(url).body();
	}

}
