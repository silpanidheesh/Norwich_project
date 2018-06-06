package com.qa.appadmin.pages;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class AppAdminReportDownloadPage extends TestBase {
	@FindBy(xpath="//*[@id=\"dropdownMenu1\"]")
	WebElement userName;
	
	@FindBy(xpath="//*[text()='Configuration']")
	WebElement configurationLink;
	
	@FindBy(xpath="//*[text()='Reports']")
	WebElement reportsLink ;
	
	@FindBy(xpath="/html/body/header/div/div/div[3]/div/ul/li[1]/a")
	WebElement changePasswordLink ;
	
	@FindBy(xpath="/html/body/header/div/div/div[3]/div/ul/li[2]/a")
	public WebElement logoutLink ;
	
	@FindBy(xpath="//*[@value='Download']")
	WebElement DownloadLink;
	
	@FindBy(xpath="//*[@value='Back']")
	WebElement BackLink;
	
	@FindBy(xpath="//*[@id=\"mainmenubutton\"]")
	WebElement mainMenuButton;
	
	
	public AppAdminReportDownloadPage() throws IOException {
		PageFactory.initElements(driver, this);	
	}
	
	public String verifyReportDownloadPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUsername() {
		return userName.isDisplayed();
	}
	public boolean verifyMenuLink() {
		return mainMenuButton.isDisplayed();
	}
	public AppAdminStudiesPage verifyMenuLinkClick() throws IOException {
		mainMenuButton.click();
		Actions act=new Actions(driver);
		act.click(mainMenuButton).moveToElement(configurationLink);
		configurationLink.click();
		return new AppAdminStudiesPage();
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
		act.click(userName).moveToElement(changePasswordLink);
		logoutLink.click();
		return new AppAdminHomePage();
	}
	public void clickOnDownloadLink() throws IOException {
		DownloadLink.click();
		Runtime.getRuntime().exec("G:\\silpa\\file.exe");
	}
		
		
	
	public AppAdminReportPage clickOnBackLink() throws IOException {
		BackLink.click();
		return new AppAdminReportPage();
	}
	

}
