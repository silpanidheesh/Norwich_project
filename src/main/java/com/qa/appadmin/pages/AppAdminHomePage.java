package com.qa.appadmin.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.admin.pages.AdminAddNewUserPage;
import com.qa.admin.pages.AdminHomePage;
import com.qa.admin.pages.AdminListUserPage;
import com.qa.admin.pages.ChangePasswordPage;
import com.qa.base.TestBase;
import com.qa.util.testUtil;

public class AppAdminHomePage extends TestBase{
testUtil test_util;
	
	@FindBy(xpath="//*[@id=\"mainmenubutton\"]")
	WebElement mainMenuButton;
	
	@FindBy(xpath="//*[text()='Configuration']")
	WebElement configurationLink;
	
	@FindBy(xpath="//*[text()='Reports']")
	WebElement reportsLink ;
	
	@FindBy(xpath="//*[@id=\"dropdownMenu1\"]")
	WebElement userName;
	
	@FindBy(xpath="/html/body/header/div/div/div[3]/div/ul/li[1]/a")
	WebElement changePasswordLink ;
	
	@FindBy(xpath="/html/body/header/div/div/div[3]/div/ul/li[2]/a")
	WebElement logoutLink ;
	
	@FindBy(xpath="/html/body/section/h2")
	WebElement pageTitle ;
	
	//initializing page object
		public AppAdminHomePage() throws IOException {
			PageFactory.initElements(driver, this);
		}
		
	//Actions
		public String verifyHomePageTitle() {
			return driver.getTitle();
		}
		
		public boolean verifyCorrectUsername() {
			return userName.isDisplayed();
		}
		
		
		public AppAdminStudiesPage clickOnConfigurationLink() throws IOException, InterruptedException {
			mainMenuButton.click();
			test_util=new testUtil();
			test_util.waitForClick(configurationLink);
			configurationLink.click();
			return new AppAdminStudiesPage();
		}
		
		public AppAdminReportPage clickOnReportsLink() throws IOException {
			mainMenuButton.click();
			test_util=new testUtil();
			test_util.waitForClick(reportsLink);
			reportsLink.click();
			return new AppAdminReportPage();
		}
		
		
		public AppAdminChangePasswordPage clickOnChangePasswordLink() throws IOException {
			userName.click();
			Actions act=new Actions(driver);
			act.click(userName).moveToElement(changePasswordLink);
			changePasswordLink.click();
			return new AppAdminChangePasswordPage();
		}
		
		public AppAdminHomePage clickOnLogoutLink() throws IOException {
			userName.click();
			Actions act=new Actions(driver);
			act.click(userName).moveToElement(logoutLink);
			logoutLink.click();
			return new AppAdminHomePage();
		}

}
