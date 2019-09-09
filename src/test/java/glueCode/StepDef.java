package glueCode;


import static io.restassured.RestAssured.given;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.Utils;


public class StepDef extends Utils {


	private Response response;

	public void setUp() throws Throwable {

		setBaseURI("http://127.0.0.1");
		setPort(12345);
		setBasePath("/validate");

	}

	@Given("^To initiate Rest service to get trade information by passing \"([^\"]*)\"$")
	public void toInitiateRestServiceToGetTradeInformationByPassing(String arg1) throws Throwable {

		setUp();

		String jsonBody = Utils.generateStringFromResource(arg1);

		response = given().header("Accept", "*/*")
				.contentType(ContentType.JSON)
				.body(jsonBody)
				.post();

		//Get response
		System.out.println("************The Response value as --" + response.getBody().asString());

		tearDown();
	}

	@Then("^Respose status code should be \"([^\"]*)\"$")
	public void resposeStatusCodeShouldBe(int arg1) throws Throwable {
		// To verify the response status code
		Assert.assertEquals(arg1, response.getStatusCode());
	}

	@And("^Respose status should be \"([^\"]*)\"$")
	public void resposeStatusShouldBe(String arg1) throws Throwable {

		String actualStatus= response.getBody().jsonPath().getString("status");

		Assert.assertEquals(arg1, actualStatus);
	}

	@And("^response message should be \"([^\"]*)\"$")
	public void responseMessageShouldBe(String arg1) throws Throwable {

		String actualMessage= response.jsonPath().getString("messages");

		if(arg1.equalsIgnoreCase("null")) {
			Assert.assertNull("message is not null", actualMessage);
		}else {
			Assert.assertEquals(arg1, actualMessage);
		}
	}

	public void tearDown() throws Throwable {

		resetBaseURI();
		resetPort();
		resetBasePath();  
	}
}