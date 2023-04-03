package com.HRM_copy;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.ExcelUtility;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebDriverUtility;
import com.pomRepository.CreateEmployee;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_Employee_with_HrHeadCredentials04 extends BaseClass{
	
	@Test
	public void createEmployee() throws Throwable{
		
		//Validating the login page
		String expectedTitle =elib.readDataFromexcel("title", 0, 1);
		//String expectedTitle = "Admin Log in";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Login Page is Displayed and varified");
		}else {
			System.err.println("Login page is not displayed and varified");
		}
		
		//login to the application
		FileUtility flib=new FileUtility();
		String hrheadusername = flib.readproperityfile("hrheadusername");
		String hrheadpassword = flib.readproperityfile("hrheadpassword");
		CreateEmployee emp=new CreateEmployee(driver);
		emp.sendHRemail(hrheadusername);
		emp.sendHRpassword(hrheadpassword);
		emp.selectThePosition("HR head");
		emp.clickLogin();
		String expectedPopuptext=elib.readDataFromexcel("title", 1, 1);
		//validating the popup
		//String expectedPopuptext = "Login Successfully!!";//Insert Successfully!!!
		String actualPopuptext = driver.switchTo().alert().getText();
		if (actualPopuptext.equals(expectedPopuptext)) {
			System.out.println("Popup is displayed and varified upon popup text");
		}else {
			System.err.println("Popup is not displayed and varified upon popup text");
		}
		
		driver.switchTo().alert().accept();
		
		//validating the Homepage/Dashboard
		String expectedTabName =elib.readDataFromexcel("title", 2, 1);
		//String expectedTabName = "Dashboard";
		String actualTabName = driver.findElement(By.xpath("//div[@class='row mb-2']//h1")).getText();
		
		if (actualTabName.equals(expectedTabName)) {
			System.out.println("Dashboard is displayed and varified on board name");
		}else {
			System.err.println("Dashboard is not displayed and varified on board name");
		}
		
		//creating corporate and validating the page
		
		emp.ClickOnCorporate();
		emp.AddCorporate();
		
	
		emp.AddCorporate1();
		
		String expectedAddCorporatePopupTitle=elib.readDataFromexcel("title", 10, 1);
		//String expectedAddCorporatePopupTitle="Add Corporate";
		WebDriverWait Wait=new WebDriverWait(driver,10);
		String actualAddCorporatePopupTitle1 =Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Add Corporate']"))).getText();
		
		if(actualAddCorporatePopupTitle1.equals(expectedAddCorporatePopupTitle)) {
			System.out.println("Add Corporate popup is displayed and varified upon title");
		}else {
			System.err.println("Add Corporate popup is not displayed and varified upon title");
		}
		
		emp.SendCorporateName();
		emp.clickOnSave();
		

	
		
		//validating the popup
		String expectedInsertPopuptext =elib.readDataFromexcel("title", 11, 1);
		//String expectedInsertPopuptext = "Insert Successfully!!!";//Insert Successfully!!!
		String actualInsertPopuptext = driver.switchTo().alert().getText();
		if (actualInsertPopuptext.equals(expectedInsertPopuptext)) {
			System.out.println("Popup is displayed and varified upon popup text");
		}else {
			System.err.println("Popup is not displayed and varified upon popup text");
		}
		driver.switchTo().alert().accept();
		boolean flag = false;
		List<WebElement> corporateNames = driver.findElements(By.cssSelector("tbody tr td:nth-child(2)"));
		for (WebElement corpName : corporateNames) {
			if(corpName.getText().equals("testing")) {
				flag=true;
				System.out.println("The Corporation is sucessfully created");
				break;
			}
		}
		if(!flag) {
			System.out.println("The Corporation is not created");
		}
		
		
		
		//creating Branches and validating the page
		emp.ClickOnBranches();
		emp.ClickOnAddBranches();
		emp.clickOnAddBranches1();
		String expectedAddBranchesPopupTitle=elib.readDataFromexcel("title", 7, 1);
		//String expectedAddBranchesPopupTitle="Add Branches";
		String actualAddBranchesPopupTitle= Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Add Branches']"))).getText();
		//String actualAddBranchesPopupTitle= driver.findElement(By.xpath("//h4[text()='Add Branches']")).getText();
		
		if(actualAddBranchesPopupTitle.equals(expectedAddBranchesPopupTitle)) {
			System.out.println("Add Braches popup is displayed and varified upon title");
		}else {
			System.err.println("Add Braches popup is not displayed and varified upon title");
		}
		
		emp.SendBranchesName();
		
		emp.ClickOnSave();
		
		//validating the popup
		String expectedBranchInsertPopuptext=elib.readDataFromexcel("title", 8, 1);
		//String expectedBranchInsertPopuptext = "Insert Successfully!!!";//Insert Successfully!!!
		String actualBranchInsertPopuptext = driver.switchTo().alert().getText();
		if (actualBranchInsertPopuptext.equals(expectedBranchInsertPopuptext)) {
			System.out.println("Popup is displayed and varified upon popup text");
		}else {
			System.err.println("Popup is not displayed and varified upon popup text");
		}
		driver.switchTo().alert().accept();
		flag = false;
		List<WebElement> branchesNames = driver.findElements(By.cssSelector("tbody tr td:nth-child(2)"));
		for (WebElement branch : branchesNames) {
			if(branch.getText().equals("btr")) {
				flag=true;
				System.out.println("The Branch is sucessfully created");
				break;
			}
		}
		if(!flag) {
			System.out.println("The Branch is not created");
		}
		
		
		
		
		emp.ClickOnEmployee();
		emp.ClickOnAddEmployee();
		
		
	String expectedEmployeeTabName=elib.readDataFromexcel("title", 12, 1);
		
		//String expectedEmployeeTabName = "Dashboard";
		String actualEmployeeTabName = driver.findElement(By.xpath("//h1[text()='Dashboard']")).getText();
		
		if (actualEmployeeTabName.equals(expectedEmployeeTabName)) {
			System.out.println("Employee page is displayed and varified on board name");
		}else {
			System.err.println("Employee page is not displayed and varified on board name");
		}
		
		
		emp.clickOnAddEmployee1();
		String expectedAddEmployeePopupTitle=elib.readDataFromexcel("title", 13, 1);
		//String expectedAddAdminPopupTitle="Add Employee";
		String actualAddAdminPopupTitle= Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Add Employee']"))).getText();
		//String actualAddBranchesPopupTitle= driver.findElement(By.xpath("//h4[text()='Add Branches']")).getText();
		
		if(actualAddAdminPopupTitle.equals(expectedAddEmployeePopupTitle)) {
			System.out.println("Add Employee popup is displayed and varified upon title");
		}else {
			System.err.println("Add Employee popup is not displayed and varified upon title");
		}
		
		
		HashMap<String, String> empDataMap = elib.readMultipleData("empdata");
	

		emp.EmployeeForm(empDataMap);
		
		
		//driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@	name=\"employee_image\"]")).sendKeys("C:\\Users\\dell\\Pictures\\Screenshot (948) - Copy.png");
		//driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name=\"employee_hdmf_pagibig\"]")).sendKeys("abcde");
		WebDriverWait Wait1=new WebDriverWait(driver, 20);
		WebElement file = driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='employee_file201']"));
		Wait1.until(ExpectedConditions.elementToBeClickable(file));
		file.sendKeys("C:\\Users\\dell\\Desktop\\emp.txt");

		WebElement img = driver.findElement(By.xpath("//h4[text()='Add Employee']/../..//input[@name='employee_image']"));
		Wait1.until(ExpectedConditions.elementToBeClickable(img));
		img.sendKeys("C:\\Users\\dell\\Desktop\\img.jpg");
		
		emp.clickOnSave();
		String expectedEmployeeInsertPopuptext=elib.readDataFromexcel("title",14,1);
		//String expectedEmployeeInsertPopuptext = "Insert Successfully!!!";//Insert Successfully!!!
		String actualEmployeeInsertPopuptext = driver.switchTo().alert().getText();
		if (actualEmployeeInsertPopuptext.equals(expectedEmployeeInsertPopuptext)) {
			System.out.println("Popup is displayed and varified upon popup text");
		}else {
			System.err.println("Popup is not displayed and varified upon popup text");
		}
		
		driver.switchTo().alert().accept();
		flag = false;
		List<WebElement> EmployeeNames = driver.findElements(By.cssSelector("tbody tr td:nth-child(3)"));
		for (WebElement empName : EmployeeNames) {
			if(empName.getText().equals("harry potter")) {
				flag=true;
				System.out.println("The Employee is sucessfully created");
				break;
			}
		}
		if(!flag) {
			System.out.println("The Employee is not created");
		}
		
		emp.clickOnWelcome();
		emp.clickOnLogout();
		
		/*
		//Logout of application
		String expectedLogoutPopuptext=elib.readDataFromexcel("title", 6, 1);
		//String expectedLogoutPopuptext = "Successfully Logout!";//Successfully Logout!
		String actualLogoutPopuptext = driver.switchTo().alert().getText();
		if (actualLogoutPopuptext.equals(expectedLogoutPopuptext)) {
			System.out.println("Popup is displayed and varified upon popup text");
		}else {
			System.err.println("Popup is not displayed and varified upon popup text");
		}
		driver.switchTo().alert().accept();
		
		String actualAftreLogoutTitle = driver.getTitle();
		if (actualAftreLogoutTitle.equals(expectedTitle)) {
			System.out.println("Login Page is Displayed and varified");
		}else {
			System.err.println("Login page is not displayed and varified");
		}
		
	}
	*/



	}
}
