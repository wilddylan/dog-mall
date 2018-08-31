package mall.dog.entity.admin;

/**
 * 2018/8/30 mall.dog.entity.admin
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class OrderAnalysis {

	private Integer orderCreateNumberYesterday;
	private Integer orderCreateNumberToday;
	private Integer orderCreateNumberAll;

	private Float orderPriceYesterday;
	private Float orderPriceToday;
	private Float orderPriceAll;

	public OrderAnalysis(Integer orderCreateNumberYesterday, Integer orderCreateNumberToday, Integer orderCreateNumberAll, Float orderPriceYesterday, Float orderPriceToday, Float orderPriceAll) {
		this.orderCreateNumberYesterday = orderCreateNumberYesterday;
		this.orderCreateNumberToday = orderCreateNumberToday;
		this.orderCreateNumberAll = orderCreateNumberAll;
		this.orderPriceYesterday = orderPriceYesterday;
		this.orderPriceToday = orderPriceToday;
		this.orderPriceAll = orderPriceAll;
	}

	public OrderAnalysis() {
	}

	public Integer getOrderCreateNumberYesterday() {
		return orderCreateNumberYesterday;
	}

	public void setOrderCreateNumberYesterday(Integer orderCreateNumberYesterday) {
		this.orderCreateNumberYesterday = orderCreateNumberYesterday;
	}

	public Integer getOrderCreateNumberToday() {
		return orderCreateNumberToday;
	}

	public void setOrderCreateNumberToday(Integer orderCreateNumberToday) {
		this.orderCreateNumberToday = orderCreateNumberToday;
	}

	public Integer getOrderCreateNumberAll() {
		return orderCreateNumberAll;
	}

	public void setOrderCreateNumberAll(Integer orderCreateNumberAll) {
		this.orderCreateNumberAll = orderCreateNumberAll;
	}

	public Float getOrderPriceYesterday() {
		return orderPriceYesterday;
	}

	public void setOrderPriceYesterday(Float orderPriceYesterday) {
		this.orderPriceYesterday = orderPriceYesterday;
	}

	public Float getOrderPriceToday() {
		return orderPriceToday;
	}

	public void setOrderPriceToday(Float orderPriceToday) {
		this.orderPriceToday = orderPriceToday;
	}

	public Float getOrderPriceAll() {
		return orderPriceAll;
	}

	public void setOrderPriceAll(Float orderPriceAll) {
		this.orderPriceAll = orderPriceAll;
	}
}
