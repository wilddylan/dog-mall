package mall.dog.repo.order.provider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import mall.dog.entity.order.Express;
import mall.dog.entity.user.UserInfo;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 2018/8/29 mall.dog.repo.order.provider
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class OrderSQLProvider {

	public String queryList(Integer orderState, String orderId) {
		StringBuilder stringBuilder = new StringBuilder("SELECT * FROM t_order where order_state = ");
		stringBuilder.append(orderState);
		if (StringUtils.isNotBlank(orderId)) {
			stringBuilder.append(" and ");
			stringBuilder.append(" order_id like '");
			stringBuilder.append(orderId);
			stringBuilder.append("%' ");
		}
		stringBuilder.append(" order by create_time desc");
		return stringBuilder.toString();
	}

	public String queryOne(String orderId) {
		StringBuilder stringBuilder = new StringBuilder("SELECT * FROM t_order where");
		stringBuilder.append(" order_id = ");
		stringBuilder.append(orderId);
		stringBuilder.append(" limit 1");
		return stringBuilder.toString();
	}

	public String updateExpress(String orderId, Express express, Integer expressState) {
		StringBuilder stringBuilder = new StringBuilder("UPDATE t_order SET express_state = ");
		stringBuilder.append(expressState);
		stringBuilder.append(",");

		String expressJson = JSON.toJSONString(
				express,
				SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteNullNumberAsZero,
				SerializerFeature.WriteNullBooleanAsFalse,
				SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.QuoteFieldNames,
				SerializerFeature.WriteDateUseDateFormat,
				SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.WriteClassName);
		stringBuilder.append(" express_info = '");
		stringBuilder.append(expressJson);
		stringBuilder.append("' where order_id = ");
		stringBuilder.append(orderId);

		return stringBuilder.toString();
	}

	public String updateInviteInfo(String orderId, List<UserInfo> inviteList, int inviteNumber) {
		StringBuilder stringBuilder = new StringBuilder("UPDATE t_order SET invite = ");
		stringBuilder.append(inviteNumber);
		stringBuilder.append(",");

		String inviteJson = JSON.toJSONString(
				inviteList,
				SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteNullNumberAsZero,
				SerializerFeature.WriteNullBooleanAsFalse,
				SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.QuoteFieldNames,
				SerializerFeature.WriteDateUseDateFormat,
				SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.WriteClassName);
		stringBuilder.append(" invite_info = '");
		stringBuilder.append(inviteJson);
		stringBuilder.append("' where order_id = ");
		stringBuilder.append(orderId);

		return stringBuilder.toString();
	}

}
