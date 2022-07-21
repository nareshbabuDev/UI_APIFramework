package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZoteroBib_ManualEntry {

    private WebDriver _driver = null;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@id='title']")
    WebElement _titleTextBox;

    @FindBy(xpath = "//input[@data-field-name='lastName']")
    WebElement _lastNameTextBox;

    @FindBy(xpath = "//input[@data-field-name='firstName']")
    WebElement _firstNameTextBox;

    @FindBy(xpath = "//button[text()='Done']")
    WebElement _doneButton;

    @FindBy(xpath = "//button[text()='Manual Entry']")
    WebElement _manualEntryButton;

    public ZoteroBib_ManualEntry(WebDriver driver) {
        this._driver = driver;
        this.wait = new WebDriverWait(driver,3000L);
        PageFactory.initElements(_driver, this);
    }


    public void createCite(String Title, String FirstName, String LastName){
        _manualEntryButton.click();
        _titleTextBox.sendKeys(Title);
        _firstNameTextBox.sendKeys(FirstName);
        _lastNameTextBox.sendKeys(LastName);
        _doneButton.click();
    }

    public void updateCiteTitle(String Title){
        _titleTextBox.clear();
        _titleTextBox.sendKeys(Title);
        _doneButton.click();
    }

}
