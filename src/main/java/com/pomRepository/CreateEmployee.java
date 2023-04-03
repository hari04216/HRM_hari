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

import com.GenericUtilities.WebDriverUtility;

public class CreateEmployee extends WebDriverUtility {

	WebDriver driver;

	public CreateEmployee(WebDriver driver) {
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

	@FindBy(xpath = "//p[normalize-space()='CORPORATE']")
	private WebElement corporate;

	public void ClickOnCorporate() {
		corporate.click();
	}

	@FindBy(xpath = "//p[normalize-space()='Add Corporate']")
	private WebElement AddCorporate;

	public void AddCorporate() {
		AddCorporate.click();
	}

	@FindBy(xpath = "//button[normalize-space()='Add Corporate']")
	private WebElement AddCorporate1;

	public void AddCorporate1() {
		AddCorporate1.click();
	}

	@FindBy(name = "corporate_name")
	private WebElement CorporateName;

	public void SendCorporateName() {
		CorporateName.sendKeys("testing");

	}

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement save;

	public void ClickOnSave() {
		save.click();
	}

	@FindBy(xpath = "//p[normalize-space()='BRANCHES']")
	private WebElement Branches;

	public void ClickOnBranches() {
		Branches.click();
	}

	@FindBy(xpath = "//p[normalize-space()='Add Braches']")
	private WebElement AddBranches;

	public void ClickOnAddBranches() {
		AddBranches.click();
	}

	@FindBy(xpath = "//button[normalize-space()='Add Branches']")
	private WebElement AddBranches1;

	public void clickOnAddBranches1() {
		AddBranches1.click();
	}

	@FindBy(name = "branches_name")
	private WebElement BranchesName;

	public void SendBranchesName() {
		BranchesName.sendKeys("abc");
	}

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement save1;

	public void clickOnSave() {
		save1.click();
	}

	@FindBy(xpath = "//p[normalize-space()='EMPLOYEE']")
	private WebElement Employe;

	public void ClickOnEmployee() {
		Employe.click();
	}

	@FindBy(xpath = "//p[normalize-space()='Add Employee']")
	private WebElement AddEmployee;

	public void ClickOnAddEmployee()

	{
		AddEmployee.click();
	}

	@FindBy(xpath = "//button[normalize-space()='Add Employee']")
	private WebElement AddEmployee1;

	public void clickOnAddEmployee1()

	{
		AddEmployee1.click();
	}

	public void EmployeeForm(HashMap<String, String> empDataMap) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		for (Entry<String, String> set : empDataMap.entrySet()) {
			if (set.getKey().equals("employee_department")) {
				WebElement dept_dropdown = driver.findElement(
						By.xpath("//h4[text()='Add Employee']/../..//select[@name='" + set.getKey() + "']"));
				select(dept_dropdown, set.getValue());
				// WebElement dept_dropdown=driver.findElement(By.xpath("/h4[text()='Add
				// Employee']/../..//select[@name='employee_department']"));

			} else if (set.getKey().equals("employee_branches")) {
				WebElement branch_dropdown1 = driver.findElement(
						By.xpath("//h4[text()='Add Employee']/../..//select[@name='" + set.getKey() + "']"));
				select(set.getValue(), branch_dropdown1);
			} else {

				wait.until(ExpectedConditions.visibilityOf(driver.findElement(
						By.xpath("//h4[text()='Add Employee']/../..//input[@name='" + set.getKey() + "']"))))
						.sendKeys(set.getValue());
			}
		}
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

	// WebElement dept_dropdown=driver.findElement(By.xpath("/h4[text()='Add
	// Employee']/../..//select[@name='employee_department']"));
	// Select sel=new Select(dept_dropdown);
	// sel.selectByValue("testing");

	// WebElement dept_dropdown = driver.findElement(By.xpath("//h4[text()='Add
	// Employee']/../..//select[@name='employee_department']"));
	// Select department_DD = new Select(dept_dropdown);
	// department_DD.selectByVisibleText("testing");
	// WebElement branch_dropdown1 = driver.findElement(By.xpath("//h4[text()='Add
	// Employee']/../..//select[@name='employee_branches']"));
	// Select branch_DD = new Select(branch_dropdown1);

	// driver.findElement(By.xpath("//h4[text()='Add
	// Employee']/../..//input[@name='employee_firstname']")).sendKeys("harry");

	@FindBy(xpath = "//b[text()='Welcome!,']")
	private WebElement Welcome;

	public void clickOnWelcome() {
		Welcome.click();
	}

	@FindBy(xpath = "//a[normalize-space()='Log Out']")
	private WebElement logout;

	public void clickOnLogout() {
		logout.click();
	}

}
