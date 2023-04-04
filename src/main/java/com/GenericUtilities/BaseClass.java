package com.GenericUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public ExcelUtility elib = new ExcelUtility();
//	public DatabaseUtility dlib = new DatabaseUtility();
	public FileUtility flib = new FileUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite(alwaysRun = true)
	public void configBC() throws Throwable {
		// dlib.connecToDb();
		System.out.println("connect to DB");
	}

	// @Parameters({"browser"})
	@BeforeClass(alwaysRun = true)
	public void configBC1() throws Throwable {
		String browser = flib.readproperityfile("browser");
		String url = flib.readproperityfile("url");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("invalid browser");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sdriver = driver;
		wlib.maximizeWindow(driver);
		driver.get(url);
		wlib.waitForPageLoad(driver);
	}

	@BeforeMethod(alwaysRun = true)
	public void configMB() throws Throwable {
		// String username = flib.readproperityfile("username");
		// String password = flib.readproperityfile("password");

//		HRmLogin HLogin = new HRmLogin(driver);
//		HLogin.clickLogin();

	}

	@AfterMethod(alwaysRun = true)
	public void configAM() {

//		HrmLogout HLout=new HrmLogout(driver); 
//		HLout.clickonWelcome();
//		HLout.clickOnLogout();
		
		
		
		
		
		
		System.out.println("fdhgfmhghgf");

	}

	@AfterClass(alwaysRun = true)
	public void configAc() {

		//driver.quit();
	}
}
