package mall.dog.service.admin.entity;

import javax.validation.constraints.NotNull;

/**
 * 2018/8/29 mall.dog.service.admin.entity
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class UserListRequest {

	@NotNull
	private Integer pageNo;
	@NotNull
	private Integer pageSize;
	/**
	 * 搜索使用
	 */
	private String name;

	public UserListRequest(Integer pageNo, Integer pageSize, String name) {
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.name = name;
	}

	public UserListRequest() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
