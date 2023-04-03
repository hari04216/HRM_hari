package com.HRM_copy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.FileUtility;
import com.pomRepository.CreateBranch;

public class Create_Branch02 extends BaseClass {

	@Test
	public void create_Branch02() throws Throwable {
	
		// Validating the login page
		String expectedTitle = elib.readDataFromexcel("title", 0, 1);
		// String expectedTitle = "Admin Log in";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Login Page is Displayed and varified");
		} else {
			System.err.println("Login page is not displayed and varified");
		}

		CreateBranch branch = new CreateBranch(driver);
		// login to the application
		FileUtility flib=new FileUtility();
		String hrheadusername = flib.readproperityfile("hrheadusername");
		String hrheadpassword = flib.readproperityfile("hrheadpassword");
		branch.sendHRemail1(hrheadusername);
		branch.sendHRpassword1(hrheadpassword);
		branch.selectThePosition("HR Head");
		// Select select = new Select(driver.findElement(By.id("hr_type")));
		// select.selectByValue("HR Head");
		branch.clickLogin();
		// driver.findElement(By.name("login_hr")).click();

		// validating the popup
		String expetedpopuptext = elib.readDataFromexcel("title", 1, 1);

		// String expectedPopuptext = "Login Successfully!!";//Insert Successfully!!!
		String actualPopuptext = driver.switchTo().alert().getText();
		if (actualPopuptext.equals(expetedpopuptext)) {
			System.out.println("Popup is displayed and varified upon popup text");
		} else {
			System.err.println("Popup is not displayed and varified upon popup text");
		}

		driver.switchTo().alert().accept();

		String expectedTabName = elib.readDataFromexcel("title", 2, 1);

		// validating the Homepage/Dashboard
		// String expectedTabName = "Dashboard";
		String actualTabName = driver.findElement(By.xpath("//div[@class='row mb-2']//h1")).getText();

		if (actualTabName.equals(expectedTabName)) {
			System.out.println("Dashboard is displayed and varified on board name");
		} else {
			System.err.println("Dashboard is not displayed and varified on board name");
		}

		// creating Branches and validating the page

		branch.Branches();
		branch.Addbranches();
		branch.AddBranches1();

		String expectedAddBranchesPopupTitle =elib.readDataFromexcel("title", 7, 1);
		//String expectedAddBranchesPopupTitle = "Add Branches";
WebDriverWait Wait=new WebDriverWait(driver, 10);
		String actualAddBranchesPopupTitle = Wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Add Branches']")))
				.getText();
		// String actualAddBranchesPopupTitle=
		// driver.findElement(By.xpath("//h4[text()='Add Branches']")).getText();

		if (actualAddBranchesPopupTitle.equals(expectedAddBranchesPopupTitle)) {
			System.out.println("Add Braches popup is displayed and varified upon title");
		} else {
			System.err.println("Add Braches popup is not displayed and varified upon title");
		}

		branch.sendBranchName("btr");
		branch.clickOnSave();
		// validating the popup
		
		String expectedBranchInsertPopuptext=elib.readDataFromexcel("title", 8, 1);
		//String expectedBranchInsertPopuptext = "Insert Successfully!!!";// Insert Successfully!!!
		String actualBranchInsertPopuptext = driver.switchTo().alert().getText();
		if (actualBranchInsertPopuptext.equals(expectedBranchInsertPopuptext)) {
			System.out.println("Popup is displayed and varified upon popup text");
		} else {
			System.err.println("Popup is not displayed and varified upon popup text");
		}
		driver.switchTo().alert().accept();
		boolean flag = false;
		List<WebElement> branchesNames = driver.findElements(By.cssSelector("tbody tr td:nth-child(2)"));
		for (WebElement branch1 : branchesNames) {
			if (branch1.getText().equals("btr")) {
				flag = true;
				System.out.println("The Branch is sucessfully created");
				break;
			}
		}
		if (!flag) {
			System.out.println("The Branch is not created");
		}
	}
}
