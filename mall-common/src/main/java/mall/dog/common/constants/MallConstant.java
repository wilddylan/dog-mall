package mall.dog.common.constants;

import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 2018/8/26 mall.dog.common.constants
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class MallConstant {

	public final static String WX_APP_ID = "wxbf5e49e4a12a2ef2";
	public final static String WX_APP_SECRET = "2ccbafaf515ea0bd3a015055687497d1";
	public final static String WX_LOGIN_URL_FORMAT = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";

	public final static String SUCCESS_MESSAGE = "成功 !";
	public final static String FAILURE_MESSAGE = "失败 !";
	public final static String LOGIN_MESSAGE = "请先登录 !";

	public final static Integer SUCCESS_CODE = 0;
	public final static Integer FAILURE_CODE = -1;
	public final static Integer NEED_LOGIN = -2;

	public final static String TOKEN = "token";

	public final static String MULTIPLE = "multip";
	public final static String SINGLE = "single";

}
