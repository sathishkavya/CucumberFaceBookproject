package com.facebook.loacators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.base.function.Base;


public class FaceBookLocator extends Base {
//	
//	public static FaceBookLocator locator =  null;
//	
	public FaceBookLocator() {
		PageFactory.initElements(Base.driver,this);
	}
//	public static FaceBookLocator getInstance() {
//		if(locator == null);
//		 locator = new FaceBookLocator();
//		return locator;
//	}

	@FindBy(xpath = "//a[text()='Create new account']")
	private WebElement creat;
	
	@FindBy(xpath = "//input[@placeholder='First name']")
	private WebElement firstname;
	
	@FindBy(name = "lastname")
	private WebElement surename;
	
	
	public WebElement getCreat() {
		return creat;
	}

	
	public WebElement getFirstname() {
		return firstname;
	}

	
	public WebElement getSurename() {
		return surename;
	}

	
	public WebElement getMobile() {
		return mobile;
	}

	
	public WebElement getPassword() {
		return password;
	}

	public WebElement getDate() {
		return date;
	}

	
	public WebElement getMonth() {
		return month;
	}

	
	public WebElement getYear() {
		return year;
	}

	
	public WebElement getGender() {
		return gender;
	}

	
	public WebElement getButton() {
		return button;
	}

	@FindBy(name = "reg_email__")
	private WebElement mobile;
	
	@FindBy(xpath = "//input[@autocomplete='new-password']")
	private WebElement password;
	
	@FindBy(id = "day")
	private WebElement date;
	
	@FindBy(id = "month")
	private WebElement month;
	
	@FindBy(id = "year")
	private WebElement year;
	
	@FindBy(xpath = "//label[text()='Male']")
	private WebElement gender;
	
	@FindBy(xpath = "//button[text()='Sign Up']")
	private WebElement button;
	
	
	
	
	
	
}
