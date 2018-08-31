package mall.dog.repo.handler;

import mall.dog.entity.order.enums.ExpressState;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 2018/8/29 mall.dog.repo.handler
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@MappedJdbcTypes(value = JdbcType.INTEGER, includeNullJdbcType = true)
public class ExpressEnumTypeHandler extends BaseTypeHandler<ExpressState> {

	private ExpressState getValuedEnum(int value) {
		if (value == 0) {
			return ExpressState.NONE;
		} else {
			return ExpressState.SENT;
		}
	}

	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int i, ExpressState e, JdbcType jdbcType) throws SQLException {
		preparedStatement.setInt(i, e.getValue());
	}

	@Override
	public ExpressState getNullableResult(ResultSet resultSet, String s) throws SQLException {
		return getValuedEnum(resultSet.getInt(s));
	}

	@Override
	public ExpressState getNullableResult(ResultSet resultSet, int i) throws SQLException {
		return getValuedEnum(resultSet.getInt(i));
	}

	@Override
	public ExpressState getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
		return getValuedEnum(callableStatement.getInt(i));
	}
}
