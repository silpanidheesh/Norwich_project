package com.qa.appadmin.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class AppAdminStudyMappingPage extends TestBase{
	

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
	
	@FindBy(xpath="//a[@class='btn btn-default'][contains(text(),'View Randomization Code')]")
	WebElement randomizationCodeButton ;
	
	@FindBy(xpath="//a[@class='btn btn-default'][contains(text(),'Back')]")
	WebElement BackButton ;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement SaveButton ;
	
	//initializing page object
	public AppAdminStudyMappingPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String verifyConfigurationPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUsername() {
		return userName.isDisplayed();
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
	public AppAdminRandomizationCodeListPage clickOnVewRandomizationButton() throws IOException {
		JavascriptExecutor executor = (JavascriptExecutor)driver;

		executor.executeScript("arguments[0].scrollIntoView()", randomizationCodeButton); 
		//Actions act=new Actions(driver);
		//act.moveToElement(randomizationCodeButton);
		randomizationCodeButton.click();
		return new AppAdminRandomizationCodeListPage();
	}
	public AppAdminStudiesPage clickOnBackButton() throws IOException {
		BackButton.click();
		return new AppAdminStudiesPage();
	}
	public AppAdminStudyMappingPage clickOnSaveButton() throws IOException {
		SaveButton.click();
		return new AppAdminStudyMappingPage();
	}

}
