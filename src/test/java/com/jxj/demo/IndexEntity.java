package com.jxj.demo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexEntity {

    @FindBy(xpath = "//*[@id='header']/div/div/span[2]")
    private WebElement loginButton;
    @FindBy(id = "j_username1")
    private WebElement user;
    @FindBy(id = "j_password1")
    private WebElement passwd;
    @FindBy(id = "capImg")
    private WebElement capImg;

    public IndexEntity(ChromeDriver chromeDriver) {
        PageFactory.initElements(chromeDriver, this);
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getUser() {
        return user;
    }

    public WebElement getPasswd() {
        return passwd;
    }

    public WebElement getCapImg() {
        return capImg;
    }
}
