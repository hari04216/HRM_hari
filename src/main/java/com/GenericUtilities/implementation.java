package com.GenericUtilities;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class implementation implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = report.createTest(result.getMethod().getMethodName());
		Reporter.log(result.getMethod().getMethodName() + "execution started");
		test.log(Status.INFO, "started");

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, result.getMethod().getMethodName() + "test passed");
		Reporter.log(result.getMethod().getMethodName() + "test passed");

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		String ScreenShotPath = "./screenshot/" + result.getMethod().getMethodName() + " "
				+ LocalDateTime.now().toString().replace(':', '-');
		File dst = new File(ScreenShotPath);
		try {
			FileUtils.copyFile(src, dst);
		} catch (Exception e) {
			e.printStackTrace();
		}                                           
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(dst.getAbsolutePath(), "Test failed at this point");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, result.getThrowable());

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

		// create html file uing ExtentSparkReporeter
		ExtentSparkReporter reporter = new ExtentSparkReporter("./ExtentReport/Report_"+LocalDateTime.now().toString().replace(':', '-')+".html");
		reporter.config().setDocumentTitle("Test Report");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("HRM");

		report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("os version", "windows 10");
		report.setSystemInfo("Build Version", "vs1.5");
		report.setSystemInfo("Browser", "chrome");
		report.setSystemInfo("url", "localhost:8806");
		report.setSystemInfo("Test.e Name", "hari");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

		report.flush();

	}

}
