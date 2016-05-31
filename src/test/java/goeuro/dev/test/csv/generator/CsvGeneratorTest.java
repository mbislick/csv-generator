package goeuro.dev.test.csv.generator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.nio.file.Path;

import org.json.JSONException;
import org.junit.Test;

/**
 * Test class for the CSV generator
 * @author Mario Bislick
 *
 */
public class CsvGeneratorTest {

	@Test
	public void constructorTest() {
		CsvGenerator generator = new CsvGenerator();

		assertNotNull(generator);
	}

	/**
	 * Validates the successful generation of a CSV file without any errors
	 * detected
	 * 
	 * @throws URISyntaxException
	 * @throws JSONException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@Test
	public void generateCsvFileSuccessTest()
			throws URISyntaxException, JSONException, UnsupportedEncodingException, IOException {
		String filename = "Test1";
		File csvFile = new File(filename + ".csv");
		Path csvPath = java.nio.file.Paths.get(csvFile.toURI());
		CsvGenerator generator = new CsvGenerator();

		generator.generateFile(filename, getRestApiResponse(filename));

		assertNotNull(generator);
		assertTrue(java.nio.file.Files.exists(csvPath));
		assertTrue(validateResultFile(filename));
		java.nio.file.Files.deleteIfExists(csvPath);
	}

	/**
	 * Validates the detection of malformed JSON responses from the REST API,
	 * and that no CSV file was created when this happens
	 * 
	 * @throws URISyntaxException
	 * @throws JSONException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@Test
	public void generateCsvFileFailedInvalidJsonArrayTest()
			throws URISyntaxException, JSONException, UnsupportedEncodingException, IOException {
		String filename = "Test2";
		File csvFile = new File(filename + ".csv");
		Path csvPath = java.nio.file.Paths.get(csvFile.toURI());
		CsvGenerator generator = new CsvGenerator();

		generator.generateFile(filename, getRestApiResponse(filename));

		assertNotNull(generator);
		assertFalse(java.nio.file.Files.exists(csvPath));
		java.nio.file.Files.deleteIfExists(csvPath);
	}

	/**
	 * Validates that the application detects and ignores the JSON objects that
	 * doesn't contain an _id element or with an invalid value for the _id
	 * element
	 * 
	 * @throws URISyntaxException
	 * @throws JSONException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@Test
	public void generateCsvFileFailedInvalidIdFoundTest()
			throws URISyntaxException, JSONException, UnsupportedEncodingException, IOException {
		String filename = "Test3";
		File csvFile = new File(filename + ".csv");
		Path csvPath = java.nio.file.Paths.get(csvFile.toURI());
		CsvGenerator generator = new CsvGenerator();

		generator.generateFile(filename, getRestApiResponse(filename));

		assertNotNull(generator);
		assertTrue(java.nio.file.Files.exists(csvPath));
		assertTrue(validateResultFile(filename));
		java.nio.file.Files.deleteIfExists(csvPath);
	}

	/**
	 * Validates that the application detects and ignores the JSON objects that
	 * doesn't contain an name element or with an invalid value for the name
	 * element
	 * 
	 * @throws URISyntaxException
	 * @throws JSONException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@Test
	public void generateCsvFileFailedInvalidNameFoundTest()
			throws URISyntaxException, JSONException, UnsupportedEncodingException, IOException {
		String filename = "Test4";
		File csvFile = new File(filename + ".csv");
		Path csvPath = java.nio.file.Paths.get(csvFile.toURI());
		CsvGenerator generator = new CsvGenerator();

		generator.generateFile(filename, getRestApiResponse(filename));

		assertNotNull(generator);
		assertTrue(java.nio.file.Files.exists(csvPath));
		assertTrue(validateResultFile(filename));
		java.nio.file.Files.deleteIfExists(csvPath);
	}

	/**
	 * Validates that the application detects and ignores the JSON objects that
	 * doesn't contain an type element or with an invalid value for the type
	 * element
	 * 
	 * @throws URISyntaxException
	 * @throws JSONException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@Test
	public void generateCsvFileFailedInvalidTypeFoundTest()
			throws URISyntaxException, JSONException, UnsupportedEncodingException, IOException {
		String filename = "Test5";
		File csvFile = new File(filename + ".csv");
		Path csvPath = java.nio.file.Paths.get(csvFile.toURI());
		CsvGenerator generator = new CsvGenerator();

		generator.generateFile(filename, getRestApiResponse(filename));

		assertNotNull(generator);
		assertTrue(java.nio.file.Files.exists(csvPath));
		assertTrue(validateResultFile(filename));
		java.nio.file.Files.deleteIfExists(csvPath);
	}

	/**
	 * Validates that the application detects and ignores the JSON objects that
	 * doesn't contain an geo_position element or with an invalid value for the
	 * geo_position element
	 * 
	 * @throws URISyntaxException
	 * @throws JSONException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@Test
	public void generateCsvFileFailedInvalidGeoPositionFoundTest()
			throws URISyntaxException, JSONException, UnsupportedEncodingException, IOException {
		String filename = "Test6";
		File csvFile = new File(filename + ".csv");
		Path csvPath = java.nio.file.Paths.get(csvFile.toURI());
		CsvGenerator generator = new CsvGenerator();

		generator.generateFile(filename, getRestApiResponse(filename));

		assertNotNull(generator);
		assertTrue(java.nio.file.Files.exists(csvPath));
		assertTrue(validateResultFile(filename));
		java.nio.file.Files.deleteIfExists(csvPath);
	}

	/**
	 * Validates that the application detects and ignores the JSON objects that
	 * doesn't contain an latitude element or with an invalid value for the
	 * latitude element
	 * 
	 * @throws URISyntaxException
	 * @throws JSONException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@Test
	public void generateCsvFileFailedInvalidLatitudeFoundTest()
			throws URISyntaxException, JSONException, UnsupportedEncodingException, IOException {
		String filename = "Test7";
		File csvFile = new File(filename + ".csv");
		Path csvPath = java.nio.file.Paths.get(csvFile.toURI());
		CsvGenerator generator = new CsvGenerator();

		generator.generateFile(filename, getRestApiResponse(filename));

		assertNotNull(generator);
		assertTrue(java.nio.file.Files.exists(csvPath));
		assertTrue(validateResultFile(filename));
		java.nio.file.Files.deleteIfExists(csvPath);
	}

	/**
	 * Validates that the application detects and ignores the JSON objects that
	 * doesn't contain an longitude element or with an invalid value for the
	 * longitude element
	 * 
	 * @throws URISyntaxException
	 * @throws JSONException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@Test
	public void generateCsvFileFailedInvalidLongitudeFoundTest()
			throws URISyntaxException, JSONException, UnsupportedEncodingException, IOException {
		String filename = "Test8";
		File csvFile = new File(filename + ".csv");
		Path csvPath = java.nio.file.Paths.get(csvFile.toURI());
		CsvGenerator generator = new CsvGenerator();

		generator.generateFile(filename, getRestApiResponse(filename));

		assertNotNull(generator);
		assertTrue(java.nio.file.Files.exists(csvPath));
		assertTrue(validateResultFile(filename));
		java.nio.file.Files.deleteIfExists(csvPath);
	}

	/**
	 * Reads the content of a resource JSON file that simulates a response from
	 * the REST API
	 * 
	 * @param filename
	 *            File's name
	 * @return Content of the file as a string
	 * @throws URISyntaxException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	private String getRestApiResponse(String filename)
			throws URISyntaxException, UnsupportedEncodingException, IOException {
		File jsonFile = new File(
				"src" + File.separator + "test" + File.separator + "resources" + File.separator + filename + ".json");
		return readFile(jsonFile);
	}

	/**
	 * Gets the content of a file as a string
	 * 
	 * @param fileToRead
	 *            File to read
	 * @return String with the content of the file
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	private String readFile(File fileToRead) throws UnsupportedEncodingException, IOException {
		java.nio.file.Path resPath = java.nio.file.Paths.get(fileToRead.toURI());
		return new String(java.nio.file.Files.readAllBytes(resPath), "UTF8");
	}

	/**
	 * Compares the result file with an expected result file for given input
	 * file
	 * 
	 * @param filename
	 *            Input file's name
	 * @return true if the result file and the expected result file are the
	 *         same, false if otherwise
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	private boolean validateResultFile(String filename) throws UnsupportedEncodingException, IOException {
		String basePath = "src" + File.separator + "test" + File.separator + "resources" + File.separator;
		File resultFile = new File(filename + ".csv");

		File expectedResultFile = new File(basePath + "expectedCsv" + File.separator + filename + ".csv");

		return readFile(expectedResultFile).equals(readFile(resultFile));
	};
}
