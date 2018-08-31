package mall.dog.repo.order;

import mall.dog.entity.order.Express;
import mall.dog.entity.order.Order;
import mall.dog.entity.user.UserInfo;
import mall.dog.repo.handler.ExpressEnumTypeHandler;
import mall.dog.repo.handler.JsonArrayTypeHandler;
import mall.dog.repo.handler.JsonTypeHandler;
import mall.dog.repo.handler.OrderEnumTypeHandler;
import mall.dog.repo.order.provider.OrderSQLProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 2018/8/29 mall.dog.repo.order
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@Repository
public interface OrderMapper {

	@Insert(
			"INSERT INTO t_order (open_id, order_id, order_state, piece, price, invite, invite_info, product_id, express_info, express_state, specials, origin_price, share_id)" +
					"VALUES (" +
					"#{order.openId}," +
					"#{order.orderId}," +
					"#{order.orderState, typeHandler=mall.dog.repo.handler.OrderEnumTypeHandler}," +
					"#{order.piece}," +
					"#{order.price}," +
					"#{order.invite}," +
					"#{order.inviteInfo, typeHandler=mall.dog.repo.handler.JsonArrayTypeHandler}," +
					"#{order.productId}," +
					"#{order.expressInfo, typeHandler=mall.dog.repo.handler.JsonTypeHandler}," +
					"#{order.expressState, typeHandler=mall.dog.repo.handler.ExpressEnumTypeHandler}," +
					"#{order.specialJsonString}," +
					"#{order.originPrice}," +
					"#{order.shareId}" +
					")"
	)
	int create(@Param("order") Order order);

	@Select(
			"SELECT * FROM t_order where open_id = #{openId} order by create_time desc"
	)
	@Results(
			id = "orderMap",
			value = {
					@Result(column = "open_id", property = "openId"),
					@Result(column = "order_id", property = "orderId"),
					@Result(column = "product_id", property = "productId"),
					@Result(column = "share_id", property = "shareId"),
					@Result(column = "origin_price", property = "originPrice"),
					@Result(column = "order_state", property = "orderState", typeHandler = OrderEnumTypeHandler.class),
					@Result(column = "invite_info", property = "inviteInfo", typeHandler = JsonArrayTypeHandler.class),
					@Result(column = "express_state", property = "expressState", typeHandler = ExpressEnumTypeHandler.class),
					@Result(column = "express_info", property = "expressInfo", typeHandler = JsonTypeHandler.class),
					@Result(column = "specials", property = "specialJsonString")
			}
	)
	List<Order> query(@Param("openId") String openId);

	@SelectProvider(type = OrderSQLProvider.class, method = "queryList")
	@ResultMap("orderMap")
	List<Order> queryList(Integer orderState, String orderId);

	@SelectProvider(type = OrderSQLProvider.class, method = "queryOne")
	@ResultMap("orderMap")
	Order queryOne(String orderId);

	@Update(
			"UPDATE t_order SET order_state = #{orderState} where order_id = #{orderId}"
	)
	int updateState(@Param("orderId") String orderId, @Param("orderState") Integer orderState);

	@UpdateProvider(type = OrderSQLProvider.class, method = "updateExpress")
	int updateExpress(String orderId, Express express, Integer expressState);

	@UpdateProvider(type = OrderSQLProvider.class, method = "updateInviteInfo")
	void updateInviteInfo(String orderId, List<UserInfo> inviteList, int inviteNumber);
}
