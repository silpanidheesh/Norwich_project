package com.qa.appadmin.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.admin.pages.LogOutPage;
import com.qa.appadmin.pages.AppAdminChangePasswordPage;
import com.qa.appadmin.pages.AppAdminHomePage;
import com.qa.appadmin.pages.AppAdminLoginPage;
import com.qa.appadmin.pages.AppAdminReportDownloadPage;
import com.qa.appadmin.pages.AppAdminReportPage;
import com.qa.appadmin.pages.AppAdminStudiesPage;
import com.qa.appadmin.pages.AppAdminStudyMappingPage;
import com.qa.base.TestBase;

public class AppAdminStudyMappingPageTest extends TestBase {
	AppAdminHomePage home_page;
	AppAdminLoginPage login_page;
	AppAdminStudiesPage studies_page;
	AppAdminReportPage report_page;
	AppAdminChangePasswordPage changePassword_page;
	LogOutPage logout_page;
	AppAdminReportDownloadPage reportDownload_page;
	String sheetName="Delete";
	AppAdminStudyMappingPage studyMapping_page;

	
	public AppAdminStudyMappingPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		login_page=new AppAdminLoginPage();
		home_page=login_page.login(prop.getProperty("appadminusername"), prop.getProperty("appadminpassword"));
		home_page.clickOnConfigurationLink();
		studies_page=new AppAdminStudiesPage();
		studies_page.clickOnConfigLink();
		studyMapping_page=new AppAdminStudyMappingPage();
		
	}
	
	@Test(priority=1)
	public void ConfigPageTitleTest() {
		String StudyMappingPageTitle=studyMapping_page.verifyConfigurationPageTitle();
		Assert.assertEquals(StudyMappingPageTitle, "- CRF Application","study mapping page title not matched");
		
	}
	
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(studyMapping_page.verifyCorrectUsername());
	} 
	
	
	
	@Test(priority=3)
	public void verifyclickOnVewRandomizationButton() throws IOException {
		studyMapping_page.clickOnVewRandomizationButton();
	}
	@Test(priority=4)
	public void verifyclickOnBackButton() throws IOException {
		studyMapping_page.clickOnBackButton();
	}
	
	@Test(priority=5)
	public void verifyclickOnSaveButton() throws IOException {
		studyMapping_page.clickOnSaveButton();
	}
	
	
	
	@Test(priority=6)
	public void ChangePasswordTest() throws IOException, InterruptedException {
		changePassword_page=studyMapping_page.clickOnChangePasswordLink();
		}
	@Test(priority=7)
	public void LogoutTest() throws IOException, InterruptedException {
		home_page=studyMapping_page.clickOnLogoutLink();
		}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
