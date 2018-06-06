package com.qa.appadmin.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.appadmin.pages.AppAdminChangePasswordPage;
import com.qa.appadmin.pages.AppAdminHomePage;
import com.qa.appadmin.pages.AppAdminLoginPage;
import com.qa.appadmin.pages.AppAdminReportDownloadPage;
import com.qa.appadmin.pages.AppAdminReportPage;
import com.qa.base.TestBase;
import com.qa.util.testUtil;

public class AppAdminReportPageTest extends TestBase {
	AppAdminLoginPage login_page;
	AppAdminHomePage home_page;
	AppAdminReportPage report_page;
	AppAdminReportDownloadPage report_dowload_page;
	String sheetName="report";
	AppAdminChangePasswordPage changePassword_page;
	public AppAdminReportPageTest() throws IOException {
		super();
	}
	

	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		login_page=new AppAdminLoginPage();
		home_page=login_page.login(prop.getProperty("appadminusername"), prop.getProperty("appadminpassword"));
		home_page.clickOnReportsLink();
		report_page=new AppAdminReportPage();
		
	}
	@Test(priority=1)
	public void homePageTitleTest() {
		String ReportPageTitle=report_page.verifyReportPageTitle();
		Assert.assertEquals(ReportPageTitle, "Index - CRF Application","report page title not matched");
		
	}
	
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(report_page.verifyCorrectUsername());
	}
	
	@DataProvider
	public Object[][] norwichGetTestData() throws IOException {
		Object[][] data=testUtil.getTestData(sheetName);
		return data;
		
	}
	@Test(priority=3,dataProvider="norwichGetTestData")
	public void verifyReportPage(String report) throws IOException {
		report_dowload_page=report_page.reportGeneration(report);
		
	}
	@Test(priority=4)
	public void ChangePasswordTest() throws IOException, InterruptedException {
		changePassword_page=home_page.clickOnChangePasswordLink();
		}
	@Test(priority=5)
	public void LogoutTest() throws IOException, InterruptedException {
		home_page=report_page.clickOnLogoutLink();
		}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
