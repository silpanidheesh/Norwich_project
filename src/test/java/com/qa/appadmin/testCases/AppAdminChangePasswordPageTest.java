package com.qa.appadmin.testCases;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.admin.pages.ChangePasswordPage;
import com.qa.admin.pages.LogOutPage;
import com.qa.appadmin.pages.AppAdminChangePasswordPage;
import com.qa.appadmin.pages.AppAdminHomePage;
import com.qa.appadmin.pages.AppAdminLoginPage;
import com.qa.base.TestBase;
import com.qa.util.testUtil;

public class AppAdminChangePasswordPageTest extends TestBase {
	
	AppAdminHomePage home_page;
	AppAdminLoginPage login_page;
	AppAdminChangePasswordPage changePassword_page;
	//String sheetName;	
	public AppAdminChangePasswordPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		login_page=new AppAdminLoginPage();
		home_page=login_page.login(prop.getProperty("appadminusername"), prop.getProperty("appadminpassword"));
		changePassword_page=new AppAdminChangePasswordPage();
	}
	/*
	@Test(priority=1)
	public void verifyHeadline() throws IOException {
		Assert.assertTrue(changePassword_page.verifyChangePasswordTitle(),"change password title is missing");
	}*/
	@Test(priority=1)
	public void verifyChangePassword() throws IOException, InterruptedException {
		home_page.clickOnChangePasswordLink();
		//addNewUser_page.AddNewUsers("ammu@gmail.com", "ammu", "a", "123", "123");
		//addNewUser_page.AddNewUsers(email, fname, lname, password, repass, role);
		changePassword_page.changePassword("123", "12345", "12345");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
	

}
