package pl.wasowski.jolka.services;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.wasowski.jolka.model.Puzzle;

@Component
public class PuzzleService extends DataService {
	public Puzzle get(long id) {
		Response response =  getBuilder().append("puzzle").append(id).get();
		return response.readEntity(Puzzle.class);
	}
	
	public ObservableList<Puzzle> getData() {
		ObservableList<Puzzle> list = FXCollections.observableArrayList();
		Response response = getBuilder().append("puzzle/data").get();
		System.out.println(response.readEntity(String.class));
		return list;
	}
	
	public long save(Puzzle puzzle) {
		Response response = getBuilder().append("puzzle/add").post(puzzle);
		return response.readEntity(Long.class);
	}
}
