package com.ui.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        glue = {"com.ui.stepdefinitions"},
        tags = "@Cite",
        plugin = {"json:target/cucumber-report.json","html:target/cucumber/report.html"})
public class TestRunner {
}