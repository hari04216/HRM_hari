package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.GenericUtilities.WebDriverUtility;

public class CreateBranch extends WebDriverUtility {

	WebDriver driver;

	public  CreateBranch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "hr_email")
	//name="hr_email"
	private WebElement hremail;

	public void sendHRemail1(String hrheadusername) {
		hremail.sendKeys(hrheadusername);

	}

	@FindBy(name = "hr_password")
	private WebElement hrpassword;

	public void sendHRpassword1(String hrheadpassword) {
		hrpassword.sendKeys(hrheadpassword);

	}

	@FindBy(id = "hr_type")
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

	@FindBy(xpath = "//p[normalize-space()='BRANCHES']")
	private WebElement Branches;

	public void Branches() {
		Branches.click();
	}

	@FindBy(xpath = "//p[normalize-space()='Add Braches']")
	private WebElement Addbranches;

	public void Addbranches() {
		Addbranches.click();

	}

	@FindBy(xpath = "//button[normalize-space()='Add Branches']")
	private WebElement AddBranches1;

	public void AddBranches1() {
		AddBranches1.click();
	}

	@FindBy(name = "branches_name")
	private WebElement Branchname;

	public void sendBranchName(String btr) {
		Branchname.sendKeys(btr);

	}

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement save;

	public void clickOnSave() {
		save.click();

	}

}
