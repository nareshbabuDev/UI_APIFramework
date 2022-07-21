package com.ui.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ZoteroBib_HomePage {

    private WebDriver _driver = null;
    private WebDriverWait wait;

    static JavascriptExecutor executor;

    @FindBy(name = "q")
    WebElement _searchBox;

    @FindBy(xpath = "//input[contains(@placeholder,'title') and contains(@placeholder,'URL') ]")
    WebElement _citeSearchBox;

    @FindBy(xpath = "//button[text()='Cite']")
    WebElement _citeButton;

    @FindBy(xpath = "//button[text()='Manual Entry']")
    WebElement _manualEntryButton;

    @FindBy(xpath="//ul/li[@class='result'][1]")
    private WebElement _searchSuggestion;

    @FindBy(xpath="//section[contains(@class,'section-cite')]")
    private static WebElement _citeSection;

    @FindBy(xpath="//section[contains(@class,'section-bibliography')]")
    private static WebElement _biblographySection;


    public ZoteroBib_HomePage(WebDriver driver) {
        this._driver = driver;
        this.wait = new WebDriverWait(driver,3000L);
        PageFactory.initElements(_driver, this);
    }

    public void openURL(String URL){
        _driver.get(URL);
    }

    public void searchForCite(String _searchTerm){
        _citeSearchBox.sendKeys(_searchTerm);
    }

    public void clickCiteButton() { _citeButton.click();}

    public void clickSuggestion() {
        this.wait.until(ExpectedConditions.visibilityOf(_searchSuggestion));
        _searchSuggestion.click();
    }

    public void citeInBib(String CiteValue){
        Assert.assertTrue(_driver.findElement(By.xpath("//ul[@class='bibliography']/li/div/i[contains(text(),'"+CiteValue+"')]")).isDisplayed());
    }

    public void citeNotInBib(String CiteValue){
        Assert.assertTrue(_driver.findElement(By.xpath("//ul[@class='bibliography']/li/div")).isDisplayed());
    }

    public void scrollToCite() {
        executor = (JavascriptExecutor)_driver;
        executor.executeScript("arguments[0].scrollIntoView()", _citeSection);
    }

    public void scrollToBiblography() {
        executor = (JavascriptExecutor)_driver;
        executor.executeScript("arguments[0].scrollIntoView()", _biblographySection);
    }

    public void citeInBibSelect(String CiteValue){
        _driver.findElement(By.xpath("//ul[@class='bibliography']/li/div/i[contains(text(),'"+CiteValue+"')]")).click();
    }

    public void citeInBibDelete(String CiteValue){
        _driver.findElement(By.xpath("//ul[@class='bibliography']/li/div/i[contains(text(),'"+CiteValue+"')]//ancestor::li/button[contains(@title, 'Delete')]")).click();
    }


}

