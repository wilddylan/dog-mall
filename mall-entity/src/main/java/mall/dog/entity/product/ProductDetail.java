package mall.dog.entity.product;

import mall.dog.entity.common.Image;

import java.util.List;

/**
 * 2018/8/28 mall.dog.entity.product
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class ProductDetail {

	private String rich;
	private List<Image> images;

	public ProductDetail(String rich, List<Image> images) {
		this.rich = rich;
		this.images = images;
	}

	public ProductDetail() {
	}

	public String getRich() {
		return rich;
	}

	public void setRich(String rich) {
		this.rich = rich;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
}
