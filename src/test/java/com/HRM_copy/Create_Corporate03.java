package com.HRM_copy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.FileUtility;
import com.pomRepository.CreateCorporate;

public class Create_Corporate03 extends BaseClass {

	@Test
	public void CreateCorporate03 () throws Throwable {

	
		String expectedTitle = elib.readDataFromexcel("title", 0, 1);
		// String expectedTitle = "Admin Log in";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Login Page is Displayed and varified");
		} else {
			System.err.println("Login page is not displayed and varified");
		}

		// login to the application using hrhead credentials

		CreateCorporate corpo = new CreateCorporate(driver);
		FileUtility flib=new FileUtility();
		String hrheadusername = flib.readproperityfile("hrheadusername");
		String hrheadpassword = flib.readproperityfile("hrheadpassword");
		corpo.sendHRemail(hrheadusername);
		corpo.sendHRpassword(hrheadpassword);
		corpo.selectThePosition("HR Head");
		corpo.clickLogin();

		String expectedPopuptext = elib.readDataFromexcel("title", 1, 1);
		// String expectedPopuptext = "Login Successfully!!";// Insert Successfully!!!
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

		// creating corporate and validating the page
		corpo.clickOnCorporate();
		corpo.clickOnAddCorporate();
		corpo.clickOnAddCorporate1();
		String expectedCorporateTabName = elib.readDataFromexcel("title", 9, 1);
		// String expectedCorporateTabName = "Dashboard";
		String actualCorporateTabName = driver.findElement(By.xpath("//div[@class='row mb-2']//h1")).getText();

		if (expectedCorporateTabName.equals(actualCorporateTabName)) {
			System.out.println("Corporate page is displayed and varified on board name");
		} else {
			System.err.println("Corporate page is not displayed and varified on board name");
		}

		String expectedAddCorporatePopupTitle = elib.readDataFromexcel("title", 10, 1);
		// String expectedAddCorporatePopupTitle = "Add Corporate";
		WebDriverWait wait=new WebDriverWait(driver, 10);
		String actualAddCorporatePopupTitle = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Add Corporate']")))
				.getText();

		if (actualAddCorporatePopupTitle.equals(expectedAddCorporatePopupTitle)) {
			System.out.println("Add Corporate popup is displayed and varified upon title");
		} else {
			System.err.println("Add Corporate popup is not displayed and varified upon title");
		}
		corpo.sendCorporateName("testing");
		corpo.clickOnSave();

		// validating the corporate insert popup
		String expectedInsertPopuptext = elib.readDataFromexcel("title", 11, 1);
		// String expectedInsertPopuptext = "Insert Successfully!!!";// Insert
		// Successfully!!!
		String actualInsertPopuptext = driver.switchTo().alert().getText();
		if (actualInsertPopuptext.equals(expectedInsertPopuptext)) {
			System.out.println("Popup is displayed and varified upon popup text");
		} else {
			System.err.println("Popup is not displayed and varified upon popup text");
		}
		driver.switchTo().alert().accept();
		boolean flag = false;
		List<WebElement> corporateNames = driver.findElements(By.cssSelector("tbody tr td:nth-child(2)"));
		for (WebElement corpName : corporateNames) {
			if (corpName.getText().equals("testing")) {
				flag = true;
				System.out.println("The Corporation is sucessfully created");
				break;
			}
		}
		if (!flag) {
			System.out.println("The Corporation is not created");

		}
	}
}
