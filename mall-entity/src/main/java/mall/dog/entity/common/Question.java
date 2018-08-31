package mall.dog.entity.common;

/**
 * 2018/8/28 mall.dog.entity.common
 *
 * @author dylan
 * Home: http://blog.devdylan.cn
 */
public class Question {

	private String key;
	private String question;
	private String anwser;

	public Question(String key, String question, String anwser) {
		this.key = key;
		this.question = question;
		this.anwser = anwser;
	}

	public Question() {
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnwser() {
		return anwser;
	}

	public void setAnwser(String anwser) {
		this.anwser = anwser;
	}
}
