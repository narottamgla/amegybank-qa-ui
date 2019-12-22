package com.amegybank.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/features/LoginLogout.feature"
,glue= {"com.amegybank.steps"},
tags = {"@smoke"}
)

public class CucumberTest {

}