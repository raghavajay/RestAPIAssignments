package com.countryapp.testbase;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class TestBase {

	@BeforeClass
	public static void init() {
		//RestAssured.baseURI="http://restcountries.eu/rest/v1/name";
		//RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/create";
		//RestAssured.baseURI="https://api.github.com/";
		RestAssured.baseURI="https://restcountries.eu/rest/v2";
	}
}
