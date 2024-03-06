package com.facebook.base.function;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
//	public static Base base = null;
//	private Base() {}
//	public static Base getInstance() {
//		if(base.equals(null)) {
//			base = new Base();
//		}
//		return new Base();
//		
//	}
	
	public static WebDriver driver;
	public static Actions action;
	public static JavascriptExecutor js;
	public static Select select;


	public static void browserLaunch() {
		WebDriverManager.edgedriver().setup();
		EdgeOptions option = new EdgeOptions();
		option.addArguments("start-maximized");
//		option.addArguments("--headless");
		option.addArguments("disable-notifications");
		option.addArguments("disable-popups");
		driver = new EdgeDriver(option); 
		action = new Actions(driver);
		js = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
			
	}
	public static void gotoUrl(String url) {
		driver.get(url); 
	}
	public void browserClose() {
		driver.quit();
		}
	public void pageRefresh() {
		driver.navigate().refresh();
	}
	public void pageForward() {
		driver.navigate().forward();
	}
	public void pageBackward() {
		driver.navigate().back();
	}
	public String tittleName() {
		String tittle = driver.getTitle();
		return tittle;
	}
	public void insertText(WebElement element,String input) {
		element.sendKeys(input);
	}
	public void normalbutton(WebElement element) {
		element.click();
	}
	public Boolean displayed(WebElement element) {
		Boolean displayed = element.isDisplayed();
		return displayed;
	}
	public Boolean visibilityofElement(WebElement element) {
		Boolean selected = element.isSelected();
	return selected;
	}
	public Boolean enabled(WebElement element) {
		Boolean enableed = element.isEnabled();
		return enableed;
	}
	public String retrieveText(WebElement element) {
		String text = element.getText();
		return text;
	}
	public String attribute(WebElement element,String attribute) {
		String string  = element.getAttribute(attribute);
		return string;
	}
	public void gotoElement(WebElement element) {
	   action.moveToElement(element).build().perform();
	}
	public void rightClick(WebElement element) {
		   action.contextClick(element).build().perform();
		}
	public void toClick(WebElement element) {
		   action.doubleClick(element).build().perform();
		}
	public void moveoneElementtoAnother(WebElement src,WebElement target) {
		   action.dragAndDrop(src,target).perform();
		}
	public void inserText(String value,WebElement element) {
	      action.sendKeys(element, value).build().perform();
	}
	public void actionbutton(WebElement element,int i) {
		  action.click(element).build().perform();
	}
	public void screenshot(String filename ) {
		  File file = new File("C:\\Users\\ADMIN\\eclipse-workspace\\FaceBookAcountProject\\target"+filename+".png");
		  TakesScreenshot tk = (TakesScreenshot)driver;
		  File sorce = tk.getScreenshotAs(OutputType.FILE);
		  try {
			FileUtils.copyFile(sorce,file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void scrolldown(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public void scrollUp(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	public void inserText(WebElement element,String value,String javascript) {
	js.executeScript("arguments[0].setAttribute('value','"+value+"')", element);
	}
	public void scrollUp(WebElement element,String javascript) {
		js.executeScript("arguments[0].click", element);
	}
	public void selectVisibleText(WebElement dropdown,String visibleText) {
		Select s = new Select(dropdown);
		s.selectByVisibleText(visibleText);
	}
	public void selectValue(WebElement dropdown,String value) {
		Select s = new Select(dropdown);
		s.selectByVisibleText(value);
	}
	public List<WebElement> selectOptions(WebElement dropdown) {
		Select s = new Select(dropdown);
		List<WebElement>option = s.getOptions();
		return option;
	}
	public void selectIndex(WebElement dropdown,int index) {
		Select s = new Select(dropdown);
		s.selectByIndex(index);
	}
public void defaultFrame() {
		driver.switchTo().defaultContent();
	}
public void previousFrame() {
	driver.switchTo().parentFrame();
}
public void nextFrame(WebElement element) {
	driver.switchTo().frame(element);
}
 public void popupInsertText(String value) {
	 Alert alert = driver.switchTo().alert();
	 alert.sendKeys(value);
 }
public Alert popup(Alert alert) {
	Alert alerts = driver.switchTo().alert();
	return alert;
}
public void alertAccept(Alert alert) {
	alert.accept();
}
public void nmlSendKey(WebElement element,String input) {
	element.sendKeys(input);
}

   }
