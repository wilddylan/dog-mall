package mall.dog.entity.admin;

import org.apache.commons.lang3.StringUtils;

/**
 * 2018/8/30 mall.dog.entity.admin
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class UserAnalysis {

	private Integer signUpNumberYesterday;
	private Integer signUpNumberToday;
	private Integer signUpNumberAll;

	public UserAnalysis(Integer signUpNumberYesterday, Integer signUpNumberToday, Integer signUpNumberAll) {
		this.signUpNumberYesterday = signUpNumberYesterday;
		this.signUpNumberToday = signUpNumberToday;
		this.signUpNumberAll = signUpNumberAll;
	}

	public UserAnalysis() {
	}

	public Integer getSignUpNumberYesterday() {
		return signUpNumberYesterday;
	}

	public void setSignUpNumberYesterday(Integer signUpNumberYesterday) {
		this.signUpNumberYesterday = signUpNumberYesterday;
	}

	public Integer getSignUpNumberToday() {
		return signUpNumberToday;
	}

	public void setSignUpNumberToday(Integer signUpNumberToday) {
		this.signUpNumberToday = signUpNumberToday;
	}

	public Integer getSignUpNumberAll() {
		return signUpNumberAll;
	}

	public void setSignUpNumberAll(Integer signUpNumberAll) {
		this.signUpNumberAll = signUpNumberAll;
	}
}
