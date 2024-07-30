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
import java.util.*;
import java.net.MalformedURLException;

public class TestAddOrder {
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
	public void addOrder() throws InterruptedException {
		driver.get("http://localhost:3000/createorder");
		driver.manage().window().setSize(new Dimension(1051, 798));
		driver.findElement(By.name("itemName")).sendKeys("Pant");
		driver.findElement(By.name("price")).sendKeys("900");
		driver.findElement(By.name("order-submit")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("Data added Successfully", txt);
	}
	
	@Test
	public void addOrder1() {
		driver.get("http://localhost:3000/createorder");
		driver.manage().window().setSize(new Dimension(1051, 798));
		driver.findElement(By.name("itemName")).sendKeys("");
		driver.findElement(By.name("price")).sendKeys("700");
		driver.findElement(By.name("order-submit")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("Please enter item Name !!! ", txt);
	}
	
	@Test
	public void addOrder2() {
		driver.get("http://localhost:3000/createorder");
		driver.manage().window().setSize(new Dimension(1051, 798));
		driver.findElement(By.name("itemName")).sendKeys("Shirt");
		driver.findElement(By.name("price")).sendKeys("");
		driver.findElement(By.name("order-submit")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("Please enter the price", txt);
	}

}
