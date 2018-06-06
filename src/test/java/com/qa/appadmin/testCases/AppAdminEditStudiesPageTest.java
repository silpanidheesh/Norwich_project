package com.qa.appadmin.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.admin.pages.LogOutPage;
import com.qa.appadmin.pages.AppAdminAddStudiesPage;
import com.qa.appadmin.pages.AppAdminChangePasswordPage;
import com.qa.appadmin.pages.AppAdminDeleteConfirmationPage;
import com.qa.appadmin.pages.AppAdminEditStudiesPage;
import com.qa.appadmin.pages.AppAdminHomePage;
import com.qa.appadmin.pages.AppAdminLoginPage;
import com.qa.appadmin.pages.AppAdminPeriodOneCheckInPage;
import com.qa.appadmin.pages.AppAdminReportDownloadPage;
import com.qa.appadmin.pages.AppAdminReportPage;
import com.qa.appadmin.pages.AppAdminStudiesPage;
import com.qa.base.TestBase;
import com.qa.util.testUtil;

public class AppAdminEditStudiesPageTest extends TestBase {
	AppAdminHomePage home_page;
	AppAdminLoginPage login_page;
	AppAdminStudiesPage studies_page;
	AppAdminReportPage report_page;
	AppAdminChangePasswordPage changePassword_page;
	LogOutPage logout_page;
	AppAdminReportDownloadPage reportDownload_page;
	AppAdminEditStudiesPage addStudies_page;
	AppAdminEditStudiesPage view_page;
	AppAdminPeriodOneCheckInPage period_page;
	String sheetName="Update";
	public AppAdminEditStudiesPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		login_page=new AppAdminLoginPage();
		home_page=login_page.login(prop.getProperty("appadminusername"), prop.getProperty("appadminpassword"));
		home_page.clickOnConfigurationLink();
		studies_page=new AppAdminStudiesPage();
		studies_page.clickOnViewLink();
		view_page=new AppAdminEditStudiesPage();
		
		
	}
	
	@Test(priority=1)
	public void DeletePageTitleTest() {
		String EditStudiesPageTitle=view_page.verifyEditStudiesPageTitle();
		Assert.assertEquals(EditStudiesPageTitle, "- CRF Application","edit studies page title not matched");
		
	}
	
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(view_page.verifyCorrectUsername());
	} 
	@Test(priority=3)
	public void verifyCRFReadyButton() throws IOException {
		addStudies_page=view_page.clickOnCRFReadyLink();
	} 
	@Test(priority=3)
	public void verifyCancelButton() throws IOException {
		studies_page=view_page.clickOnCancelLink();
	} 
	@Test(priority=3)
	public void verifyPreviewButton() throws IOException {
		period_page=view_page.clickOnPreviewLink();
	}
	

	@DataProvider
	public Object[][] norwichGetTestData() throws IOException {
		Object[][] data=testUtil.getTestData(sheetName);
		return data;
		
	}
	@Test(priority=3, dataProvider="norwichGetTestData")
	public void verifyUpdateButton(String studyNum, String studyName,String protoTitle,String period, String active) throws IOException {
		studies_page=view_page.clickOnUpdateLink(studyNum,studyName,protoTitle,period,active);
	} 
	
	
	@Test(priority=5)
	public void ChangePasswordTest() throws IOException, InterruptedException {
		changePassword_page=view_page.clickOnChangePasswordLink();
		}
	@Test(priority=6)
	public void LogoutTest() throws IOException, InterruptedException {
		home_page=view_page.clickOnLogoutLink();
		}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
