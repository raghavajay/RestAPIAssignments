package com.countryapp.junit;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.countryapp.testbase.TestBase;
import org.hamcrest.Matcher;
import org.junit.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;

//@RunWith(SerenityRunner.class)
public class CountryCRUDTest extends TestBase{

	@Title("Get the details of Republic of India")
	@Test
	public void getCountryInfo() {
		RestAssured.given()
		.when()
		.get("/INDIA")
		.then()
		.log()
		.all()
		.statusCode(200);
	}
	@Title ("Verify the get request for the invalid country")
	@Test
	public void negativeTest() {
		RestAssured.given()
		.when()
		.get("/XYZ")
		.then()
		.log()
		.all()
		.statusCode(404);
	}
	@Title ("Validating the capital of the country")
	@Test
	public void validateCapital() {
		
		String capital=SerenityRest.given()
				.when()
				.get("/Norway")
				.then()
				.log()
				.all()
				.statusCode(200)
				.extract()
				.path("findAll{it.capital=='Oslo'}.capital.get(0)").toString();
		 		System.out.println("The capital of norway is: "+ capital);
				Assert.assertTrue(capital.equals("Oslo"));
		}

	}

