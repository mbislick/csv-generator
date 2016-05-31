package goeuro.dev.test.csv;

import goeuro.dev.test.csv.generator.CsvGenerator;
import goeuro.dev.test.rest.service.PossitionSuggestionService;

/**
 * Main class of the application. It consults the REST API and then generates
 * the CSV file if no error was detected
 * 
 * @author Mario Bislick
 *
 */
public class CsvGeneratorMainApp {
	public static void main(String args[]) throws Exception {

		String city = args[0];
		System.out.println(city);
		CsvGenerator generator = new CsvGenerator();
		PossitionSuggestionService psService = new PossitionSuggestionService();
		String suggestion = psService.getPositionSuggestion(city);
		
		if (suggestion != null) {
				generator.generateFile(city, suggestion);
		}
	}
}
