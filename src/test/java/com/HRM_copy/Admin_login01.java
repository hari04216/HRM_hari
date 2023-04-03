package com.HRM_copy;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.pomRepository.AdminLogin;

@Listeners(com.GenericUtilities.implementation.class)
//@Listeners(com.GenericUtilities.ListenerImplementation.class)
public class Admin_login01 extends BaseClass {
	@Test(retryAnalyzer = com.GenericUtilities.RetryImpcalss.class)
	public void AdminLogin() throws Throwable {

		String expectedTitle = elib.readDataFromexcel("title", 0, 1);
		// String expectedTitle = "Admin Log in";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Login Page is Displayed and varified");
		} else {
			System.err.println("Login page is not displayed and varified");
		}
		Assert.fail();

		String hrheadusername = flib.readproperityfile("hrheadusername");
		String hrheadpassword = flib.readproperityfile("hrheadpassword");
		
		AdminLogin AL = new AdminLogin(driver);
		AL.sendHRemail(hrheadusername);
		AL.sendHRpassword(hrheadpassword);
		AL.selectThePosition("HR Head");
		AL.clickLogin();
		// validating the pop-updsd
		String expectedPopuptext = elib.readDataFromexcel("title", 1, 1);
		// String expectedPopuptext = "Login Successfully!!";//Insert Successfully!!!
		String actualPopuptext = driver.switchTo().alert().getText();
		if (actualPopuptext.equals(expectedPopuptext)) {
			System.out.println(" login Popup is displayed and varified upon popup text");
		} else {
			System.err.println(" login Popup is not displayed and varified upon popup text");
		}

		driver.switchTo().alert().accept();
		// validating the Homepage/Dashboard
		String expectedTabName = elib.readDataFromexcel("title", 2, 1);
		// String expectedTabName = "Dashboard";
		String actualTabName = driver.findElement(By.xpath("//div[@class='row mb-2']//h1")).getText();

		if (actualTabName.equals(expectedTabName)) {
			System.out.println("Dashboard is displayed and varified on board name");
		} else {
			System.err.println("Dashboard is not displayed and varified on board name");
		}

		// creating the admin credentials
		AL.clickAdmin();
		String expectedAdminTabName = elib.readDataFromexcel("title", 3, 1);
		// String expectedAdminTabName = "Dashboard";
		String actualAdminTabName = driver.findElement(By.xpath("//div[@class='row mb-2']//h1")).getText();

		if (actualAdminTabName.equals(expectedAdminTabName)) {
			System.out.println("Admin page is displayed and varified on board name");
		} else {
			System.err.println("Admin page is not displayed and varified on board name");
		}

		AL.AddAdmin();
		AL.AddAdmin1();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String expectedAddAdminPopupTitle = elib.readDataFromexcel("title", 4, 1);
		// String expectedAddAdminPopupTitle="Add Admin";
		String actualAddAdminPopupTitle = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Add Admin']"))).getText();

		if (actualAddAdminPopupTitle.equals(expectedAddAdminPopupTitle)) {
			System.out.println("Add Admin popup is displayed and varified upon title");
		} else {
			System.err.println("Add Admin popup is not displayed and varified upon title");
		}

		Thread.sleep(2000);
		HashMap<String, String> admindatamap = elib.readMultipleData("admindata");
		AL.fillTheAdminForm(admindatamap);

		AL.clickOnSave();
		// popup for sucessfully
		String expectedAdminInsertPopuptext = elib.readDataFromexcel("title", 5, 1);
		// String expectedAdminInsertPopuptext = "Insert Successfully!!!";//Insert
		// Successfully!!!
		String actualAdminInsertPopuptext = driver.switchTo().alert().getText();
		if (actualAdminInsertPopuptext.equals(expectedAdminInsertPopuptext)) {
			System.out.println("Popup is displayed and varified upon popup text");
		} else {
			System.err.println("Popup is not displayed and varified upon popup text");
		}

		driver.switchTo().alert().accept();
		boolean flag = false;
		List<WebElement> EmployeeNames = driver.findElements(By.cssSelector("tbody tr td:nth-child(2)"));
		for (WebElement empName : EmployeeNames) {
			if (empName.getText().equals("QSP")) {
				flag = true;
				System.out.println("The Admin is sucessfully created");
				break;
			}
		}
		if (!flag) {
			System.out.println("The Admin is not created");
		}

		// Logout of application

	}
}
