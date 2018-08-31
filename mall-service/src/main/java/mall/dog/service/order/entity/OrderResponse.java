package mall.dog.service.order.entity;

import mall.dog.entity.order.Express;
import mall.dog.entity.order.enums.ExpressState;
import mall.dog.entity.order.enums.OrderState;
import mall.dog.entity.product.ProductInfo;
import mall.dog.entity.user.UserInfo;

import java.util.List;

/**
 * 2018/8/29 mall.dog.service.order.entity
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class OrderResponse {

	private String openId;
	private String orderId;
	private Integer productId;
	private String orderState;

	private Integer piece;
	private List<String> specials;

	private String price;
	private Float originPrice;

	private String invite;
	private List<UserInfo> inviteInfo;

	private Express expressInfo;
	private String expressState;

	private ProductInfo productInfo;

	public OrderResponse(String openId, String orderId, Integer productId, String orderState, Integer piece, List<String> specials, String price, Float originPrice, String invite, List<UserInfo> inviteInfo, Express expressInfo, String expressState, ProductInfo productInfo) {
		this.openId = openId;
		this.orderId = orderId;
		this.productId = productId;
		this.orderState = orderState;
		this.piece = piece;
		this.specials = specials;
		this.price = price;
		this.originPrice = originPrice;
		this.invite = invite;
		this.inviteInfo = inviteInfo;
		this.expressInfo = expressInfo;
		this.expressState = expressState;
		this.productInfo = productInfo;
	}

	public OrderResponse() {
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public Integer getPiece() {
		return piece;
	}

	public void setPiece(Integer piece) {
		this.piece = piece;
	}

	public List<String> getSpecials() {
		return specials;
	}

	public void setSpecials(List<String> specials) {
		this.specials = specials;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Float getOriginPrice() {
		return originPrice;
	}

	public void setOriginPrice(Float originPrice) {
		this.originPrice = originPrice;
	}

	public String getInvite() {
		return invite;
	}

	public void setInvite(String invite) {
		this.invite = invite;
	}

	public List<UserInfo> getInviteInfo() {
		return inviteInfo;
	}

	public void setInviteInfo(List<UserInfo> inviteInfo) {
		this.inviteInfo = inviteInfo;
	}

	public Express getExpressInfo() {
		return expressInfo;
	}

	public void setExpressInfo(Express expressInfo) {
		this.expressInfo = expressInfo;
	}

	public String getExpressState() {
		return expressState;
	}

	public void setExpressState(String expressState) {
		this.expressState = expressState;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}
}
