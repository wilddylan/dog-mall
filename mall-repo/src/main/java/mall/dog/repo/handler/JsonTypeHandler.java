package mall.dog.repo.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import mall.dog.common.tools.NullUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 2018/8/28 mall.dog.repo.handler
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@MappedJdbcTypes(value = JdbcType.VARCHAR, includeNullJdbcType = true)
public class JsonTypeHandler<T> extends BaseTypeHandler<T> {
	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int i, T jsonList, JdbcType jdbcType) throws SQLException {
		preparedStatement.setString(i,
				JSON.toJSONString(jsonList,
						SerializerFeature.WriteNullStringAsEmpty,
						SerializerFeature.WriteNullNumberAsZero,
						SerializerFeature.WriteNullBooleanAsFalse,
						SerializerFeature.WriteNullListAsEmpty,
						SerializerFeature.QuoteFieldNames,
						SerializerFeature.WriteDateUseDateFormat,
						SerializerFeature.DisableCircularReferenceDetect,
						SerializerFeature.WriteEnumUsingToString,
						SerializerFeature.WriteClassName)
		);
	}

	@Override
	public T getNullableResult(ResultSet resultSet, String s) throws SQLException {
		return getJsonList(resultSet.getString(s));
	}

	@Override
	public T getNullableResult(ResultSet resultSet, int i) throws SQLException {
		return getJsonList(resultSet.getString(i));
	}

	@Override
	public T getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
		return getJsonList(callableStatement.getString(i));
	}

	private T getJsonList(String content) {
		if (StringUtils.isNotBlank(content)) {
			return JSON.parseObject(content, new com.alibaba.fastjson.TypeReference<T>(){});
		}
		return null;
	}
}
