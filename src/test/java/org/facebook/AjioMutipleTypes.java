package org.facebook;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AjioMutipleTypes {
	public static WebDriver driver;
	public static Actions action;

@Given("Launch the Ajio {string}")
public void launch_the_ajio(String string) {
	WebDriverManager.edgedriver().setup();
	EdgeOptions option = new EdgeOptions();
	option.addArguments("start-maximized");
	driver = new EdgeDriver(option); 
	action = new Actions(driver);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	driver.get("https://www.Ajio.com");		
}

@Given("Navigate to mens and click on clothing")
public void navigate_to_mens_and_click_on_clothing() {
	   WebElement men = driver.findElement(By.xpath("//span[text()='MEN']"));
	   action.moveToElement(men).build().perform();
	   WebElement cloathing = driver.findElement(By.xpath("//strong[text()='CLOTHING']"));
	   action.moveToElement(cloathing).click().build().perform();
}

@When("User clicks on sort dropdown and selects Lowest price in the dropdown")
public void user_clicks_on_sort_dropdown_and_selects_lowest_price_in_the_dropdown() throws Throwable {
	  WebElement dropdown =  driver.findElement(By.xpath("//select[@id='sortBy']"));
	  Select s = new Select(dropdown);
	  s.selectByVisibleText("Price (lowest first)");
	  Thread.sleep(2000);
}

@Then("Validate the price sorter based on lowest price")
public void validate_the_price_sorter_based_on_lowest_price() {
	 List<WebElement> price = driver.findElements(By.xpath("//span[@class='price  ']"));
	 for(int i =0;i<price.size();i++) {
		String lowprice =  price.get(i).getText();
		System.out.println("Low Price :" + lowprice);
}
   }

@When("User clicks on sort dropdown and selects Highest price in the dropdown")
public void user_clicks_on_sort_dropdown_and_selects_highest_price_in_the_dropdown() throws Throwable {
	  WebElement dropdown =  driver.findElement(By.xpath("//select[@id='sortBy']"));
	  Select s = new Select(dropdown);
	  s.selectByVisibleText("Price (highest first)");
	  Thread.sleep(3000);
}

@Then("Validate the price sorter based on Highest price")
public void validate_the_price_sorter_based_on_highest_price() {
	 List<WebElement> price = driver.findElements(By.xpath("//span[@class='price  ']"));
	 for(int i =0;i<price.size();i++) {
		String highest =  price.get(i).getText();
		System.out.println("High Price :" + highest);
}
}
@When("User clicks on sort dropdown and selects Ratings price in the dropdown")
public void user_clicks_on_sort_dropdown_and_selects_ratings_price_in_the_dropdown() throws Throwable {
	  WebElement dropdown =  driver.findElement(By.xpath("//select[@id='sortBy']"));
	  Select s = new Select(dropdown);
	  s.selectByVisibleText("Ratings");
	  Thread.sleep(2000);
}

@Then("Validate the price sorter based on Ratings price")
public void validate_the_price_sorter_based_on_ratings_price() {
	 List<WebElement> price = driver.findElements(By.xpath("//span[@class='price  ']"));
	 for(int i =0;i<price.size();i++) {
		String rating =  price.get(i).getText();
		System.out.println("Ratings :" + rating);
}

}
}
