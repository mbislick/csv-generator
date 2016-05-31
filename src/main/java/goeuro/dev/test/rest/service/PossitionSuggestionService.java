package goeuro.dev.test.rest.service;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;

/**
 * Class that consumes the REST api and returns the JSON as a string
 * 
 * @author Mario Bislick
 *
 */
public class PossitionSuggestionService {

	private WebClient client;

	/**
	 * Class constructor
	 */
	public PossitionSuggestionService() {
		System.out.println("[INFO] Initializing the web client");
		this.client = WebClient.create("http://api.goeuro.com/api/v2/position/suggest/en/");
	}

	/**
	 * Consults the REST API and gets the JSON response
	 * 
	 * @param city
	 *            City to consult with the REST API
	 * @return JSON response as a string
	 */
	public String getPositionSuggestion(String city) {
		if (this.client == null) {
			System.out.println("[ERROR] Can't connect to the REST API, there was an error creating the client");
			return null;
		} else {
			System.out.println("[INFO] Connecting to the REST API for the city: "+city);
			return this.client.path(city).accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		}
	}
}
