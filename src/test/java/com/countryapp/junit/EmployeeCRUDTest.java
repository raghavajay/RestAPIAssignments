package com.countryapp.junit;

import com.countryapp.model.EmployeeClass;
import com.countryapp.testbase.TestBase;

import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class EmployeeCRUDTest extends TestBase{
	static String employee_name = "Ajay Kumar";
	static String employee_salary = "50000";
	static String employee_age = "30";
	static String profile_image; 
	static int studentId;
	
	
	@Title("This test will create a new employee")
	@Test
	
	public void createEmployee() {
		EmployeeClass employee= new EmployeeClass();
		employee.setEmployee_name(employee_name);
		employee.setEmployee_salary(employee_salary);
		employee.setEmployee_age(employee_age);
		//employee.setProfile_image(profile_image);
		
		SerenityRest.given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.when()
		.body(employee)
		.post()
		.then()
		.log()
		.all()
		.statusCode(200);
	}

}
