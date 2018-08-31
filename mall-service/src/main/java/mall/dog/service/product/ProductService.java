package mall.dog.service.product;

import com.alibaba.fastjson.JSON;
import mall.dog.common.tools.NullUtil;
import mall.dog.entity.common.*;
import mall.dog.entity.product.ProductDetail;
import mall.dog.entity.product.ProductInfo;
import mall.dog.entity.response.Entity;
import mall.dog.repo.product.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 2018/8/28 mall.dog.service.product
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@Service
public class ProductService {

	private final ProductMapper productMapper;

	@Autowired
	public ProductService(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}

	public Entity query() {
		// 查询热门商品，展示在首页的
		ProductInfo productInfo = productMapper.query();
		if (!NullUtil.isNull(productInfo)) {
			return Entity.Success(productInfo);
		}
		return Entity.Failure();
	}

	public ProductInfo query(Integer productId) {
		// 查询热门商品，展示在首页的
		ProductInfo productInfo = productMapper.queryOne(productId);
		if (!NullUtil.isNull(productInfo)) {
			return productInfo;
		}
		return null;
	}

	public Entity insert(ProductInfo productInfo) {
		int result = productMapper.insert(productInfo);
		if (result == 1) {
			return Entity.Success();
		}
		return Entity.Failure();
	}

}
