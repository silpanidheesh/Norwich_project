package com.qa.appadmin.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.admin.pages.AdminAddNewUserPage;
import com.qa.admin.pages.AdminHomePage;
import com.qa.admin.pages.AdminListUserPage;
import com.qa.admin.pages.AdminloginPage;
import com.qa.admin.pages.ChangePasswordPage;
import com.qa.admin.pages.LogOutPage;
import com.qa.appadmin.pages.AppAdminChangePasswordPage;
import com.qa.appadmin.pages.AppAdminHomePage;
import com.qa.appadmin.pages.AppAdminLoginPage;
import com.qa.appadmin.pages.AppAdminReportPage;
import com.qa.appadmin.pages.AppAdminStudiesPage;
import com.qa.base.TestBase;

public class AppAdminHomePageTest extends TestBase {
	AppAdminHomePage home_page;
	AppAdminLoginPage login_page;
	AppAdminStudiesPage studies_page;
	AppAdminReportPage report_page;
	AppAdminChangePasswordPage changePassword_page;
	LogOutPage logout_page;
	
	public AppAdminHomePageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		login_page=new AppAdminLoginPage();
		home_page=login_page.login(prop.getProperty("appadminusername"), prop.getProperty("appadminpassword"));
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		String homePageTitle=home_page.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Home Page - CRF Application","home page title not matched");
		
	}
	
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(home_page.verifyCorrectUsername());
	}
	
	@Test(priority=3)
	public void ConfigurationTest() throws IOException, InterruptedException {
		studies_page=home_page.clickOnConfigurationLink();
		}
	@Test(priority=4)
	public void ReportsTest() throws IOException, InterruptedException {
		report_page=home_page.clickOnReportsLink();
		}
	
	@Test(priority=5)
	public void ChangePasswordTest() throws IOException, InterruptedException {
		changePassword_page=home_page.clickOnChangePasswordLink();
		}
	@Test(priority=6)
	public void LogoutTest() throws IOException, InterruptedException {
		home_page=home_page.clickOnLogoutLink();
		}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
	
	

}
