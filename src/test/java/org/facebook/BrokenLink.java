package org.facebook;

import java.beans.Statement;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {
	
	public static void main (String[]args) throws IOException, ClassNotFoundException, SQLException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		List<WebElement>links = driver.findElements(By.tagName("link"));
		Iterator<WebElement>iterator = links.iterator();
		    while(iterator.hasNext()) {
		    	WebElement link = iterator.next();
		    	String href = link.getAttribute("href");
		    	if(href== null ||href.isEmpty()) {
		    		System.out.println("link not available");
		    	}
		    	else if(!href.startsWith("https://www.facebook.com/")) {
		    		System.out.println("links  not related to facebook:"+href);
		    	}
		    	else {
		    		HttpURLConnection http = (HttpURLConnection)(new URL(href).openConnection());
		    		http.setRequestMethod("HEAD");
		    		http.connect();
		    		int responsecode = http.getResponseCode();
		    		if(responsecode ==200) {
		    			System.out.println("link is not broken:"+ href);
		    			
		    		}
		    		
		    	}
//			Class.forName ("com.microsoft.sqlserver");
//			String connectionString = "hostname://dbrefname;username = saraavana;password= salim;trustedconnection = true";
//			Connection conn = DriverManager.getConnection(connectionString);
//			Statement statement = conn.createStatement();
//			ResultSet result  = statement.executeQuery("select * from tablename");
//			String s = result.getString(0);
		}
		
		}
	
	
	
}
