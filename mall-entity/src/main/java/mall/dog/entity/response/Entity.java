package mall.dog.entity.response;

import mall.dog.common.constants.MallConstant;

import java.util.List;

/**
 * 2018/8/26 mall.dog.entity.response
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class Entity <T> {

	private String message;
	private Integer code;
	private T data;

	private Integer total;
	private Object datas;

	public static<T> Entity<T> Success() {
		return new Entity<>(MallConstant.SUCCESS_MESSAGE, MallConstant.SUCCESS_CODE);
	}

	public static Entity Success(Object data) {
		return Success()
				.withData(data);
	}

	public static Entity Success(Object datas, Integer total) {
		return Success()
				.withDatas(datas)
				.withTotal(total);
	}

	public static<T> Entity<T> Failure() {
		return new Entity<>(MallConstant.FAILURE_MESSAGE, MallConstant.FAILURE_CODE);
	}

	public static<T> Entity<T> NeedLogin() {
		return new Entity<>(MallConstant.LOGIN_MESSAGE, MallConstant.NEED_LOGIN);
	}

	public static<T> Entity<T> Failure(Integer code) {
		return new Entity<>(MallConstant.FAILURE_MESSAGE, code);
	}

	public static<T> Entity<T> Failure(String message, Integer code) {
		return new Entity<>(message, code);
	}

	private Entity(String message, Integer code) {
		this.message = message;
		this.code = code;
	}

	private Entity withData(T data) {
		this.data = data;
		return this;
	}

	public Entity withDatas(Object datas) {
		this.datas = datas;
		return this;
	}

	private Entity withTotal(Integer total) {
		this.total = total;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Object getDatas() {
		return datas;
	}

	public void setDatas(Object datas) {
		this.datas = datas;
	}
}
