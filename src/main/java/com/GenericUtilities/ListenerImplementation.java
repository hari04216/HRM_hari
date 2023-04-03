package com.GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {

		// execution starts from here
		String methodname = result.getMethod().getMethodName();
		test = report.createTest(methodname);
		Reporter.log(methodname + " test script execution started");

	}

	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		// extent report priniting
		test.log(Status.PASS, methodname + "passed");

		// testng report printing
		Reporter.log(methodname + "test script execution successful");
	}

	public void onTestFailure(ITestResult result) {
		// String methodname = result.getMethod().getMethodName();
		// String failedscript = methodname +
		// LocalDateTime.now().toString().replace(':', '-');

		// TakesScreenshot ts=driver;

//		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
//		File src = edriver.getScreenshotAs(OutputType.FILE);
//		// File dst = new File("./Screenshot/" + failedscript + ".png");
//		File dst = new File("./screenshot/" + LocalDateTime.now().toString().replace(':', '-') + ".png");
//		try {
//			FileUtils.copyFile(src, dst);
//		} catch (IOException e) {
//			e.printStackTrace();
//
//		}
	}

	public void onTestSkipped(ITestResult result) {

		String method = result.getMethod().getMethodName();
		test.log(Status.SKIP, method + "skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log("Testscript execution skipped");

	}

	public void onStart(ITestContext context) {
		// create html report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("Hrm");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("Hrm_Admin");

		ExtentReports report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("BaseBrowser", "chrome");

		report.setSystemInfo("os", "windows");
		report.setSystemInfo("Base_Url", "https://localhost:8888");
		report.setSystemInfo("reporterName", "hari");

	}

	public void onFinish(ITestContext context) {

		// report.flush();
	}

}
