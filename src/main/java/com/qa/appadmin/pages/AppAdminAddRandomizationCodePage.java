package com.qa.appadmin.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class AppAdminAddRandomizationCodePage extends TestBase{
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
	
		
	@FindBy(xpath="//a[@href='/crf3/Studies/RandomizationCodeList?studyId=1076']")
	WebElement CancelButton ;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement SaveButton ;
	
	@FindBy(xpath="//a[@href='/crf3/Studies/AddEditRandomCode?studyId=1076']")
	WebElement AddNewButton ;
	
	@FindBy(xpath="//input[@id='RandomizationCode']")
	WebElement RandomizationCodeTextBox;
	
	@FindBy(xpath="//input[@id='StudyNumber']")
	WebElement StudyNumberTextBox;
	
	@FindBy(xpath="//input[@id='BatchNumber']")
	WebElement BatchNumberTextBox;
	
	@FindBy(xpath="//input[@id='Expirydate']")
	WebElement ExpiryDateTextBox;
	
	@FindBy(xpath="//input[@id='ProductName']")
	WebElement NameOfTheProductTextBox;
	
	@FindBy(xpath="//input[@id='ProductStrength']")
	WebElement StrengthOfTheProductTextBox;
	
	@FindBy(xpath="//input[@id='DosageForm']")
	WebElement DosageFormTextBox;
	
	@FindBy(xpath="//input[@id='RouteAdministration']")
	WebElement RouteOfAdministrationTextBox;
	
	@FindBy(xpath="//input[@id='SponsorNameAndAddress']")
	WebElement SponsorNameAndAddressTextBox;
	
	@FindBy(xpath="//input[@id='PrincipalInvestigator']")
	WebElement NameOfPrincipalInvestigatorTextBox;
	
	@FindBy(xpath="//input[@id='StorageCondition']")
	WebElement StorageConditionTextBox;
	
	@FindBy(xpath="//input[@id='Quantity']")
	WebElement QuantityTextBox;
	
	@FindBy(xpath="//input[@id='DirectionsOfUse']")
	WebElement DirectionsOfUseTextBox;
	

	


	//initializing page object
	public AppAdminAddRandomizationCodePage() throws IOException {
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
	public AppAdminRandomizationCodeListPage clickOnSave(String RandomizationCode,String StudyNumber,String BatchNumber,
			String ExpiryDate,String NameOfTheProduct,String StrengthOfTheProduct,	String DosageForm,String RouteOfAdministration,
			String SponsorNameAndAddress,String NameOfPrincipalInvestigator,String StorageCondition,String Quantity,
			String DirectionsOfUse) throws IOException 
	{
		
		RandomizationCodeTextBox.sendKeys(RandomizationCode);
		StudyNumberTextBox.sendKeys(StudyNumber);
		BatchNumberTextBox.sendKeys(BatchNumber);
		ExpiryDateTextBox.sendKeys(ExpiryDate);
		NameOfTheProductTextBox.sendKeys(NameOfTheProduct);
		StrengthOfTheProductTextBox.sendKeys(StrengthOfTheProduct);
		DosageFormTextBox.sendKeys(DosageForm);
		RouteOfAdministrationTextBox.sendKeys(RouteOfAdministration);
		SponsorNameAndAddressTextBox.sendKeys(SponsorNameAndAddress);
		NameOfPrincipalInvestigatorTextBox.sendKeys(NameOfPrincipalInvestigator);
		StorageConditionTextBox.sendKeys(StorageCondition);
		QuantityTextBox.sendKeys(Quantity);
		DirectionsOfUseTextBox.sendKeys(DirectionsOfUse);
		SaveButton.click();
		
		
		return new AppAdminRandomizationCodeListPage();
		
	}
	public AppAdminRandomizationCodeListPage clickOnCancel() throws IOException {
		CancelButton.click();
		return new AppAdminRandomizationCodeListPage();
	}
	

}
