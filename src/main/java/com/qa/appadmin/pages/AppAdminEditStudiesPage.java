package com.qa.appadmin.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class AppAdminEditStudiesPage extends TestBase{
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement UpdateButton;
	
	@FindBy(xpath="//button[@id='crfstatus']")
	WebElement CRFReadyButton;
	
	@FindBy(xpath="//a[@href='/crf3/Studies/List'][contains(text(),'Cancel')]")
	WebElement cancelButton;
	
	@FindBy(xpath="//a[@class='btn btn-default'][contains(text(),'Preview Pages')]")
	WebElement previewButton;
	
	@FindBy(xpath="//input[@id='StudyNumber']")
	WebElement studyNumTextBox;
	
	@FindBy(xpath="//input[@id='StudyName']")
	WebElement studyNameTextBox;
	
	@FindBy(xpath="//textarea[@id='ProtocolTitle']")
	WebElement protocolTitleTextBox;
	
	@FindBy(xpath="//select[@id='periods']")
	WebElement NoOfPeriodsSelectBox;
	
	@FindBy(xpath="//input[@id='Active']")
	WebElement IsActiveCheckBox;
	
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
	public AppAdminEditStudiesPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
//Actions
	public String verifyEditStudiesPageTitle() {
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
	public AppAdminStudiesPage clickOnUpdateLink(String studyNum, String studyName,String protoTitle,String period, String active) throws IOException {
		studyNumTextBox.sendKeys(studyNum);
		studyNameTextBox.sendKeys(studyName);
		protocolTitleTextBox.sendKeys(protoTitle);
		Select select=new Select(NoOfPeriodsSelectBox);
		
		select.selectByVisibleText(period);
		String isActive=IsActiveCheckBox.getAttribute("value");
		if(isActive.equals(active)) {
			IsActiveCheckBox.click();
			
		}
		UpdateButton.click();
		System.out.println("study updated successfully");
		return new AppAdminStudiesPage();
	}
	public AppAdminEditStudiesPage clickOnCRFReadyLink() throws IOException {
		CRFReadyButton.click();
		System.out.println("changed from new to CRF ready");
		return new AppAdminEditStudiesPage();
	}
	public AppAdminStudiesPage clickOnCancelLink() throws IOException {
		cancelButton.click();
		System.out.println("clicked on cancel button");
		return new AppAdminStudiesPage();
	}
	public AppAdminPeriodOneCheckInPage clickOnPreviewLink() {
		previewButton.click();
		System.out.println("clicked on preview button");
		return new AppAdminPeriodOneCheckInPage();
	}

}
