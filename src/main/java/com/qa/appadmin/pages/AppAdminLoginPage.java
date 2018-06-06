package com.qa.appadmin.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.admin.pages.AdminHomePage;
import com.qa.base.TestBase;

public class AppAdminLoginPage extends TestBase {
	@FindBy(xpath="//*[@id='Name']")
	WebElement username;
	
	@FindBy(xpath="//*[@id='Password']")
	WebElement password;
	
	@FindBy(xpath="/html/body/section/div/div/div[1]/div/div[2]/div[1]/div/form/div[4]")
	WebElement loginButton;
	
	@FindBy(xpath="/html/body/section/img")
	WebElement norwichLogo;
	
	//initializing page object
	public AppAdminLoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
		}
	
	public boolean validateNorwichLogo() {
		return norwichLogo.isDisplayed();
		}
	
	public AppAdminHomePage login(String uname,String pwrd) throws IOException {
		username.sendKeys(uname);
		password.sendKeys(pwrd);
		loginButton.click();
		return new AppAdminHomePage();
		}


}
