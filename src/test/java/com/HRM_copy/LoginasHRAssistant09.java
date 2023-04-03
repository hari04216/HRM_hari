package com.HRM_copy;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.pomRepository.LoginAshrAssistantRepo;

public class LoginasHRAssistant09 extends BaseClass {

	@Test
	public void LoginasHRAssistant() throws Throwable {

		String expectedTitle = elib.readDataFromexcel("title", 0, 1);
		// String expectedTitle = "Admin Log in";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Login Page is Displayed and varified");
		} else {
			System.err.println("Login page is not displayed and varified");
		}

		String hrAssistusername = flib.readproperityfile("hrAssistusername");
		String hrAssistpassword = flib.readproperityfile("hrAssistpassword");
		LoginAshrAssistantRepo assist = new LoginAshrAssistantRepo(driver);

		assist.sendHRemail(hrAssistpassword);
		assist.sendHRpassword(hrAssistpassword);
		assist.selectThePosition("HR Assistant");
		assist.clickLogin();
		// validating the pop-up
		String expectedPopuptext = elib.readDataFromexcel("title", 1, 1);
		// String expectedPopuptext = "Login Successfully!!";//Insert Successfully!!!
		String actualPopuptext = driver.switchTo().alert().getText();
		if (actualPopuptext.equals(expectedPopuptext)) {
			System.out.println(" login Popup is displayed and varified upon popup text");
		} else {
			System.err.println(" login Popup is not displayed and varified upon popup text");
		}
		assist.clickOnWelcome();
		assist.ClickOnLogout();

	}

}
