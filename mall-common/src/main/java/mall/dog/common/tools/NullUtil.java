package mall.dog.common.tools;

import org.apache.commons.lang3.ObjectUtils;

/**
 * 2018/7/18 channels.utils.tools
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class NullUtil {

	public static Boolean isNull(Object object) {
		return !ObjectUtils.allNotNull(object);
	}

}
