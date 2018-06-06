package com.qa.appadmin.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.appadmin.pages.AppAdminHomePage;
import com.qa.appadmin.pages.AppAdminLoginPage;
import com.qa.base.TestBase;

public class AppAdminLoginPageTest extends TestBase {
	AppAdminLoginPage login_page;
	AppAdminHomePage home_page;
	
	public AppAdminLoginPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		login_page=new AppAdminLoginPage();
	}

	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=login_page.validateLoginPageTitle();
		Assert.assertEquals(title, "Home Page - CRF Application","login page title not matching");
		
	}
	
	@Test(priority=2)
	public void norwichLogoTest() {
		boolean flag=login_page.validateNorwichLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() throws IOException {
		home_page=login_page.login(prop.getProperty("appadminusername"), prop.getProperty("appadminpassword"));
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
