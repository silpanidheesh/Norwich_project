package com.qa.admin.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class AdminListUserPage extends TestBase {
	@FindBy(xpath="//*[@id=\"userstable\"]/div/div[1]/div/form/div/div[1]/div[1]/div/label")
	WebElement FirstNameTextField;
	
	@FindBy(xpath="//html//div[2]/div[1]/input[1]")
	WebElement LastNameTextField;
	
	@FindBy(xpath="//div[@class='form-group']//select[@class='form-control']")
	WebElement ActiveCheckBox;
	
	@FindBy(xpath="//*[@id=\"userstable\"]/div/div[1]/div/form/div/div[2]/div/button")
	WebElement ApplyButton;
	
	@FindBy(xpath="//*[@id=\"userstable\"]/div/div[1]/div/form/div/div[2]/div/a")
	WebElement AddNewButton;
	
	
	
	
	//initializing page object
	public AdminListUserPage() throws IOException {
		PageFactory.initElements(driver, this);
		}
	
	/*public void selectUserByFirstName() {
		FirstNameTextField.sendKeys(keysToSend);
	}*/
			

}
