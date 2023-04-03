package com.GenericUtilities;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void elementtoBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * 
	 */
	public void select(WebElement element, String value){
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);

	}

	public void select(String visibleText, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);

	}
	
	public void mousehover(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public  void dragAnddrop(WebDriver driver, WebElement src, WebElement dst)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, dst);
	}
	
	
	public void doubleClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void entetKeyPress() throws Throwable
	{
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	
	
	public void enterRelease() throws Throwable
	{
		Robot rb=new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
		
	}
	
	public void cancalAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void switchTowindow(WebDriver driver, CharSequence expectedTitle)
	{
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		while(it.hasNext())
		{
			String winid=it.next();
			String currentTitle=driver.switchTo().window(winid).getTitle();
			if(currentTitle.contains(expectedTitle))
			{
				break;
			}
			
		}
		
	}
	
	public static  String getScreenshot(TakesScreenshot driver, String screenshotName) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=".\\screenshot\\"+screenshotName+".png";
		File dst=new File(path);
		FileUtils.copyFile(src, dst);
		return path;
		
	}
	
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		
		jse.executeScript("window.scrollBy(0,800)", "");
	}
	
	
	//scroll  into view
	public void scrollAction(JavascriptExecutor driver, WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		
		int Y=element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+Y+")",element);
		//jse.executeScript("argument[0].scrollIntoView()",element);	
	}
		
}

