package com.HRM_copy;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.pomRepository.LoginAsHrofficerRepo;

public class LoginAsHROfiicer08 extends BaseClass {

	@Test
	public void LoginAsHROfiicer() throws Throwable {

		String expectedTitle = elib.readDataFromexcel("title", 0, 1);
		// String expectedTitle = "Admin Log in";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Login Page is Displayed and varified");
		} else {
			System.err.println("Login page is not displayed and varified");
		}

		String hrofficerusername = flib.readproperityfile("hrofficerusername");
		String hrofficerpassword = flib.readproperityfile("hrofficerpassword");

		LoginAsHrofficerRepo officer = new LoginAsHrofficerRepo(driver);

		officer.sendHRemail(hrofficerusername);
		officer.sendHRpassword(hrofficerpassword);
		officer.selectThePosition("HR Officer");
		officer.clickLogin();
		// validating the pop-upfgewufhejhf
		String expectedPopuptext = elib.readDataFromexcel("title", 1, 1);
		// String expectedPopuptext = "Login Successfully!!";//Insert Successfully!!!
		String actualPopuptext = driver.switchTo().alert().getText();
		if (actualPopuptext.equals(expectedPopuptext)) {
			System.out.println(" login Popup is displayed and varified upon popup text");
		} else {
			System.err.println(" login Popup is not displayed and varified upon popup text");
		}
		officer.clickOnWelcome();
		officer.ClickOnLogout();

	}

}
