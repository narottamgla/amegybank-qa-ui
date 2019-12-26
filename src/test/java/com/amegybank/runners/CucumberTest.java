package com.amegybank.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm", "pretty", "json:target/cucumber-report/report.json" },

features = "src/test/resources/features/LoginLogout.feature"
,glue= {"com.amegybank.steps"}
//tags = {"@smoke"}
)

public class CucumberTest {

}