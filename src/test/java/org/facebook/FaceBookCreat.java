package org.facebook;

import java.io.File; 
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.facebook.base.function.Base;
import com.facebook.loacators.FaceBookLocator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookCreat{
	
	public static Base base = new Base();
//	public static Base base = Base.getInstance();
	public static FaceBookLocator locator = new FaceBookLocator();
	
@Given("Launch the FaceBook {string}")
public void launch_the_face_book(String url) {	
	// Base.gotoUrl(url);
	base.gotoUrl(url);
 }

@When("User click on create new account")
public void user_click_on_create_new_account() {
//	WebElement creat = base.driver.findElement(By.xpath("//a[text()='Create new account']"));
  base.normalbutton(locator.getCreat());
   }

@When("User enter the first name {string}")
public void user_enter_the_first_name(String firstname) {
//    WebElement first = base.driver.findElement(By.xpath("//input[@placeholder='First name']"));
  base.nmlSendKey(locator.getFirstname(), firstname);
   System.out.println(firstname);

}

@When("User enter the Surname {string}")
public void user_enter_the_surname(String surename) {
//	WebElement lastname = base.driver.findElement(By.name("lastname"));
	 base.nmlSendKey(locator.getSurename(), surename);
	 System.out.println("LASTNAME :"+surename);
   }

@When("User enter the mobile or email address {string}")
public void user_enter_the_mobile_or_email_address(String mobile) {
//	WebElement email = base.driver.findElement(By.name("reg_email__"));
	base.nmlSendKey(locator.getMobile(), mobile);
	 System.out.println("MOBILE :"+mobile);
	 }

@When("User enter the password {string}")
public void user_enter_the_password(String password) {
//	WebElement pass = base.driver.findElement(By.xpath("//input[@autocomplete='new-password']"));
	base.nmlSendKey(locator.getPassword(), password);
	 System.out.println("PASSWORD :"+password);
  }

@When("User select the date {string}")
public void user_select_the_date(String date) {
 //  WebElement day = base.driver.findElement(By.id("day"));
   base.selectVisibleText(locator.getDate(), date);
	 System.out.println("DATE :"+date);
}


@When("User select the month {string}")
public void user_select_the_month(String month) {
//	   WebElement months = base.driver.findElement(By.id("month"));
	   base.selectVisibleText(locator.getMonth(), month);
	   System.out.println("MONTH :"+month);
   }

@When("User select the year {string}")
public void user_select_the_year(String year) {
//	   WebElement years = base.driver.findElement(By.id("year"));
	   base.selectVisibleText(locator.getYear(), year);
	   System.out.println("YEAR :"+year);	   
}

@When("User click on gender {string}")
public void user_click_on_gender(String gender) {
  if(gender.equals("Male")) {
//    WebElement male = base.driver.findElement(By.xpath("//label[text()='Male']"));
   base.normalbutton(locator.getGender()); 
   }
 else {
	 gender.equals("Female");
	 base.driver.findElement(By.xpath("//label[text()='Female']")).click();
 }
 System.out.println("GENDER :"+gender);
}

@When("User click the signup button")
public void user_click_the_signup_button() throws Throwable {
//	WebElement button = base.driver.findElement(By.xpath("//button[text()='Sign Up']"));		
    base.normalbutton(locator.getButton());
	
	Thread.sleep(2000);
}

@Then("Validate the new account {string}")
public void validate_the_new_account(String screen) {
   base.screenshot(screen);
}






@When("User enter the mail id {string}")
public void user_enter_the_mail_id(String id) {
WebElement mail = base.driver.findElement(By.id("email"));
base.nmlSendKey(mail, id);
}

@When("User enter the pass {string}")
public void user_enter_the_pass(String pass) {
	WebElement password = base.driver.findElement(By.xpath("//input[@data-testid='royal_pass']"));
   base.nmlSendKey(password, pass);
}
@When("User enter the Login button")
public void user_enter_the_login_button() {
WebElement butt = base.driver.findElement(By.xpath("//button[text()='Log in']"));
   base.normalbutton(butt);
}
@Then("Validate the account {string}")
public void validate_the_account(String screenshot1) {
  base.screenshot(screenshot1);
}

}



