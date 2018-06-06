package com.qa.appadmin.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.admin.pages.LogOutPage;
import com.qa.appadmin.pages.AppAdminAddRandomizationCodePage;
import com.qa.appadmin.pages.AppAdminAddStudiesPage;
import com.qa.appadmin.pages.AppAdminChangePasswordPage;
import com.qa.appadmin.pages.AppAdminHomePage;
import com.qa.appadmin.pages.AppAdminLoginPage;
import com.qa.appadmin.pages.AppAdminRandomizationCodeListPage;
import com.qa.appadmin.pages.AppAdminReportDownloadPage;
import com.qa.appadmin.pages.AppAdminReportPage;
import com.qa.appadmin.pages.AppAdminStudiesPage;
import com.qa.appadmin.pages.AppAdminStudyMappingPage;
import com.qa.base.TestBase;
import com.qa.util.testUtil;

public class AppAdminAddRandomizationCodePageTest extends TestBase {
	AppAdminHomePage home_page;
	AppAdminLoginPage login_page;
	AppAdminStudiesPage studies_page;
	AppAdminReportPage report_page;
	AppAdminChangePasswordPage changePassword_page;
	LogOutPage logout_page;
	AppAdminAddStudiesPage addStudies_page;
	String sheet="Study Details";
	String sheetName="Randomization Code";
	AppAdminAddRandomizationCodePage randomCode_page;
	AppAdminRandomizationCodeListPage randomCodeList_page;
	AppAdminStudyMappingPage studyMapping_page;
	
	
	public AppAdminAddRandomizationCodePageTest() throws IOException {
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
		randomCodeList_page.clickOnAddNew();
		randomCode_page=new AppAdminAddRandomizationCodePage();
	}
	
	@Test(priority=1)
	public void ConfigPageTitleTest() {
		String RandomizationCodePageTitle=randomCode_page.verifyConfigurationPageTitle();
		Assert.assertEquals(RandomizationCodePageTitle, "- CRF Application","randomization code page title not matched");
		
	}
	
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(randomCode_page.verifyCorrectUsername());
	} 
	@DataProvider
	public Object[][] norwichGetTestData() throws IOException {
		Object[][] data=testUtil.getTestData(sheetName);
		return data;
		
	}
	@Test(priority=3,dataProvider="norwichGetTestData")
	public void verifyclickOnSave(String RandomizationCode,String StudyNumber,String BatchNumber,
			String ExpiryDate,String NameOfTheProduct,String StrengthOfTheProduct,	String DosageForm,String RouteOfAdministration,
			String SponsorNameAndAddress,String NameOfPrincipalInvestigator,String StorageCondition,String Quantity,
			String DirectionsOfUse) throws IOException {
		randomCode_page.clickOnSave(RandomizationCode, StudyNumber, BatchNumber, ExpiryDate, NameOfTheProduct, StrengthOfTheProduct, DosageForm, RouteOfAdministration, SponsorNameAndAddress, NameOfPrincipalInvestigator, StorageCondition, Quantity, DirectionsOfUse);
	} 
	

	@Test(priority=4)
	public void verifyclickOnCancel() throws IOException {
		randomCode_page.clickOnCancel();
	} 
	@Test(priority=5)
	public void ChangePasswordTest() throws IOException, InterruptedException {
		changePassword_page=randomCode_page.clickOnChangePasswordLink();
		}
	@Test(priority=6)
	public void LogoutTest() throws IOException, InterruptedException {
		home_page=randomCode_page.clickOnLogoutLink();
		}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

//Syso
}
