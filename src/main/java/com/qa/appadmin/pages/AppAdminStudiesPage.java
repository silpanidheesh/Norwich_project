package com.qa.appadmin.pages;

import java.awt.List;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class AppAdminStudiesPage extends TestBase{
	@FindBy(xpath="//a[@class=\"btn btn-default\"]")
	WebElement AddNewButton;
	
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement ApplyButton;
	
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
	
	@FindBy(xpath="//a[@href='/crf3/Studies/AddEdit?studyId=1076']")
	WebElement ViewLink;
	
	@FindBy(xpath="//a[@href='/crf3/Studies/AddEditPageMapping?studyId=1076']")
	WebElement ConfigLink;
	
	@FindBy(xpath="//a[@href='/crf3/Studies/Delete?studyId=1075']")
	WebElement DeleteLink;
	
	//initializing page object
			public AppAdminStudiesPage() throws IOException {
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
			public AppAdminEditStudiesPage clickOnViewLink() throws IOException {
				ViewLink.click();
				return new AppAdminEditStudiesPage();
			}
			public AppAdminStudyMappingPage clickOnConfigLink() throws IOException {
				ConfigLink.click();
				return new AppAdminStudyMappingPage();
			}
			public AppAdminDeleteConfirmationPage clickOnDeleteLink() throws IOException {
				DeleteLink.click();
				return new AppAdminDeleteConfirmationPage();
			}
			public AppAdminAddStudiesPage clickOnAddNewButton() throws IOException {
				AddNewButton.click();
				return new AppAdminAddStudiesPage();
			}
			public AppAdminStudiesPage clickOnApplyButton() throws IOException {
				ApplyButton.click();
				return new AppAdminStudiesPage();
			}
			
			
			











}
