package com.ui.stepdefinitions;

import com.api.TestContext;
import com.ui.pages.ZoteroBib_HomePage;
import com.ui.pages.ZoteroBib_ManualEntry;
import com.commonutils.FileReaderManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static org.junit.Assert.assertEquals;


public class ZoteroBibUISteps {

    public static  WebDriver driver = FileReaderManager.getDriver().getBrowser();

    public static TestContext context = FileReaderManager.getTestContext();

    String URL = FileReaderManager.getConfigReader().getPropertyValueObject().getProperyValue("URL");
    ZoteroBib_HomePage homePage =new ZoteroBib_HomePage(driver);
    ZoteroBib_ManualEntry manualEntry =new ZoteroBib_ManualEntry(driver);


    @Given("^User is on ZoteroBib Home page$")
    public void userOnZoteroBibHomePage() {
        homePage.openURL(URL);
    }

    @Given("^User is on ZoteroBib Cite Section$")
    public void userOnZoteroCiteSection() {
        homePage.scrollToCite();
    }

    @Given("^User is on ZoteroBib Biblography Section$")
    public void userOnZoteroBibSection() {
        homePage.scrollToBiblography();
    }

    @Given("user has access to endpoint {string}")
    public void userHasAccessToEndpoint(String endpoint) {
        context.session.put("endpoint", endpoint);
    }

    @When("user makes a request to check the health of Cite service")
    public void userMakesARequestToCheckTheHealthOfCiteService() {
        context.response = context.requestSetup().get(context.session.get("endpoint").toString());
    }

    @And("^User select Cite for Cite Updation$")
    public void selectCite(DataTable dataTable) {
        Map<String,String> Cite_Input = dataTable.asMaps().get(0);
        homePage.citeInBibSelect(Cite_Input.get("Book_Title"));
    }

    @And("^User select Cite for Cite Deletion$")
    public void deleteCite(DataTable dataTable) {
        Map<String,String> Cite_Input = dataTable.asMaps().get(0);
        homePage.citeInBib(Cite_Input.get("Book_Title"));
    }

    @When("^User delete Cite through Manual$")
    public void deletionCite(DataTable dataTable) {
        Map<String,String> Cite_Input = dataTable.asMaps().get(0);
        homePage.citeInBibDelete(Cite_Input.get("Book_Title"));
    }


    @When("^User searches for Cite$")
    public void searchCite(DataTable dataTable) {
        Map<String,String> Cite_Input = dataTable.asMaps().get(0);
        homePage.searchForCite(Cite_Input.get("Cite_Value"));
        homePage.clickCiteButton();
    }

    @When("^User update Cite through Manual Entry$")
    public void updateCite(DataTable dataTable) {
        Map<String,String> Cite_Input = dataTable.asMaps().get(0);
        manualEntry.updateCiteTitle(Cite_Input.get("Update_Book_Title"));
    }

    @When("^User add Cite through Manual Entry$")
    public void addCite(DataTable dataTable) {
        Map<String,String> Cite_Input = dataTable.asMaps().get(0);
        manualEntry.createCite(Cite_Input.get("Book_Title"),Cite_Input.get("last_Name"),Cite_Input.get("first_Name"));
    }

    @And("^User select cite from display list$")
    public void selectCite() {
        homePage.clickSuggestion();
    }


    @Then("User can see Cite {string} in Biblography")
    public void userCanSeeAddedCiteInBiblography(String CiteValue) {
        homePage.citeInBib(CiteValue);
    }

    @Then("User can not see Cite {string} in Biblography")
    public void userCannotSeeAddedCiteInBiblography(String CiteValue) {
        homePage.citeNotInBib(CiteValue);
    }

    @Then("user should get the response code {int}")
    public void userShouldGetTheResponseCode(Integer statusCode) {
        assertEquals(Long.valueOf(statusCode), Long.valueOf(context.response.getStatusCode()));
    }
}