package mall.dog.repo.admin;

import mall.dog.entity.admin.OrderAnalysis;
import mall.dog.entity.admin.ProductAnalysis;
import mall.dog.entity.admin.UserAnalysis;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 2018/8/29 mall.dog.repo.admin
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@Repository
public interface AdminMapper {

	@Select(
			"SELECT count(*) FROM t_order WHERE DATE_FORMAT( create_time,'%Y-%m-%d') = DATE_FORMAT(CURDATE()-1,'%Y-%m-%d')\n" +
					"union \n" +
					"select count(*) from t_order where DATE_FORMAT( create_time,'%Y-%m-%d') = DATE_FORMAT(NOW(), '%Y-%m-%d')\n" +
					"union \n" +
					"select count(*) from t_order"
	)
	List<Integer> analysisOrderNumber();

	@Select(
			"SELECT SUM(origin_price) FROM t_order WHERE DATE_FORMAT( create_time,'%Y-%m-%d') = DATE_FORMAT(CURDATE()-1,'%Y-%m-%d')\n" +
					"union all \n" +
					"SELECT SUM(origin_price) FROM t_order WHERE DATE_FORMAT( create_time,'%Y-%m-%d') = DATE_FORMAT(NOW(),'%Y-%m-%d')\n" +
					"union all \n" +
					"SELECT SUM(origin_price) FROM t_order"
	)
	List<Float> analysisOrderPrice();

	@Select(
			"SELECT count(*) FROM t_user WHERE DATE_FORMAT( create_time,'%Y-%m-%d') = DATE_FORMAT(CURDATE()-1,'%Y-%m-%d')\n" +
					"union all\n" +
					"select count(*) from t_user where DATE_FORMAT( create_time,'%Y-%m-%d') = DATE_FORMAT(NOW(), '%Y-%m-%d')\n" +
					"union all\n" +
					"select count(*) from t_user"
	)
	List<Integer> analysisUser();

	@Select(
			"select count(*) from t_product"
	)
	int analysisProduct();
}
