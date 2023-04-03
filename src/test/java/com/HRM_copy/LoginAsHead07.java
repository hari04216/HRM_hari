package com.HRM_copy;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.pomRepository.LoginasHrHeadnRepo;

public class LoginAsHead07 extends BaseClass {

	@Test
	public void LoginASHrHead() throws Throwable {

		String expectedTitle = elib.readDataFromexcel("title", 0, 1);
		// String expectedTitle = "Admin Log in";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Login Page is Displayed and varified");
		} else {
			System.err.println("Login page is not displayed and varified");
		}

		String hrheadusername = flib.readproperityfile("hrheadusername");
		String hrheadpassword = flib.readproperityfile("hrheadpassword");
		LoginasHrHeadnRepo head = new LoginasHrHeadnRepo(driver);
		head.sendHRemail(hrheadusername);
		head.sendHRpassword(hrheadpassword);
		head.selectThePosition("HR Head");
		head.clickLogin();
		// validating the pop-up
		String expectedPopuptext = elib.readDataFromexcel("title", 1, 1);
		// String expectedPopuptext = "Login Successfully!!";//Insert Successfully!!!
		String actualPopuptext = driver.switchTo().alert().getText();
		if (actualPopuptext.equals(expectedPopuptext)) {
			System.out.println(" login Popup is displayed and varified upon popup text");
		} else {
			System.err.println(" login Popup is not displayed and varified upon popup text");
		}
		driver.switchTo().alert().accept();
		head.clickOnWelcome();
		head.ClickOnLogout();

	}

}
