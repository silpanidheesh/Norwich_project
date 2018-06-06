package com.qa.admin.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;
import com.qa.util.testUtil;

public class AdminAddNewUserPage extends TestBase {
	testUtil test_util;
	
	
	@FindBy(xpath="//*[contains(text(),'Add User')]")
	WebElement AddUserLabel;
	
	@FindBy(xpath="//*[@id=\"Email\"]")
	WebElement EmailTextField;
	
	@FindBy(xpath="//*[@id='FirstName']")
	WebElement FirstNameTextField ;
	
	@FindBy(xpath="//*[@id='LastName']")
	WebElement LastNameTextField;
	
	@FindBy(xpath="//*[@id='Password']")
	WebElement PasswordTextField;
	
	@FindBy(xpath="//*[@id='ReenterPassword']")
	WebElement ReenterPasswordTextField;
	
	@FindBy(xpath="//*[@id='Active']")
	WebElement ActiveCheckBox;
	
	@FindBy(xpath="/html/body/section/div[2]/div/div[1]/form/div[7]/div[1]/div[1]/label/input")
	WebElement AdministratorCheckBox;
	
	@FindBy(xpath="/html/body/section/div[2]/div/div[1]/form/div[7]/div[1]/div[2]/label/input")
	WebElement ApplicationAdminCheckBox;
	
	@FindBy(xpath="/html/body/section/div[2]/div/div[1]/form/div[7]/div[1]/div[3]/label/input")
	WebElement DataEntryOperatorCheckBox;
	
	@FindBy(xpath="html/body/section/div[2]/div/div/form/div[7]/div/div[4]")
	WebElement PrincipleInvestigatorCheckBox;
	
	@FindBy(xpath="/html/body/section/div[2]/div/div[1]/form/div[7]/div[1]/div[5]/label/input")
	WebElement QACheckBox;
	
	@FindBy(xpath="/html/body/section/div[2]/div/div[1]/form/div[7]/div[1]/div[6]/label/input")
	WebElement QCCheckBox;
	
	@FindBy(xpath="/html/body/section/div[2]/div/div[1]/form/div[8]/a")
	WebElement CancelButton;
	
	@FindBy(xpath="//*[text()='Save']")
	WebElement SaveButton;
	
	@FindBy(xpath="//*[@id=\"dropdownMenu1\"]")
	WebElement userName;
	
	@FindBy(xpath="/html/body/header/div/div/div[3]/div/ul/li[1]/a")
	WebElement changePasswordLink ;
	
	@FindBy(xpath="/html/body/header/div/div/div[3]/div/ul/li[2]/a")
	WebElement logoutLink ;
	
	@FindBy(xpath="/html/body/section/h2")
	WebElement pageTitle ;
	
	//initializing page object
	public AdminAddNewUserPage() throws IOException {
		PageFactory.initElements(driver, this);
		}
	//Actions
	public String verifyAddNewUserPageTitle() {
	
		return driver.getTitle();
	}
	
	public boolean verifyAddUserLabel() throws IOException {
		test_util=new testUtil();
		test_util.waitForClick(AddUserLabel);
		return AddUserLabel.isDisplayed();
	}
	
	public boolean verifyCorrectUsername() {
		return userName.isDisplayed();
	}
	public AdminListUserPage AddNewUsers(String email,String fname,String lname,String password,String repass, String role) throws InterruptedException, IOException {
		EmailTextField.sendKeys(email);
		FirstNameTextField.sendKeys(fname);
		LastNameTextField.sendKeys(lname);
		PasswordTextField.sendKeys(password);
		ReenterPasswordTextField.sendKeys(repass);
		test_util=new testUtil();
		driver.manage().timeouts().implicitlyWait(testUtil.implicitWait, TimeUnit.SECONDS);
		
		List <WebElement> CheckBox=driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(int i=0; i<CheckBox.size();i++ )
			 
		 {
		 WebElement El =CheckBox.get(i);
		 String id =CheckBox.get(i).getAttribute("value");
		 if(id.equals(role))
		 {   
			 //if element is not clickable at this point error use this code
			 JavascriptExecutor executor = (JavascriptExecutor)driver;
			 executor.executeScript("scroll(0,250)");
			 
			 CheckBox.get(i).click();
		 
		 }
		 }
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;

		executor.executeScript("scroll(0,250)");
		SaveButton.click();		
		
		return new AdminListUserPage();
	}
	

}
