package org.facebook;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.facebook.base.function.Base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before
	public void launching(Scenario scenario) {
		Base.browserLaunch();
		final byte[] source = ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.BYTES);
	//	scenario.embed(source, "image/png");
	}
	
	@After
	public void closing(Scenario scenario) {
		final byte[] source= ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.BYTES);
	//	scenario.embed(source, "image/png");
	//	Base.browserClose();
		
	}
}