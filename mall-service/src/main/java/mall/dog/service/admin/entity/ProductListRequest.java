package mall.dog.service.admin.entity;

import mall.dog.entity.order.Express;
import mall.dog.entity.product.ProductInfo;
import mall.dog.service.admin.user.entity.AdminUserLoginRequest;

import javax.validation.constraints.NotNull;

/**
 * 2018/8/29 mall.dog.service.admin.entity
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class ProductListRequest extends AdminUserLoginRequest {
	// 删除使用
	private String productId;
	@NotNull
	private Integer pageNo;
	@NotNull
	private Integer pageSize;

	// 更新、创建商品使用
	private ProductInfo productInfo;

	private Integer delete;

	public ProductListRequest(String username, String password) {
		super(username, password);
	}

	public ProductListRequest(String username, String password, String productId, @NotNull Integer pageNo, @NotNull Integer pageSize, ProductInfo productInfo, Integer delete) {
		super(username, password);
		this.productId = productId;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.productInfo = productInfo;
		this.delete = delete;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public Integer getDelete() {
		return delete;
	}

	public void setDelete(Integer delete) {
		this.delete = delete;
	}
}
