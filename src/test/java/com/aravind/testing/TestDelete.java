package com.aravind.testing;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.*;
 
public class TestDelete {
 
	private WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  @BeforeEach
	  public void setUp() {
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }
	  @AfterEach
	  public void tearDown() {
	    driver.quit();
	  }
	  @Test
	  public void deleteTest() {
	    driver.get("http://localhost:3000/viewcustomer");
	    driver.manage().window().setSize(new Dimension(1536, 816));
	   // driver.findElement(By.linkText("View Customer")).click();
	    driver.findElement(By.cssSelector("tr:nth-child(5) .ms-1")).click();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("Do you want to delete", txt);
	  }
}
