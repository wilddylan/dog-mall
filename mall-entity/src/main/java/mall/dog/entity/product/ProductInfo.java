package mall.dog.entity.product;

import mall.dog.entity.common.Image;
import mall.dog.entity.common.KeyValue;
import mall.dog.entity.common.Question;
import mall.dog.entity.common.Special;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 2018/8/28 mall.dog.entity.product
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class ProductInfo {

	private Integer id;
	@NotNull
	private Integer left;

	// JSON
	@NotNull
	private List<Image> images;

	@NotNull
	private String name;
	@NotNull
	private String description;

	@NotNull
	private String express;
	@NotNull
	private String sendTime;

	@NotNull
	private String specialsExtra;
	// JSON
	@NotNull
	private List<Special> specials;

	// JSON
	@NotNull
	private List<KeyValue> infos;
	// JSON
	@NotNull
	private List<Question> questions;
	// JSON
	@NotNull
	private ProductDetail detail;

	private Integer delete;

	/**
	 * 邀请一人减少多少钱
	 */
	@NotNull
	private Float invitePrice;

	public ProductInfo(Integer id, @NotNull Integer left, @NotNull List<Image> images, @NotNull String name, @NotNull String description, @NotNull String express, @NotNull String sendTime, @NotNull String specialsExtra, @NotNull List<Special> specials, @NotNull List<KeyValue> infos, @NotNull List<Question> questions, @NotNull ProductDetail detail, Integer delete, @NotNull Float invitePrice) {
		this.id = id;
		this.left = left;
		this.images = images;
		this.name = name;
		this.description = description;
		this.express = express;
		this.sendTime = sendTime;
		this.specialsExtra = specialsExtra;
		this.specials = specials;
		this.infos = infos;
		this.questions = questions;
		this.detail = detail;
		this.delete = delete;
		this.invitePrice = invitePrice;
	}

	public ProductInfo() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLeft() {
		return left;
	}

	public void setLeft(Integer left) {
		this.left = left;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExpress() {
		return express;
	}

	public void setExpress(String express) {
		this.express = express;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getSpecialsExtra() {
		return specialsExtra;
	}

	public void setSpecialsExtra(String specialsExtra) {
		this.specialsExtra = specialsExtra;
	}

	public List<Special> getSpecials() {
		return specials;
	}

	public void setSpecials(List<Special> specials) {
		this.specials = specials;
	}

	public List<KeyValue> getInfos() {
		return infos;
	}

	public void setInfos(List<KeyValue> infos) {
		this.infos = infos;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public ProductDetail getDetail() {
		return detail;
	}

	public void setDetail(ProductDetail detail) {
		this.detail = detail;
	}

	public Integer getDelete() {
		return delete;
	}

	public void setDelete(Integer delete) {
		this.delete = delete;
	}

	public Float getInvitePrice() {
		return invitePrice;
	}

	public void setInvitePrice(Float invitePrice) {
		this.invitePrice = invitePrice;
	}
}

