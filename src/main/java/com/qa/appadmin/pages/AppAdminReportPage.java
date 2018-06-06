package com.qa.appadmin.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.admin.pages.AdminHomePage;
import com.qa.admin.pages.ChangePasswordPage;
import com.qa.base.TestBase;
import com.qa.util.testUtil;

public class AppAdminReportPage extends TestBase{
	testUtil test;
	@FindBy(xpath="//*[@id=\"dropdownMenu1\"]")
	WebElement userName;
	
	@FindBy(xpath="/html/body/header/div/div/div[3]/div/ul/li[1]/a")
	WebElement changePasswordLink ;
	
	@FindBy(xpath="/html/body/header/div/div/div[3]/div/ul/li[2]/a")
	public WebElement logoutLink ;
	
	@FindBy(xpath="//*[@id='StudyListModel']")
	WebElement selectStudyDropDown;
		
	@FindBy(xpath="//*[text()=' Demographic Data']")
	WebElement DemographicDataRadioButton;
	
	@FindBy(xpath="//*[text()='  Adverse events which occurred following test/reference product administration']")
	WebElement AdverseEventRadioButton;
	
	@FindBy(xpath="//*[text()='  Conmed Details ']")
	WebElement ConmedDetailsRadioButton;
	
	@FindBy(xpath="//*[text()=' Individual Lab Measurements- Hematology ']")
	WebElement HematologyRadioButton;
	
	@FindBy(xpath="//*[text()=' Individual Lab Measurements- Biochemistry ']")
	WebElement BiochemistryRadioButton;
	
	@FindBy(xpath="//*[text()='Clinical Pathology ']")
	WebElement ClinicalPathologyRadioButton;
	
	@FindBy(xpath="//*[text()='Serology ']")
	WebElement SerologyRadioButton ;
	
	@FindBy(xpath="//input[@id='btnsubmit']")
	WebElement ReportButton;

	public AppAdminReportPage() throws IOException {
		PageFactory.initElements(driver, this);	
	}
	
	public String verifyReportPageTitle() {
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
		act.click(userName).moveToElement(changePasswordLink);
		logoutLink.click();
		return new AppAdminHomePage();
	}
	
	public AppAdminReportDownloadPage reportGeneration(String report) throws IOException {
		Select select=new Select(selectStudyDropDown);
		select.selectByIndex(1);
		
		List <WebElement> RadioButtons=driver.findElements(By.xpath("//*[@id='reports']"));
		for(int i=0; i<RadioButtons.size();i++ )
			 
		 {
			
			
		 WebElement El =RadioButtons.get(i);
		 String id =RadioButtons.get(i).getAttribute("value");
		 if(id.equals(report))
		 {   
			
			 RadioButtons.get(i).isDisplayed();
			 RadioButtons.get(i).click();
		 
		 }
		 }
		
			
		JavascriptExecutor executor = (JavascriptExecutor)driver;

		executor.executeScript("scroll(0,250)");
		ReportButton.click();
		return new AppAdminReportDownloadPage();
	}
	

}
