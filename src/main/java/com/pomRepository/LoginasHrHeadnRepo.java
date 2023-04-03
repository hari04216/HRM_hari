package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;

public class LoginasHrHeadnRepo{

	
	public WebDriver driver;
	ExcelUtility elib=new ExcelUtility();
	JavaUtility jlib=new JavaUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	FileUtility flib=new FileUtility();

	

	public LoginasHrHeadnRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(name = "hr_email")
	private WebElement hremail;
	public void sendHRemail(String hrheadusername) {
		hremail.sendKeys(hrheadusername);

	}

	@FindBy(name = "hr_password")
	private WebElement hrpassword;

	public void sendHRpassword(String hrheadpassword) {
		hrpassword.sendKeys(hrheadpassword);

	}

	@FindBy(id="hr_type")
	private WebElement HRtype;

	public void selectThePosition(String position) {
		Select select=new Select( HRtype);
		select.selectByValue("HR Head");
	}

	@FindBy(name = "login_hr")
	private WebElement hrLogin;

	public void clickLogin() {
		hrLogin.click();
	}

	// driver.switchTo().alert().accept();
	

	// driver.switchTo().alert().accept();

	@FindBy(xpath ="//i[@class=\"fa fa-user\"]")
	private WebElement Welcome;

	public void clickOnWelcome() {
		Welcome.click();
	}

	@FindBy(xpath = "//a[normalize-space()='Log Out']")
	private WebElement Logout;

	public void ClickOnLogout() {
//		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		Welcome.click();
		wait.until(ExpectedConditions.visibilityOf(Logout)).click();

	}

	// driver.switchTo().alert().accept();

}
	
	

