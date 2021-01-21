package com.countryapp.junit;

import com.countryapp.testbase.TestBase;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class GithubAuthentication extends TestBase{	
	
	@Title("This test will authenticate the GitHub user")
	@Test
	public void gitBasicAuthentication() {
		//String username="raghavajay";
		//String password= "AkM@12345!";
		
		RestAssured.given()
		.auth()
		.oauth2("3437785579ea8a6b18122a900b38bcf29dc9d7b6")
		.when()
		.get("/user")
		.then()
		.assertThat()
		.statusCode(401);
		System.out.println("The authentication is failed");
		
	}

}
