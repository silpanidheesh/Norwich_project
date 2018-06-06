package com.qa.admin.testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.jsoup.helper.Validate;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.admin.pages.AdminHomePage;
import com.qa.admin.pages.AdminloginPage;
import com.qa.base.TestBase;

public class AdminLoginPageTest extends TestBase {
	AdminloginPage login_page;
	AdminHomePage home_page;
	
	public AdminLoginPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		login_page=new AdminloginPage();
	}

	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=login_page.validateLoginPageTitle();
		Assert.assertEquals(title, "Home Page - CRF Application");
		
	}
	
	@Test(priority=2)
	public void norwichLogoTest() {
		boolean flag=login_page.validateNorwichLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() throws IOException, InterruptedException {
		home_page=login_page.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
