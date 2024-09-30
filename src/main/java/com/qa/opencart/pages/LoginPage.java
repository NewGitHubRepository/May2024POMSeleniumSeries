package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.util.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//Page classes are the classic example of encapsulation
   //1. private By locators: page objects
	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By forgetPwdLink = By.linkText("Forgotten Password");
	private By loginBtn = By.xpath("//input[@class='btn btn-primary']");
    private By logo = By.cssSelector("img.img-responsive");
	//input[@value='Login']
	

	//2. Public Page Constructor ..
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	
	//3. Public page Actions/methods
	public String getLoginPageTitle() {
		String title =	eleUtil.waitForTitleContainsAndReturn(AppConstants.LOGIN_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("login page title : "+ title);
		return title;
	}
	
	public String getLoginPageURL() {
		String url = eleUtil.waitForURLContainsAndReturn(AppConstants.LOGIN_PAGE_FRACTION_URL, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("login page URL : "+ url);
		return url;
	}
	
	public boolean isForgotPwdLinkExist() {
		return eleUtil.isElementDisplayed(forgetPwdLink);
		
		
	}
	public boolean isLogoExist() {
		return eleUtil.isElementDisplayed(logo);
	}
	
	public AccountPage doLogin(String eMail, String pwd) {
		eleUtil.waitForElementVisible(email, AppConstants.DEFAULT_MEDIUM_TIME_OUT).sendKeys(eMail);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new AccountPage(driver);
		/*
		 * String accPageTitle =
		 * eleUtil.waitForTitleContainsAndReturn(AppConstants.ACCOUNTS_PAGE_TITLE,
		 * AppConstants.DEFAULT_SHORT_TIME_OUT); System.out.println("Acc page title : "+
		 * accPageTitle); return accPageTitle;
		 */
	}
}
