package com.aravind.testing;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import org.openqa.selenium.Dimension;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.util.*;
import java.net.MalformedURLException;

public class TestUpdateOrder {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() throws MalformedURLException {
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void updateOrder() throws InterruptedException {
		driver.get("http://localhost:3000/updateorder/13");
		driver.manage().window().setSize(new Dimension(1051, 798));
		driver.findElement(By.name("itemName")).clear();
		driver.findElement(By.name("itemName")).sendKeys("SweatPants");
		driver.findElement(By.name("price")).clear();
		driver.findElement(By.name("price")).sendKeys("1000");
		driver.findElement(By.name("order-button")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("Order Updated Successfully", txt);
	}
	
	@Test
	public void updateOrder1() {
		driver.get("http://localhost:3000/updateorder/1");
		driver.manage().window().setSize(new Dimension(1051, 798));
		String s = Keys.chord(Keys.CONTROL, "a");
		driver.findElement(By.name("itemName")).sendKeys(s);
		driver.findElement(By.name("itemName")).sendKeys(Keys.DELETE);
		driver.findElement(By.name("price")).clear();
		driver.findElement(By.name("price")).sendKeys("700");
		driver.findElement(By.name("order-button")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("Please enter item Name !!! ", txt);
	}
	
	@Test
	public void updateOrder2() {
		driver.get("http://localhost:3000/updateorder/1");
		driver.manage().window().setSize(new Dimension(1051, 798));
		driver.findElement(By.name("itemName")).sendKeys("Shirt");
		String s = Keys.chord(Keys.CONTROL, "a");
		driver.findElement(By.name("price")).sendKeys(s);
		driver.findElement(By.name("price")).sendKeys(Keys.DELETE);
		driver.findElement(By.name("order-button")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("Please enter the price", txt);
	}

}
