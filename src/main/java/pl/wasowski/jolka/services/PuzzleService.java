package pl.wasowski.jolka.services;

import java.util.List;

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
		List<Puzzle> list = getBuilder().append("puzzle/data").getList(Puzzle.class);
		ObservableList<Puzzle> observable = FXCollections.observableArrayList(list);
		return observable;
	}
	
	public long save(Puzzle puzzle) {
		Response response = getBuilder().append("puzzle/add").post(puzzle);
		return response.readEntity(Long.class);
	}
	
	public void remove(Puzzle puzzle) {
		Response response = getBuilder().append("puzzle").append(puzzle.getId()).delete();
	}
}
