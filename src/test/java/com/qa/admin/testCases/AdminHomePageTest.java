package com.qa.admin.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.admin.pages.AdminAddNewUserPage;
import com.qa.admin.pages.AdminHomePage;
import com.qa.admin.pages.AdminListUserPage;
import com.qa.admin.pages.AdminloginPage;
import com.qa.admin.pages.ChangePasswordPage;
import com.qa.admin.pages.LogOutPage;
import com.qa.base.TestBase;

public class AdminHomePageTest extends TestBase {
	AdminHomePage home_page;
	AdminloginPage login_page;
	AdminAddNewUserPage addNewUser_page;
	AdminListUserPage listUser_page;
	ChangePasswordPage changePassword_page;
	LogOutPage logout_page;
	
	public AdminHomePageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		login_page=new AdminloginPage();
		home_page=login_page.login(prop.getProperty("adminusername"), prop.getProperty("adminpassword"));
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		String homePageTitle=home_page.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Home Page - CRF Application","home page title not matched");
		
	}
	
	
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(home_page.verifyCorrectUsername());
	}
	
	@Test(priority=3)
	public void AddNewUserTest() throws IOException, InterruptedException {
		addNewUser_page=home_page.clickOnAddNewUserLink();
		}
	@Test(priority=4)
	public void ListUserTest() throws IOException, InterruptedException {
		listUser_page=home_page.clickOnListUserLink();
		}
	@Test(priority=5)
	public void ChangePasswordTest() throws IOException, InterruptedException {
		changePassword_page=home_page.clickOnChangePasswordLink();
		}
	@Test(priority=6)
	public void LogoutTest() throws IOException, InterruptedException {
		home_page=home_page.clickOnLogoutLink();
		}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
