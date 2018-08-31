package mall.dog.repo.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import mall.dog.entity.product.ProductDetail;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.springframework.util.Base64Utils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 2018/8/28 mall.dog.repo.handler
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@MappedJdbcTypes(value = JdbcType.VARCHAR, includeNullJdbcType = true)
public class ProductDetailHandler extends BaseTypeHandler<ProductDetail> {
	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int i, ProductDetail productDetail, JdbcType jdbcType) throws SQLException {
		String jsonBase = JSON.toJSONString(productDetail,
				SerializerFeature.WriteNullStringAsEmpty,
				SerializerFeature.WriteNullNumberAsZero,
				SerializerFeature.WriteNullBooleanAsFalse,
				SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.QuoteFieldNames,
				SerializerFeature.WriteDateUseDateFormat,
				SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.WriteClassName);
		preparedStatement.setString(i, Base64Utils.encodeToString(jsonBase.getBytes()));
	}

	@Override
	public ProductDetail getNullableResult(ResultSet resultSet, String s) throws SQLException {
		return getJsonList(resultSet.getString(s));
	}

	@Override
	public ProductDetail getNullableResult(ResultSet resultSet, int i) throws SQLException {
		return getJsonList(resultSet.getString(i));
	}

	@Override
	public ProductDetail getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
		return getJsonList(callableStatement.getString(i));
	}

	private ProductDetail getJsonList(String content) {
		String jsonBase = new String(Base64Utils.decodeFromString(content));
		if (StringUtils.isNotBlank(jsonBase)) {
			return JSON.parseObject(jsonBase, ProductDetail.class);
		}
		return null;
	}
}
