package com.pomRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
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

public class AdminLogin extends WebDriverUtility {

	WebDriver driver;
	ExcelUtility elib = new ExcelUtility();
	JavaUtility jlib = new JavaUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	FileUtility flib = new FileUtility();

	public AdminLogin(WebDriver driver) {
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

	@FindBy(id = "hr_type")
	private WebElement HRtype;

	public void selectThePosition(String position) {
		Select select = new Select(HRtype);
		select.selectByValue("HR Head");
	}

	@FindBy(name = "login_hr")
	private WebElement hrLogin;

	public void clickLogin() {
		hrLogin.click();
	}

	// driver.switchTo().alert().accept();
	@FindBy(xpath = "//p[normalize-space()='ADMIN']")
	private WebElement Admin;

	public void clickAdmin()

	{
		Admin.click();
	}

	@FindBy(xpath = "//p[normalize-space()='Add Admin']")
	private WebElement AddAdmin;

	public void AddAdmin() {
		AddAdmin.click();
	}

	@FindBy(xpath = "//button[normalize-space()='Add Admin']")
	private WebElement AddAdmin1;

	public void AddAdmin1() {
		AddAdmin1.click();
	}

	public void fillTheAdminForm(HashMap<String, String> admindatamap) throws Throwable {

		for (Entry<String, String> set : admindatamap.entrySet()) {
			if (set.getKey().equals("hr_type")) {
				WebElement selectType_dropdown = driver
						.findElement(By.xpath("//h4[text()='Add Admin']/../..//select[@name='" + set.getKey() + "']"));
				select(selectType_dropdown, set.getValue());
			} else {
				driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//input[@name='" + set.getKey() + "']"))
						.sendKeys(set.getValue());
			}
		}
	}

//			driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//input[@name='hr_firstname']")).sendKeys(acName);
//WebElement selectType_dropdown = driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//select[@name='hr_type']"));
	// Select selectType_DD = new Select(selectType_dropdown);
//	selectType_DD.selectByVisibleText("→ HR Officer");
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement save;

	public void clickOnSave() {
		save.click();
	}

	// driver.switchTo().alert().accept();

	@FindBy(xpath = "//i[@class=\"fa fa-user\"]")
	private WebElement Welcome;

	public void clickOnWelcome() {
		Welcome.click();
	}

	@FindBy(xpath = "//a[normalize-space()='Log Out']")
	private WebElement Logout;

	public void ClickOnLogout() {
//		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Welcome.click();
		wait.until(ExpectedConditions.visibilityOf(Logout)).click();

	}

	// driver.switchTo().alert().accept();

}
