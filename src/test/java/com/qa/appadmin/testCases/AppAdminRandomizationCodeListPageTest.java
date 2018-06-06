package com.qa.appadmin.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.admin.pages.LogOutPage;
import com.qa.appadmin.pages.AppAdminAddRandomizationCodePage;
import com.qa.appadmin.pages.AppAdminChangePasswordPage;
import com.qa.appadmin.pages.AppAdminHomePage;
import com.qa.appadmin.pages.AppAdminLoginPage;
import com.qa.appadmin.pages.AppAdminRandomizationCodeListPage;
import com.qa.appadmin.pages.AppAdminReportDownloadPage;
import com.qa.appadmin.pages.AppAdminReportPage;
import com.qa.appadmin.pages.AppAdminStudiesPage;
import com.qa.appadmin.pages.AppAdminStudyMappingPage;
import com.qa.base.TestBase;

public class AppAdminRandomizationCodeListPageTest extends TestBase {
	AppAdminHomePage home_page;
	AppAdminLoginPage login_page;
	AppAdminStudiesPage studies_page;
	AppAdminReportPage report_page;
	AppAdminChangePasswordPage changePassword_page;
	LogOutPage logout_page;
	AppAdminAddRandomizationCodePage randomCode_page;
	String sheetName="Delete";
	AppAdminStudyMappingPage studyMapping_page;
	AppAdminRandomizationCodeListPage randomCodeList_page;
	
	
	public AppAdminRandomizationCodeListPageTest() throws IOException {
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
		studyMapping_page.clickOnVewRandomizationButton();
		randomCodeList_page=new AppAdminRandomizationCodeListPage();
		
	}
	
	@Test(priority=1)
	public void ConfigPageTitleTest() {
		String RandomizationCodeListPageTitle=randomCodeList_page.verifyConfigurationPageTitle();
		Assert.assertEquals(RandomizationCodeListPageTitle, "Randomization Code - CRF Application","randomization code list page title not matched");
		
	}
	
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(randomCodeList_page.verifyCorrectUsername());
	} 
	
	@Test(priority=3)
	public void verifyclickOnAddNew() throws IOException {
		randomCode_page=randomCodeList_page.clickOnAddNew();
	} 
	
	
	
	
	@Test(priority=4)
	public void ChangePasswordTest() throws IOException, InterruptedException {
		changePassword_page=randomCodeList_page.clickOnChangePasswordLink();
		}
	@Test(priority=5)
	public void LogoutTest() throws IOException, InterruptedException {
		home_page=randomCodeList_page.clickOnLogoutLink();
		}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
