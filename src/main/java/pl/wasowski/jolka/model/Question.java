package pl.wasowski.jolka.model;

public class Question {
	private long id;
	private String question;
	
	public Question() {
	}
	
	public Question(String question) {
		this.question = question;
	}
	
	public long getId() {
		return id;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
}
