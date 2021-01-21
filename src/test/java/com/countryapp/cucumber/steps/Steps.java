package com.countryapp.cucumber.steps;
import com.countryapp.testbase.TestBase;
import org.junit.Assert;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;

public class Steps extends TestBase {
	@When("^user send a get request,they must get back a valid status code (\\d+)$")
	public void user_send_a_get_request_they_must_get_back_a_valid_status_code(int responsecode) throws Throwable {
		SerenityRest.rest().given().when().get("/alpha/co").then().statusCode(responsecode);
	}

	ValidatableResponse response;

	@When("^User makes a get call using \"([^\"]*)\"$")
	public void user_makes_a_get_call_using(String parameter) throws Throwable {
		response = SerenityRest.given().when().get(parameter).then().log().all();
	}

	@Then("^API returns the response Status Code as (\\d+)$")
	public void api_returns_the_response_Status_Code_as(int expectedStuatsCode) throws Throwable {
		response.statusCode(expectedStuatsCode);
	}

	@Then("^the country details are available in response$")
	public void the_country_details_are_available_in_response() throws Throwable {
		String name = response.extract().path("findAll{it.name=='Colombia'}.name").toString();
		System.out.println("The country name is: "+name);
		Assert.assertTrue(name.contains("Colombia"));
	}

}
