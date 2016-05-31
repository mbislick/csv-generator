package goeuro.dev.test.csv.generator;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Class that processes a JSON array object and generates a CSV file separated
 * by semicolon. All of the elements in the JSON array must have an _id, name, type,
 * geo_position.latitude and geo_position.longitude elements, otherwise it won't
 * be generate the csv file
 * 
 * @author mariobislick
 *
 */
public class CsvGenerator {

	/**
	 * Class constructor
	 */
	public CsvGenerator() {
	}
	
	/**
	 * Gets a formatted string with the position suggestion's values that should
	 * be displayed in the CSV file
	 * 
	 * @param suggestion
	 *            JSON object of a position suggestion
	 * @return String of a position suggestions object to store in the CSV file
	 *         in case that there was no error reading the JSON object,
	 *         otherwise null
	 */
	private String suggestionToString(JSONObject suggestion){
		try{
			JSONObject geoPosition = suggestion.getJSONObject("geo_position");
			return suggestion.getBigInteger(PositionSuggestionMapEnum.ID.toString()) + ","
				+ suggestion.getString(PositionSuggestionMapEnum.NAME.toString()) + ","
				+ suggestion.getString(PositionSuggestionMapEnum.TYPE.toString()) + ","
				+ geoPosition.getDouble(PositionSuggestionMapEnum.LATITUDE.toString()) + ","
				+ geoPosition.getDouble(PositionSuggestionMapEnum.LONGITUDE.toString());
		} catch(JSONException e) {
			System.out.println("[ERROR] The JSON object is invalid. "+e.getMessage());
			return null;
		}
	};

	/**
	 * Generates a semicolon separated CSV file with the values stored in a
	 * given JSON array. Each of the JSON array's objects should have at least
	 * the following structure: <code>
	 * { "_id" : Long,
	 *   "name": String,
	 *   "type": String,
	 *   "geo_position": {
	 *   	"latitude": Decimal,
	 *   	"longitude": Decimal
	 *   }
	 * }
	 * </code>
	 * 
	 * @param filename
	 *            Name of the CSV file to generate
	 * @param positionSuggestionJson
	 *            JSON array containing the response from the REST API
	 */
	public void generateFile(String filename, String positionSuggestionJson) {
		List<String> lines = new ArrayList<String>();
		try {
			System.out.println("[INFO] Processing API's JSON response");
			JSONArray jsonArray = new JSONArray(positionSuggestionJson);
			
			System.out.println("[INFO] Generating semicolon separated CSV file");
			if (jsonArray != null && jsonArray.length() > 0) {
				for (int i = 0, size = jsonArray.length(); i < size; i++) {
					JSONObject suggestion = jsonArray.getJSONObject(i);
					if (suggestion != null) {
						String  csvLine = suggestionToString(suggestion);
						if (csvLine != null) {lines.add(csvLine);}
					}
				}
			} else {
				System.out.println("[INFO] There are no suggestions to add to the CSV file");
			}
			
			Path file = Paths.get(filename + ".csv");
			System.out.println("[INFO] Writing "+lines.size()+" suggestions into the file ["+filename+"]");
			Files.write(file, lines, Charset.forName("UTF-8"));
			System.out.println("[INFO] CSV file generated succesfully");
		} catch (IOException e) {
			System.out.println("[ERROR] The following error was detected while generating the CSV file: "+e.getMessage());
		} catch (JSONException e) {
			System.out.println("[ERROR] The following error was detected while generating the CSV file: "+e.getMessage());
		}
	}
	
	/**
	 * Enum maping the position suggestion JSON objects elements with
	 * their key
	 * 
	 * @author Mario Bislick
	 *
	 */
	private enum PositionSuggestionMapEnum {
		ID ("_id"),
		NAME("name"),
		TYPE("type"),
		LATITUDE("latitude"),
		LONGITUDE("longitude");
		
		private String key;
		
		private PositionSuggestionMapEnum(String s){
			this.key = s;
		}
		
		public String toString(){
			return this.key;
		}
	}
}
