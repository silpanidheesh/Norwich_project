package com.qa.appadmin.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import com.qa.base.TestBase;
import com.qa.util.testUtil;

public class AppAdminChangePasswordPage extends TestBase{
	testUtil teutil;
	@FindBy(xpath="//input[@id='OldPassword']")
	WebElement oldPassword;
	
	@FindBy(xpath="//*[text()='Change Your Password']")
	WebElement ChangePasswordHeadLine;
	
	@FindBy(xpath="//*[@id='NewPassword']")
	WebElement newPassword;
	
	@FindBy(xpath="//*[@id='NewPasswordAgain']")
	WebElement ReEnterNewPassword;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement changePassword;
	
	//initializing page object
	
	public AppAdminChangePasswordPage() throws IOException {
			PageFactory.initElements(driver, this);
		}
	//Actions
	public boolean verifyChangePasswordTitle() throws IOException {
		return ChangePasswordHeadLine.isDisplayed();
	}
	public void changePassword(String oldpass,String newpass,String renewpass) throws IOException {
		oldPassword.sendKeys(oldpass);
		System.out.println(oldpass);
		newPassword.sendKeys(newpass);
		ReEnterNewPassword.sendKeys(renewpass);
		
		teutil=new testUtil();
		JavascriptExecutor executor = (JavascriptExecutor)driver;

		executor.executeScript("scroll(0,250)");
		System.out.println(changePassword.isDisplayed());
		changePassword.click();
		System.out.println("password changed successfully and your new password is"+renewpass);
	}
	

}
