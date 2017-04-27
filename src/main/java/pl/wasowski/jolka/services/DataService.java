package pl.wasowski.jolka.services;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public abstract class DataService {
	private final Client client = ClientBuilder.newClient();
	private final String host = "http://localhost:8080";
	
	protected UrlBuilder getBuilder() {
		return new UrlBuilder();
	}
	
	protected class UrlBuilder {
		private StringBuilder builder;
		
		private UrlBuilder() {
			builder = new StringBuilder(host);
		}
		
		UrlBuilder append(Object value) {
			builder.append('/').append(value);
			return this;
		}
		
		Response get() {
			return target().request(MediaType.APPLICATION_JSON).get();
		}
		
		<T> List<T> getList(Class<T> cls) {
			return target().request(MediaType.APPLICATION_JSON).get(new GenericType<List<T>>() {});
		}
		
		Response post(Object obj) {
			return target().request(MediaType.APPLICATION_JSON).post(Entity.json(obj));
		}
		
		Response delete() {
			return target().request().delete();
		}
		
		WebTarget target() {
			return client.target(builder.toString());
		}
	}
}
