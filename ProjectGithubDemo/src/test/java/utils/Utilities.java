package utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Utilities {
	public static AppiumDriver<MobileElement> driver;
	WebDriverWait wt;

	public Utilities(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public static void goBack() {
		driver.navigate().back();
	}

	public static void WaitAndClick(WebDriver driver, By locator) {
		WebDriverWait wt = new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();
	}
	
	public static void intWaitAndClick(WebDriver driver, By locator) {
		WebDriverWait wt = new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();
	}
	
//	public static void ImpWaitAndClick(WebDriver driver, By locator) {
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.findElement(locator).click();
//	}

	public static void WaitVisibilityAndClick(WebDriver driver, By locator) {
		WebDriverWait wt = new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public static void WaitAndSendkey(WebDriver driver, By locator, String text) {

		WebDriverWait wt = new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).sendKeys(text);
	}
	
//	public static void PresenceWaitAndClick(WebDriver driver, By locator) {
//
//		WebDriverWait wt = new WebDriverWait(driver, 30);
//		wt.until(ExpectedConditions.presenceOfElementLocated(locator));
//		driver.findElement(locator).click();
//	}
	
//	public static void ImpWaitAndSendkey(WebDriver driver, By locator, String text) {
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.findElement(locator).sendKeys(text);
//	}

	public static boolean isElementDisplayed(WebDriver driver, By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static void scrollUp(WebDriver driver, By locator, int x1, int y1, int x2, int y2) {
		while (!(Utilities.isElementDisplayed(driver, locator))) {
			TouchAction touch = new TouchAction((PerformsTouchActions) driver);
			touch.press(PointOption.point(x1, y1)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
					.moveTo(PointOption.point(x2, y2)).release().perform();
		}

	}

	public static void buttonVisible(WebDriver driver, By locator1, By locator2, By locator3) throws InterruptedException {

		while (!(Utilities.isElementDisplayed(driver, locator1))) {
			Utilities.WaitAndClick(driver, locator2);
			Utilities.WaitAndClick(driver, locator3);
			Thread.sleep(3000);
		}
		Utilities.WaitAndClick(driver, locator1);
	}
	
	public static void buttonVisible(WebDriver driver, By locator1, By locator2) throws InterruptedException {

		while (!(Utilities.isElementDisplayed(driver, locator1))) {
			Utilities.WaitAndClick(driver, locator2);
			
			Thread.sleep(2000);
		}
		Utilities.WaitAndClick(driver, locator1);
	}

}
