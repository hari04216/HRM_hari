package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class HrmLogout extends WebDriverUtility {

			WebDriver driver;
			ExcelUtility elib=new ExcelUtility();
			JavaUtility jlib=new JavaUtility();
			WebDriverUtility wlib=new WebDriverUtility();
			FileUtility flib=new FileUtility();

			public HrmLogout(WebDriver driver) {
				this.driver = driver;
				PageFactory.initElements(driver, this);
			}


	
	@FindBy(xpath = "//b[text()='Welcome!,']")
	private WebElement welocme;

	public void clickonWelcome() {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(welocme)).click();
	}

	@FindBy(xpath = "//a[normalize-space()='Log Out']")
	private WebElement logout;

	public void clickOnLogout() {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(logout)).click();
	}

}
