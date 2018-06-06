package com.qa.appadmin.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.admin.pages.LogOutPage;
import com.qa.appadmin.pages.AppAdminAddStudiesPage;
import com.qa.appadmin.pages.AppAdminChangePasswordPage;
import com.qa.appadmin.pages.AppAdminDeleteConfirmationPage;
import com.qa.appadmin.pages.AppAdminHomePage;
import com.qa.appadmin.pages.AppAdminLoginPage;
import com.qa.appadmin.pages.AppAdminReportDownloadPage;
import com.qa.appadmin.pages.AppAdminReportPage;
import com.qa.appadmin.pages.AppAdminStudiesPage;
import com.qa.base.TestBase;

public class AppAdminDeleteConfirmationPageTest extends TestBase{
	AppAdminHomePage home_page;
	AppAdminLoginPage login_page;
	AppAdminStudiesPage studies_page;
	AppAdminReportPage report_page;
	AppAdminChangePasswordPage changePassword_page;
	LogOutPage logout_page;
	AppAdminReportDownloadPage reportDownload_page;
	AppAdminAddStudiesPage addStudies_page;
	AppAdminDeleteConfirmationPage delete_page;
	
	public AppAdminDeleteConfirmationPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		login_page=new AppAdminLoginPage();
		home_page=login_page.login(prop.getProperty("appadminusername"), prop.getProperty("appadminpassword"));
		home_page.clickOnConfigurationLink();
		studies_page=new AppAdminStudiesPage();
		studies_page.clickOnDeleteLink();
		delete_page=new AppAdminDeleteConfirmationPage();
		
		
	}
	
	@Test(priority=1)
	public void DeletePageTitleTest() {
		String DeletePageTitle=delete_page.verifyStudiesPageTitle();
		Assert.assertEquals(DeletePageTitle, "- CRF Application","delete page title not matched");
		
	}
	
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(delete_page.verifyCorrectUsername());
	} 
	
	@Test(priority=3)
	public void verifyDeleteButton() throws IOException {
		studies_page=delete_page.clickOnDeleteButton();
	}
	
	@Test(priority=4)
	public void verifyCancelButton() throws IOException {
		studies_page=delete_page.clickOnCancelButton();
	}
	@Test(priority=5)
	public void ChangePasswordTest() throws IOException, InterruptedException {
		changePassword_page=delete_page.clickOnChangePasswordLink();
		}
	@Test(priority=6)
	public void LogoutTest() throws IOException, InterruptedException {
		home_page=delete_page.clickOnLogoutLink();
		}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
