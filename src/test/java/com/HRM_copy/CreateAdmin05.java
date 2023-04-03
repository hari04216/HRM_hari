package com.HRM_copy;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.FileUtility;
import com.pomRepository.createAdmin;

public class CreateAdmin05 extends BaseClass {
	// create admin and login as same credentials

	@Test
	public void CreteAdmin() throws Throwable {

		// Validating the login pagez
		String expectedTitle = elib.readDataFromexcel("title", 0, 1);
		// String expectedTitle = "Admin Log in";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Login Page is Displayed and varified");
		} else {
			System.err.println("Login page is not displayed and varified");
		}

		FileUtility flib = new FileUtility();
		String hrheadusername = flib.readproperityfile("hrheadusername");
		String hrheadpassword = flib.readproperityfile("hrheadpassword");
		createAdmin admin = new createAdmin(driver);
		admin.sendHRemail(hrheadusername);
		admin.sendHRpassword(hrheadpassword);
		admin.selectHrtype();
		admin.clickLogin();
		// login to the application

		// validating the popup
		String expectedPopuptext = elib.readDataFromexcel("title", 1, 1);
		// String expectedPopuptext = "Login Successfully!!";//Insert Successfully!!!
		String actualPopuptext = driver.switchTo().alert().getText();
		if (actualPopuptext.equals(expectedPopuptext)) {
			System.out.println("Popup is displayed and varified upon popup text");
		} else {
			System.err.println("Popup is not displayed and varified upon popup text");
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

		admin.clickAdmin();
		admin.AddAdmin();
		admin.AddAdmin1();
		String expectedAddAdminPopupTitle = elib.readDataFromexcel("title", 4, 1);
		WebDriverWait Wait = new WebDriverWait(driver, 10);
		// String expectedAddAdminPopupTitle="Add Admin";
		String actualAddAdminPopupTitle = Wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Add Admin']"))).getText();

		if (actualAddAdminPopupTitle.equals(expectedAddAdminPopupTitle)) {
			System.out.println("Add Admin popup is displayed and varified upon title");
		} else {
			System.err.println("Add Admin popup is not displayed and varified upon title");
		}

		// fill the form for admin
		HashMap<String, String> admindataMap = elib.readMultipleData("admindata");
		admin.fillTheAdminForm(admindataMap);
		admin.clickOnSave();

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
			if (empName.getText().equals("krish")) {
				flag = true;
				System.out.println("The Admin is sucessfully created");
				break;
			}
		}
		if (!flag) {
			System.out.println("The Admin is not created");
		}

		
		
		// Logout of application
		admin.clickonWelcome();
		admin.clickOnLogout();

		String expectedLogoutPopuptext = elib.readDataFromexcel("title", 6, 1);
		// String expectedLogoutPopuptext = "Successfully Logout!";//Successfully
		// Logout!
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
		
		/*
		admin.sendHrEmail();
		admin.sendHrPassword();
		admin.selectHrtype();
		admin.clickOnLoinHr();

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
		driver.quit();

	}
	*/
}
}
