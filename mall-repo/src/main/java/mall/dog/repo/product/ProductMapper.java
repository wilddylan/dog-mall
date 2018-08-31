package mall.dog.repo.product;

import mall.dog.entity.common.Image;
import mall.dog.entity.product.ProductInfo;
import mall.dog.repo.handler.JsonArrayTypeHandler;
import mall.dog.repo.handler.JsonTypeHandler;
import mall.dog.repo.handler.ProductDetailHandler;
import mall.dog.repo.product.provider.ProductSQLProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 2018/8/28 mall.dog.repo.product
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@Repository
public interface ProductMapper {

	@Select(
			"SELECT * FROM t_product where is_delete = 0 limit 1"
	)
	@Results(
			id = "productMap",
			value = {
					@Result(column = "specials_extra", property = "specialsExtra"),
					@Result(column = "images", property = "images", javaType = Image.class, typeHandler = JsonArrayTypeHandler.class),
					@Result(column = "specials", property = "specials", typeHandler = JsonArrayTypeHandler.class),
					@Result(column = "infos", property = "infos", typeHandler = JsonArrayTypeHandler.class),
					@Result(column = "questions", property = "questions", typeHandler = JsonArrayTypeHandler.class),
					@Result(column = "detail", property = "detail", typeHandler = ProductDetailHandler.class),
					@Result(column = "invite_price", property = "invitePrice"),
					@Result(column = "is_delete", property = "delete", javaType = Integer.class)
			}
	)
	ProductInfo query();

	@Select(
			"SELECT * FROM t_product where is_delete = 0 and id = #{productId} limit 1"
	)
	@ResultMap("productMap")
	ProductInfo queryOne(@Param("productId") Integer productId);

	@Insert(
			"INSERT INTO t_product (`left`, `images`, `name`, `description`, `express`, `sendTime`, `specials_extra`, `specials`, `infos`, `questions`, `detail`, invite_price) VALUES (" +
					"#{product.left}," +
					"#{product.images, typeHandler=mall.dog.repo.handler.JsonArrayTypeHandler}," +
					"#{product.name}," +
					"#{product.description}," +
					"#{product.express}," +
					"#{product.sendTime}," +
					"#{product.specialsExtra}," +
					"#{product.specials, typeHandler=mall.dog.repo.handler.JsonArrayTypeHandler}," +
					"#{product.infos, typeHandler=mall.dog.repo.handler.JsonArrayTypeHandler}," +
					"#{product.questions, typeHandler=mall.dog.repo.handler.JsonArrayTypeHandler}," +
					"#{product.detail, jdbcType=VARCHAR, typeHandler=mall.dog.repo.handler.ProductDetailHandler}," +
					"#{product.invitePrice}" +
					")"
	)
	int insert(@Param("product") ProductInfo productInfo);

	@SelectProvider(type = ProductSQLProvider.class, method = "queryList")
	@ResultMap("productMap")
	List<ProductInfo> queryList(String productId);

	@Update(
			"update t_product set is_delete = #{delete} where id = #{productId}"
	)
	int delete(@Param("productId") String productId, @Param("delete") Integer delete);

	@UpdateProvider(type = ProductSQLProvider.class, method = "update")
	int update(ProductInfo productInfo);
}
