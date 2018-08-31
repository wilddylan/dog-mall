package mall.dog.web.controller.product;

import mall.dog.entity.product.ProductInfo;
import mall.dog.entity.response.Entity;
import mall.dog.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 2018/8/26 mall.dog.web.controller
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
@Valid
@RestController
@RequestMapping("product")
public class HotProductController {

	private final ProductService productService;

	@Autowired
	public HotProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("hot")
	public Entity queryProduct() {
		return productService.query();
	}

	@PostMapping("create")
	public Entity createProduct(@RequestBody ProductInfo product) {
		return productService.insert(product);
	}

}
