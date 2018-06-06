package com.qa.admin.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;
import com.qa.util.testUtil;

public class AdminHomePage extends TestBase {
	testUtil test_util;
	
	@FindBy(xpath="//*[@id=\"mainmenubutton\"]")
	WebElement mainMenuButton;
	
	@FindBy(xpath="//a[@href='/crf3/User/AddEdit']")
	WebElement addNewUserLink;
	
	@FindBy(xpath="/html/body/nav/ul/li[2]/a")
	WebElement listUserLink ;
	
	@FindBy(xpath="//*[@id=\"dropdownMenu1\"]")
	WebElement userName;
	
	@FindBy(xpath="/html/body/header/div/div/div[3]/div/ul/li[1]/a")
	WebElement changePasswordLink ;
	
	@FindBy(xpath="/html/body/header/div/div/div[3]/div/ul/li[2]/a")
	public WebElement logoutLink ;
	
	@FindBy(xpath="/html/body/section/h2")
	WebElement pageTitle ;
	
	//initializing page object
		public AdminHomePage() throws IOException {
			PageFactory.initElements(driver, this);
		}
		
	//Actions
		public String verifyHomePageTitle() {
			return driver.getTitle();
		}
		
		public boolean verifyCorrectUsername() {
			return userName.isDisplayed();
		}
		
		
		public AdminAddNewUserPage clickOnAddNewUserLink() throws IOException, InterruptedException {
			mainMenuButton.click();
			test_util=new testUtil();
			test_util.waitForClick(addNewUserLink);
			addNewUserLink.click();
			return new AdminAddNewUserPage();
		}
		
		public AdminListUserPage clickOnListUserLink() throws IOException {
			mainMenuButton.click();
			test_util=new testUtil();
			test_util.waitForClick(listUserLink);
			listUserLink.click();
			return new AdminListUserPage();
		}
		
		public ChangePasswordPage clickOnChangePasswordLink() throws IOException {
			userName.click();
			Actions act=new Actions(driver);
			act.click(userName).moveToElement(changePasswordLink);
			changePasswordLink.click();
			return new ChangePasswordPage();
		}
		
		public AdminHomePage clickOnLogoutLink() throws IOException {
			userName.click();
			Actions act=new Actions(driver);
			act.click(userName).moveToElement(changePasswordLink);
			logoutLink.click();
			return new AdminHomePage();
		}

}
