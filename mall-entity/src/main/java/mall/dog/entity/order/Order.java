package mall.dog.entity.order;

import com.alibaba.fastjson.JSON;
import mall.dog.entity.order.enums.ExpressState;
import mall.dog.entity.order.enums.OrderState;
import mall.dog.entity.product.ProductInfo;
import mall.dog.entity.user.UserInfo;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 2018/8/28 mall.dog.entity.order
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class Order {

	private String openId;
	private String orderId;
	private Integer productId;
	private OrderState orderState;

	private Integer piece;
	private List<String> specials;
	private String specialJsonString;

	private Float price;
	private Float originPrice;

	private Integer invite;
	private List<UserInfo> inviteInfo;

	private Express expressInfo;
	private ExpressState expressState;

	private String shareId;

	// Admin 使用字段
	private ProductInfo productInfo;
	private UserInfo userInfo;

	public Order(String openId, String orderId, Integer productId, OrderState orderState, Integer piece, List<String> specials, String specialJsonString, Float price, Float originPrice, Integer invite, List<UserInfo> inviteInfo, Express expressInfo, ExpressState expressState, String shareId, ProductInfo productInfo, UserInfo userInfo) {
		this.openId = openId;
		this.orderId = orderId;
		this.productId = productId;
		this.orderState = orderState;
		this.piece = piece;
		this.specials = specials;
		this.specialJsonString = specialJsonString;
		this.price = price;
		this.originPrice = originPrice;
		this.invite = invite;
		this.inviteInfo = inviteInfo;
		this.expressInfo = expressInfo;
		this.expressState = expressState;
		this.shareId = shareId;
		this.productInfo = productInfo;
		this.userInfo = userInfo;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Order() {
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

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	public Integer getPiece() {
		return piece;
	}

	public void setPiece(Integer piece) {
		this.piece = piece;
	}

	public List<String> getSpecials() {
		if (StringUtils.isNotBlank(this.specialJsonString)) {
			return JSON.parseArray(this.specialJsonString, String.class);
		}
		return specials;
	}

	public void setSpecials(List<String> specials) {
		this.specials = specials;
		this.specialJsonString = JSON.toJSONString(specials);
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getOriginPrice() {
		return originPrice;
	}

	public void setOriginPrice(Float originPrice) {
		this.originPrice = originPrice;
	}

	public Integer getInvite() {
		return invite;
	}

	public void setInvite(Integer invite) {
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

	public ExpressState getExpressState() {
		return expressState;
	}

	public void setExpressState(ExpressState expressState) {
		this.expressState = expressState;
	}

	public String getSpecialJsonString() {
		return specialJsonString;
	}

	public void setSpecialJsonString(String specialJsonString) {
		this.specialJsonString = specialJsonString;
	}

	public String getShareId() {
		return shareId;
	}

	public void setShareId(String shareId) {
		this.shareId = shareId;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
}
