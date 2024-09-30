package com.qa.opencart.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountPageTest extends BaseTest{

	@BeforeClass
	public void accSetUp() {
		accPage = loginPage.doLogin(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	
	@Test
	public void accPageTitleTest() {
	    String actTitle = accPage.getAccountPageTitle();
	    Assert.assertEquals(actTitle, AppConstants.ACCOUNTS_PAGE_TITLE);
	}
	

	
	@Test
	public void isLogoutLinkExistTest() {
    	Assert.assertTrue(accPage.isLogoutLinkExist());
		
	}
	
	@Test
	public void accPageHeaderCountTest() {
	    int count =  accPage.getTotalActPageHearders();
	    Assert.assertEquals(count, AppConstants.ACCOUNTS_PAGE_HEADERS_COUNT);
	
}
	
	@Test
	public void accPageHeadersTest() {
		List<String>actualHeadersList = accPage.getActPageHeaders();
		Assert.assertEquals(actualHeadersList, AppConstants.EXPECTED_ACC_PAGE_HEADERS_LIST);	}


	@Test
	public void searchTest() {
		accPage.doSearch("macbook");
	}
	
	
}
