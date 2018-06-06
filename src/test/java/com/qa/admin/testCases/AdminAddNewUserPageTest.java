package com.qa.admin.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.admin.pages.AdminAddNewUserPage;
import com.qa.admin.pages.AdminHomePage;
import com.qa.admin.pages.AdminloginPage;
import com.qa.base.TestBase;
import com.qa.util.testUtil;

public class AdminAddNewUserPageTest extends TestBase{
	AdminHomePage home_page;
	AdminloginPage login_page;
	AdminAddNewUserPage addNewUser_page;
	String sheetName="AddUser";

	public AdminAddNewUserPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		login_page=new AdminloginPage();
		home_page=login_page.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
		addNewUser_page=home_page.clickOnAddNewUserLink();
	
	}
	@Test(priority=1)
	public void addNewUserPageTitleTest() {
		
		String addNewUserPageTitle=addNewUser_page.verifyAddNewUserPageTitle();
		Assert.assertEquals(addNewUserPageTitle, "- CRF Application","add user page title not matched");
		
	}
	/*@Test(priority=2)
	public void addNewUserLabelTest() throws IOException {
		Assert.assertTrue(addNewUser_page.verifyAddUserLabel(),"Add User Label is missing");
	}
	*/
	@Test(priority=2)
	public void verifyAddUserPageUserNameTest() {
		Assert.assertTrue(addNewUser_page.verifyCorrectUsername(),"username is not correct");
	}
	@DataProvider
	public Object[][] norwichGetTestData() throws IOException {
		Object[][] data=testUtil.getTestData(sheetName);
		return data;
		
	}
	@Test(priority=3, dataProvider="norwichGetTestData")
	public void verifyAddNewUsers(String email,String fname,String lname,String password,String repass, String role) throws IOException, InterruptedException {
		home_page.clickOnAddNewUserLink();
		//addNewUser_page.AddNewUsers("ammu@gmail.com", "ammu", "a", "123", "123");
		addNewUser_page.AddNewUsers(email, fname, lname, password, repass, role);
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
