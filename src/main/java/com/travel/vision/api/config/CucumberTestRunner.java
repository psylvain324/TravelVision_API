package com.travel.vision.api.config;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/travel/vision/features", glue="StepDefinitions", tags="@TravelVisionTest", strict=true, monochrome=true,
        plugin= {"pretty", "html:target/cucumber", "json:target/cucumber.json","junit:target/cukes.xml"})
public class CucumberTestRunner {

}