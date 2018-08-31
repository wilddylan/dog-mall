package mall.dog.repo.handler;

import mall.dog.entity.order.enums.OrderState;
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
public class OrderEnumTypeHandler extends BaseTypeHandler<OrderState> {

	private OrderState getValuedEnum(int value) {
		switch (value) {
			case 0:
				return OrderState.WAIT_PAY;
			case 1:
				return OrderState.WAIT_SEND;
			case 2:
				return OrderState.WAIT_RECEIVE;
			case 3:
				return OrderState.END;
			default:
				return OrderState.END;
		}
	}

	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int i, OrderState e, JdbcType jdbcType) throws SQLException {
		preparedStatement.setInt(i, e.getValue());
	}

	@Override
	public OrderState getNullableResult(ResultSet resultSet, String s) throws SQLException {
		return getValuedEnum(resultSet.getInt(s));
	}

	@Override
	public OrderState getNullableResult(ResultSet resultSet, int i) throws SQLException {
		return getValuedEnum(resultSet.getInt(i));
	}

	@Override
	public OrderState getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
		return getValuedEnum(callableStatement.getInt(i));
	}
}
