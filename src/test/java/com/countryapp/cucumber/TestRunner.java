package com.countryapp.cucumber;

import org.junit.runner.RunWith;

import com.countryapp.testbase.TestBase;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/feature/")

public class TestRunner extends TestBase{

}