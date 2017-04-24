package pl.wasowski.jolka.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.wasowski.jolka.services.PuzzleService;

public class Puzzle {
	private int id;
	private int number;
	private List<Question> questions = new ArrayList<Question>();
	
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
	
	public int getCount() {
		return questions.size();
	}
	
	public List<Question> getQuestions() {
		return questions;
	}
	
	public void addQuestion(Question question) {
		questions.add(question);
	}
	
	public void save() {
		service.save(this);
	}
}