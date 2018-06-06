package com.qa.appadmin.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.admin.pages.LogOutPage;
import com.qa.appadmin.pages.AppAdminChangePasswordPage;
import com.qa.appadmin.pages.AppAdminHomePage;
import com.qa.appadmin.pages.AppAdminLoginPage;
import com.qa.appadmin.pages.AppAdminReportDownloadPage;
import com.qa.appadmin.pages.AppAdminReportPage;
import com.qa.appadmin.pages.AppAdminStudiesPage;
import com.qa.base.TestBase;
import com.qa.util.testUtil;

public class AppAdminStudiesPageTest extends TestBase {
	AppAdminHomePage home_page;
	AppAdminLoginPage login_page;
	AppAdminStudiesPage studies_page;
	AppAdminReportPage report_page;
	AppAdminChangePasswordPage changePassword_page;
	LogOutPage logout_page;
	AppAdminReportDownloadPage reportDownload_page;
	String sheetName="Delete";

	
	public AppAdminStudiesPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		login_page=new AppAdminLoginPage();
		home_page=login_page.login(prop.getProperty("appadminusername"), prop.getProperty("appadminpassword"));
		home_page.clickOnConfigurationLink();
		studies_page=new AppAdminStudiesPage();
		
	}
	
	@Test(priority=1)
	public void ConfigPageTitleTest() {
		String studiesPageTitle=studies_page.verifyConfigurationPageTitle();
		Assert.assertEquals(studiesPageTitle, "Studies List - CRF Application","configuration page title not matched");
		
	}
	
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(studies_page.verifyCorrectUsername());
	} 

	@Test(priority=3)
	public void verifyClickOnViewLink() throws IOException {
		studies_page.clickOnViewLink();
		
	}
	@Test(priority=4)
	public void verifyClickOnConfigLink() throws IOException {
		studies_page.clickOnConfigLink();
		
	}
	
	@Test(priority=5)
	public void verifyClickOnDeleteLink() throws IOException {
		studies_page.clickOnDeleteLink();
		
	}
	@Test(priority=6)
	public void verifyClickOnAddNewLink() throws IOException {
		studies_page.clickOnAddNewButton();
		
	}
	@Test(priority=7)
	public void verifyClickOnApplyLink() throws IOException {
		studies_page.clickOnApplyButton();
		
	}

	@Test(priority=8)
	public void ChangePasswordTest() throws IOException, InterruptedException {
		changePassword_page=studies_page.clickOnChangePasswordLink();
		}
	@Test(priority=9)
	public void LogoutTest() throws IOException, InterruptedException {
		home_page=studies_page.clickOnLogoutLink();
		}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}








}
