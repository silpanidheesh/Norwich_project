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
import com.qa.base.TestBase;

public class AppAdminReportDownloadPageTest extends TestBase {
	AppAdminHomePage home_page;
	AppAdminLoginPage login_page;
	AppAdminStudiesPage studies_page;
	AppAdminReportPage report_page;
	AppAdminChangePasswordPage changePassword_page;
	LogOutPage logout_page;
	AppAdminReportDownloadPage reportDownload_page;
	
	
	public AppAdminReportDownloadPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		login_page=new AppAdminLoginPage();
		home_page=login_page.login(prop.getProperty("appadminusername"), prop.getProperty("appadminpassword"));
		home_page.clickOnReportsLink();
		report_page=new AppAdminReportPage();
		reportDownload_page=report_page.reportGeneration(prop.getProperty("report"));
		
		
	}
	
	@Test(priority=1)
	public void reportDownloadPageTitleTest() {
		String reportDownloadPageTitle=reportDownload_page.verifyReportDownloadPageTitle();
		Assert.assertEquals(reportDownloadPageTitle, "GetReportDetails - CRF Application","report Download page title not matched");
		
	}
	
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(reportDownload_page.verifyCorrectUsername());
	}
	
	@Test(priority=3)
	public void verifyDownloadLink() throws IOException {
		reportDownload_page.clickOnDownloadLink();
	}
	
	@Test(priority=4)
	public void verifyBackLink() throws IOException {
		reportDownload_page.clickOnBackLink();
	}
	@Test(priority=5)
	public void ChangePasswordTest() throws IOException, InterruptedException {
		changePassword_page=reportDownload_page.clickOnChangePasswordLink();
		}
	@Test(priority=6)
	public void LogoutTest() throws IOException, InterruptedException {
		home_page=reportDownload_page.clickOnLogoutLink();
		}
	@Test(priority=7)
	public void verifyMenuClick() throws IOException {
		studies_page=reportDownload_page.verifyMenuLinkClick();
		}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
