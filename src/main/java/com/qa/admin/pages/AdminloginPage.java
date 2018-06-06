package com.qa.admin.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.testUtil;

public class AdminloginPage extends TestBase {
	testUtil test;
	@FindBy(xpath="//*[@id='Name']")
	WebElement username;
	
	@FindBy(xpath="//*[@id='Password']")
	WebElement password;
	
	@FindBy(xpath="/html/body/section/div/div/div[1]/div/div[2]/div[1]/div/form/div[4]")
	WebElement loginButton;
	
	@FindBy(xpath="/html/body/section/img")
	WebElement norwichLogo;
	
	//initializing page object
	public AdminloginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
		}
	
	public boolean validateNorwichLogo() {
		return norwichLogo.isDisplayed();
		}
	
	public AdminHomePage login(String uname,String pwrd) throws IOException, InterruptedException {
		
		Thread.sleep(3000);
		username.sendKeys(uname);
		password.sendKeys(pwrd);
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("scroll(0,250)");
		loginButton.click();
		return new AdminHomePage();
		}

	
}
