package mall.dog.service.order.entity;

import mall.dog.entity.common.Special;
import mall.dog.entity.order.Address;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 2018/8/28 mall.dog.service.order.entity
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class CreateOrderRequest {

	@NotNull
	private Integer productId;
	@NotNull
	private Integer piece;
	@NotNull
	private List<Special> specials;
	@NotNull
	private String token;
	@NotNull
	private Address address;

	private String shareOrderId;

	public CreateOrderRequest(@NotNull Integer productId, @NotNull Integer piece, @NotNull List<Special> specials, @NotNull String token, @NotNull Address address, String shareOrderId) {
		this.productId = productId;
		this.piece = piece;
		this.specials = specials;
		this.token = token;
		this.address = address;
		this.shareOrderId = shareOrderId;
	}

	public CreateOrderRequest() {
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getPiece() {
		return piece;
	}

	public void setPiece(Integer piece) {
		this.piece = piece;
	}

	public List<Special> getSpecials() {
		return specials;
	}

	public void setSpecials(List<Special> specials) {
		this.specials = specials;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getShareOrderId() {
		return shareOrderId;
	}

	public void setShareOrderId(String shareOrderId) {
		this.shareOrderId = shareOrderId;
	}
}
