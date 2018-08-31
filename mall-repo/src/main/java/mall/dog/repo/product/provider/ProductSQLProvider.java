package mall.dog.repo.product.provider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import mall.dog.entity.order.Express;
import mall.dog.entity.product.ProductDetail;
import mall.dog.entity.product.ProductInfo;
import mall.dog.entity.user.UserInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Base64Utils;

import javax.sound.midi.Soundbank;
import java.util.List;

/**
 * 2018/8/29 mall.dog.repo.order.provider
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class ProductSQLProvider {

	public String queryList(String productId) {
		StringBuilder stringBuilder = new StringBuilder("SELECT * FROM t_product  ");
		if (StringUtils.isNotBlank(productId)) {
			stringBuilder.append(" where id like '");
			stringBuilder.append(productId);
			stringBuilder.append("%' ");
		}
		stringBuilder.append("order by create_time desc");
		return stringBuilder.toString();
	}

	public String update(ProductInfo productInfo) {
		StringBuilder stringBuilder = new StringBuilder("UPDATE t_product SET ");

		stringBuilder.append("`left` = ");
		stringBuilder.append(productInfo.getLeft());

		stringBuilder.append(", images = '");
		stringBuilder.append(JSON.toJSONString(productInfo.getImages(),
				SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteNullNumberAsZero,
				SerializerFeature.WriteNullBooleanAsFalse,
				SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.QuoteFieldNames,
				SerializerFeature.WriteDateUseDateFormat,
				SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.WriteClassName));
		stringBuilder.append("', ");

		stringBuilder.append("`name` = '");
		stringBuilder.append(productInfo.getName());

		stringBuilder.append("', `description` = '");
		stringBuilder.append(productInfo.getDescription());

		stringBuilder.append("', express = '");
		stringBuilder.append(productInfo.getExpress());

		stringBuilder.append("', sendTime = '");
		stringBuilder.append(productInfo.getSendTime());

		stringBuilder.append("', specials_extra = '");
		stringBuilder.append(productInfo.getSpecialsExtra());

		stringBuilder.append("', specials = '");
		stringBuilder.append(JSON.toJSONString(productInfo.getSpecials(),
				SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteNullNumberAsZero,
				SerializerFeature.WriteNullBooleanAsFalse,
				SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.QuoteFieldNames,
				SerializerFeature.WriteDateUseDateFormat,
				SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.WriteClassName));
		stringBuilder.append("', ");

		stringBuilder.append(" infos = '");
		stringBuilder.append(JSON.toJSONString(productInfo.getInfos(),
				SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteNullNumberAsZero,
				SerializerFeature.WriteNullBooleanAsFalse,
				SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.QuoteFieldNames,
				SerializerFeature.WriteDateUseDateFormat,
				SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.WriteClassName));
		stringBuilder.append("', ");

		stringBuilder.append(" questions = '");
		stringBuilder.append(JSON.toJSONString(productInfo.getQuestions(),
				SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteNullNumberAsZero,
				SerializerFeature.WriteNullBooleanAsFalse,
				SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.QuoteFieldNames,
				SerializerFeature.WriteDateUseDateFormat,
				SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.WriteClassName));
		stringBuilder.append("', ");

		stringBuilder.append("detail = '");
		String jsonBase = JSON.toJSONString(productInfo.getDetail(),
				SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteNullNumberAsZero,
				SerializerFeature.WriteNullBooleanAsFalse,
				SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.QuoteFieldNames,
				SerializerFeature.WriteDateUseDateFormat,
				SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.WriteClassName);
		stringBuilder.append(Base64Utils.encodeToString(jsonBase.getBytes()));
		stringBuilder.append("', ");

		stringBuilder.append("invite_price = '");
		stringBuilder.append(productInfo.getInvitePrice());

		stringBuilder.append("' where id = ");
		stringBuilder.append(productInfo.getId());

		return stringBuilder.toString();
	}

}
