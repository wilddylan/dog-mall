package mall.dog.common.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 2018/8/28 mall.dog.common.tools
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class OrderUtil {

	public static String getOrderIdByTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return dateFormat.format(new Date());
	}

}
