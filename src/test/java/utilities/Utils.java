package utilities;

import static io.restassured.RestAssured.DEFAULT_PORT;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;

public class Utils {


	//Sets port
	public static void setPort(int port) {
		RestAssured.port = port;
	}
	//reset port
	public static void resetPort() {
		RestAssured.port = DEFAULT_PORT;
	}
	//retrieve body
	public static String generateStringFromResource(String path) throws IOException {

		return new String(Files.readAllBytes(Paths.get(path)));

	}

	//Sets base path
	public static void setBasePath(String basePathTerm) {
		RestAssured.basePath = basePathTerm;
	}
	//Sets Base URI
	public static void setBaseURI(String baseURI) {
		RestAssured.baseURI = baseURI;
	}

	//Reset Base URI (after test)
	public static void resetBaseURI() {
		RestAssured.baseURI = null;
	}

	//Reset base path
	public static void resetBasePath() {
		RestAssured.basePath = null;
	}    
}