package com.HRM_copy;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.pomRepository.validateAdmin;

public class ValidatingAdminCreatedOrNot06 extends BaseClass {
	
	@Test
	public void ValidateAdmin() throws Throwable
	{
	
		
		String expectedTitle = "Admin Log in";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Login Page is Displayed and varified");
		} else {
			System.err.println("Login page is not displayed and varified");
		}

		// login to the application
		
		String hrheadusername = flib.readproperityfile("hrheadusername");
		String hrheadpassword = flib.readproperityfile("hrheadpassword");
	
		validateAdmin val = new validateAdmin(driver);
		val.sendHRemail(hrheadusername);
		val.sendHRpassword(hrheadpassword);
		val.selectThePosition("HR Head");
		val.clickLogin();

		// validating the pop-up
		String expectedPopuptext = "Login Successfully!!";// Insert Successfully!!!
		String actualPopuptext = driver.switchTo().alert().getText();
		if (actualPopuptext.equals(expectedPopuptext)) {
			System.out.println("Popup is displayed and varified upon popup text");
		} else {
			System.err.println("Popup is not displayed and varified upon popup text");
		}

		driver.switchTo().alert().accept();

		// validating the Homepage/Dashboard
		String expectedTabName = "Dashboard";
		String actualTabName = driver.findElement(By.xpath("//div[@class='row mb-2']//h1")).getText();

		if (actualTabName.equals(expectedTabName)) {
			System.out.println("Dashboard is displayed and varified on board name");
		} else {
			System.err.println("Dashboard is not displayed and varified on board name");
		}

		// creating the admin credentials

		val.clickAdmin();
		val.AddAdmin();
		val.AddAdmin1();
		String expectedAdminTabName = "Dashboard";
		String actualAdminTabName = driver.findElement(By.xpath("//div[@class='row mb-2']//h1")).getText();

		if (actualAdminTabName.equals(expectedAdminTabName)) {
			System.out.println("Admin page is displayed and varified on board name");
		} else {
			System.err.println("Admin page is not displayed and varified on board name");
		}

		WebDriverWait wait = new WebDriverWait(driver, 10);
		String expectedAddAdminPopupTitle = "Add Admin";
		String actualAddAdminPopupTitle = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Add Admin']"))).getText();

		if (actualAddAdminPopupTitle.equals(expectedAddAdminPopupTitle)) {
			System.out.println("Add Admin popup is displayed and varified upon title");
		} else {
			System.err.println("Add Admin popup is not displayed and varified upon title");
		}
		HashMap<String, String> admindataMap = elib.readMultipleData("admindata");
		val.fillTheAdminForm(admindataMap);
		val.clickOnSave();

		//// popup for sucessfully
		String expectedAdminInsertPopuptext = "Insert Successfully!!!";// Insert Successfully!!!
		String actualAdminInsertPopuptext = driver.switchTo().alert().getText();
		if (actualAdminInsertPopuptext.equals(expectedAdminInsertPopuptext)) {
			System.out.println(" insert Popup is displayed and varified upon popup text");
		} else {
			System.err.println("Popup is not displayed and varified upon popup text");
		}

		driver.switchTo().alert().accept();
		boolean flag = false;
		List<WebElement> EmployeeNames = driver.findElements(By.cssSelector("tbody tr td:nth-child(2)"));
		for (WebElement empName : EmployeeNames) {
			if (empName.getText().equals("krish")) {
				flag = true;
				System.out.println("The Admin is sucessfully created");
				break;
			}
		}
		if (!flag) {
			System.out.println("The Admin is not created");
		}

		// driver.findElement(By.xpath("//table[@id=\"example1\"]//tr[3]//td[text()='krish']")).click();
		// Add To search the Created Admin in Search engin

//		//edit the details
		String acName = "krish";		for (int i = 0; i < 2; i++) {
//			driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
//		}
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
//		WebDriverWait wait=new WebDriverWait(driver, 10);
		for (;;) {
			try {
				driver.findElement(By.xpath("//td[text()='" + acName + "']/..//i[@title='Edit Employee']")).click();

				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//td[text()='" + acName + "']/..//td[1]")).click();
			}
		}

		String expectedEditAdminPopupTitle = "Edit Admin";
		String actualEditAdminPopupTitle = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Edit Admin']"))).getText();

		if (actualEditAdminPopupTitle.equals(expectedEditAdminPopupTitle)) {
			System.out.println("Edit Admin popup is displayed and varified upon title");
		} else {
			System.err.println("Edit Admin popup is not displayed and varified upon title");
		}
		val.clickOnSave();
		
		
		// popup for sucessfully
		String expectedAdminEditPopuptext = "Update Successfully!!!";// Update Successfully!!!
		String actualAdminEditPopuptext = driver.switchTo().alert().getText();
		if (actualAdminEditPopuptext.equals(expectedAdminEditPopuptext)) {
			System.out.println("  update Popup is displayed and varified upon popup text");
		} else {
			System.err.println(" update Popup is not displayed and varified upon popup text");
		}

		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//input[@name='hr_email']"))
				.sendKeys("krish@gmail.com");
		driver.findElement(By.xpath("//h4[text()='Add Admin']/../..//input[@name='hr_password']"))
				.sendKeys("krish@123");

		
	
		// Logout of application
		driver.findElement(By.xpath("//b[text()='Welcome!,']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Log Out']")).click();
		String expectedLogoutPopuptext = "Successfully Logout!";// Successfully Logout!
		String actualLogoutPopuptext = driver.switchTo().alert().getText();
		if (actualLogoutPopuptext.equals(expectedLogoutPopuptext)) {
			System.out.println("Popup is displayed and varified upon popup text");
		} else {
			System.err.println("Popup is not displayed and varified upon popup text");
		}
		driver.switchTo().alert().accept();

		String actualAftreLogoutTitle = driver.getTitle();
		if (actualAftreLogoutTitle.equals(expectedTitle)) {
			System.out.println("Login Page is Displayed and varified");
		} else {
			System.err.println("Login page is not displayed and varified");
		}

		// validate the created credentials
		/*
		 * Position: HR Head Email Address: krish1@gmail.com password: krish@123
		 */
		// login to the application
		driver.findElement(By.name("hr_email")).sendKeys("krish1@gmail.com");
		driver.findElement(By.name("hr_password")).sendKeys("krish11@123");
		Select selectType = new Select(driver.findElement(By.id("hr_type")));
		selectType.selectByValue("HR Head");
		driver.findElement(By.name("login_hr")).click();

		// validating the popup
		String expectedLoginPopuptext = "Login Successfully!!";// Insert Successfully!!!
		String actualLoginPopuptext = driver.switchTo().alert().getText();
		if (actualLoginPopuptext.equals(expectedLoginPopuptext)) {
			System.out.println("Popup is displayed and varified upon popup text");
		} else {
			System.err.println("Popup is not displayed and varified upon popup text");
		}

		driver.switchTo().alert().accept();

		// terminate the browser
//		driver.quit();

	}
}
}