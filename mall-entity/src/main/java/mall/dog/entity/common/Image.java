package mall.dog.entity.common;

/**
 * 2018/8/28 mall.dog.entity.common
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class Image {

	private String key;
	private String url;
	private Float width;
	private Float height;

	public Image(String key, String url, Float width, Float height) {
		this.key = key;
		this.url = url;
		this.width = width;
		this.height = height;
	}

	public Image() {
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Float getWidth() {
		return width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}
}
