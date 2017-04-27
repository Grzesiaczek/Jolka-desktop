package pl.wasowski.jolka.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import pl.wasowski.jolka.services.PuzzleService;

public class Puzzle {
	private int id;
	private int number;
	private int questionsCount;
	
	private ObservableList<Question> questions = FXCollections.observableArrayList();
	
	{
		questions.addListener(new ListChangeListener<Question>() {
			@Override
			public void onChanged(ListChangeListener.Change<? extends Question> c) {
				questionsCount = questions.size();
			}
		});
	}
	
	@Autowired
	PuzzleService service;
	
	public Puzzle() {
	}
	
	public Puzzle(int number) {
		this.number = number;
	}
	
	public int getId() {
		return id;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getQuestionsCount() {
		return questionsCount;
	}
	
	public ObservableList<Question> getQuestions() {
		return questions;
	}
	
	public void addQuestion(Question question) {
		questions.add(question);
	}
	
	public void setQuestions(List<Question> questions) {
		this.questions = FXCollections.observableArrayList(questions);
	}
	
	public void save() {
		service.save(this);
	}
}