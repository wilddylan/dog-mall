package mall.dog.repo.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import mall.dog.common.tools.NullUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.*;

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
public class JsonArrayTypeHandler<T> extends BaseTypeHandler<List<T>> {
	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int i, List<T> jsonList, JdbcType jdbcType) throws SQLException {
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
	public List<T> getNullableResult(ResultSet resultSet, String s) throws SQLException {
		return getJsonList(resultSet.getString(s));
	}

	@Override
	public List<T> getNullableResult(ResultSet resultSet, int i) throws SQLException {
		return getJsonList(resultSet.getString(i));
	}

	@Override
	public List<T> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
		return getJsonList(callableStatement.getString(i));
	}

	private List<T> getJsonList(String content) {
		List<T> jsonResult = new ArrayList<>();

		if (StringUtils.isNotBlank(content)) {
			List<T> jsonList = JSON.parseObject(content, new com.alibaba.fastjson.TypeReference<List<T>>(){});
			if (!NullUtil.isNull(jsonList)) {
				jsonResult.addAll(jsonList);
			}
		}

		return jsonResult;
	}
}
