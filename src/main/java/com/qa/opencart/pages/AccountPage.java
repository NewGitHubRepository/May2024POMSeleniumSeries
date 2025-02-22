package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.util.ElementUtil;

public class AccountPage {
     private WebDriver driver;
     private ElementUtil eleUtil;
	
	private By headers = By.xpath("//div[@id='content']/h2");
	private By logoutLink = By.linkText("Logout");
	private By search = By.name("search");
	private By searchIcon = By.xpath("//div[@id='search']//button");
	
	
	public AccountPage( WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
		
	}
		
	public String getAccountPageTitle() {
		String title =	eleUtil.waitForTitleContainsAndReturn(AppConstants.ACCOUNTS_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Account page title : "+ title);
		return title;
		}
	
	
	public boolean isLogoutLinkExist() {
		return eleUtil.isElementDisplayed(logoutLink);
		
		
	}
	
	public int getTotalActPageHearders() {
		return eleUtil.waitForElementsVisible(headers, AppConstants.DEFAULT_MEDIUM_TIME_OUT).size();
	}
	
	public List<String> getActPageHeaders() {
		List<WebElement> headerList = eleUtil.waitForElementsVisible(headers, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
		List<String> headerValueList = new ArrayList<String>();
		for(WebElement e : headerList) {
			String header = e.getText();
			headerValueList.add(header);
			
		}
		return headerValueList;
		
	}
	
	public ResultsPage doSearch (String searchKey) {
		eleUtil.waitForElementVisible(search,AppConstants.DEFAULT_SHORT_TIME_OUT ).sendKeys(searchKey);
		eleUtil.doClick(searchIcon);
		return new ResultsPage(driver);
	}
}
