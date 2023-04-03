package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.GenericUtilities.WebDriverUtility;

public class CreateCorporate extends WebDriverUtility {

	WebDriver driver;

	public  CreateCorporate(WebDriver driver) {
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
		Select select=new Select( HRtype);
		select.selectByValue("HR Head");
	}

	@FindBy(name = "login_hr")
	private WebElement hrLogin;

	public void clickLogin() {
		hrLogin.click();
	}

	@FindBy(xpath="//p[normalize-space()='CORPORATE']")
	private WebElement Corporate;
	public void clickOnCorporate()
	{
		Corporate.click();
	}
	
	@FindBy(xpath="//p[normalize-space()='Add Corporate']")
	private WebElement AddCorporate;
	
	public void clickOnAddCorporate()
	{
		AddCorporate.click();
	}
	
	
	@FindBy(xpath="//button[normalize-space()='Add Corporate']")
	private WebElement AddCorporate1;
	
	public void clickOnAddCorporate1()
	{
		AddCorporate1.click();
	}
	
	@FindBy(name="corporate_name")
	private WebElement Corporatename;
	
	public void sendCorporateName(String testing)
	{
		Corporatename.sendKeys(testing);
	}
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement save;
	
	public void clickOnSave()
	{
		save.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
