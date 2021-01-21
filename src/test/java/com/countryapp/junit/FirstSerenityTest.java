package com.countryapp.junit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest {

	@BeforeClass
	public static void init() {
		RestAssured.baseURI="http://restcountries.eu/rest/v1/name";
	}
	@Test
	public void getCounteryDetails(){
		RestAssured.given()
		.when()
		.get("/INDIA")
		.then()
		.log()
		.all()
		.statusCode(200);
	}
	
}
