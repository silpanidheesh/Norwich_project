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
import com.qa.appadmin.pages.AppAdminHomePage;
import com.qa.appadmin.pages.AppAdminLoginPage;
import com.qa.appadmin.pages.AppAdminReportDownloadPage;
import com.qa.appadmin.pages.AppAdminReportPage;
import com.qa.appadmin.pages.AppAdminStudiesPage;
import com.qa.base.TestBase;
import com.qa.util.testUtil;

public class AppAdminAddStudiesPageTest extends TestBase{
	AppAdminHomePage home_page;
	AppAdminLoginPage login_page;
	AppAdminStudiesPage studies_page;
	AppAdminReportPage report_page;
	AppAdminChangePasswordPage changePassword_page;
	LogOutPage logout_page;
	AppAdminReportDownloadPage reportDownload_page;
	AppAdminAddStudiesPage addStudies_page;
	String sheetName="Study Details";
	
	public AppAdminAddStudiesPageTest() throws IOException, InterruptedException {
		super();
		setup();
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		login_page=new AppAdminLoginPage();
		home_page=login_page.login(prop.getProperty("appadminusername"), prop.getProperty("appadminpassword"));
		home_page.clickOnConfigurationLink();
		studies_page=new AppAdminStudiesPage();
		studies_page.clickOnAddNewButton();
		addStudies_page=new AppAdminAddStudiesPage();
	}
	
	@Test(priority=1)
	public void StudiesPageTitleTest() {
		String studiesPageTitle=addStudies_page.verifyStudiesPageTitle();
		Assert.assertEquals(studiesPageTitle, "- CRF Application","studies page title not matched");
		
	}
	
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(studies_page.verifyCorrectUsername());
	} 
	
	
	@DataProvider
	public Object[][] norwichGetTestData() throws IOException {
		Object[][] data=testUtil.getTestData(sheetName);
		return data;
		
	}
	@Test(dataProvider="norwichGetTestData")
	public void verifySubmitButtonTest(String studyNum, String studyName,String protoTitle,String periods,String active) throws IOException {
		addStudies_page.clickOnSaveButton(studyNum, studyName,protoTitle,periods,active);
		
	} 
	

	@Test(priority=5)
	public void ChangePasswordTest() throws IOException, InterruptedException {
		changePassword_page=studies_page.clickOnChangePasswordLink();
		}
	@Test(priority=6)
	public void LogoutTest() throws IOException, InterruptedException {
		home_page=studies_page.clickOnLogoutLink();
		}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
