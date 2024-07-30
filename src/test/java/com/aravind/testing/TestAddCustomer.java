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

public class TestAddCustomer {
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
	public void addCustomer() throws InterruptedException {
		driver.get("http://localhost:3000/createcustomer");
		driver.manage().window().setSize(new Dimension(1051, 798));
		driver.findElement(By.name("customerName")).sendKeys("Abi");
		driver.findElement(By.name("mobileNumber")).sendKeys("9903423239");
		driver.findElement(By.name("emailId")).sendKeys("abi@gmail.com");
		driver.findElement(By.name("address")).sendKeys("Dindigul");
		driver.findElement(By.name("orderId")).sendKeys("13");
		driver.findElement(By.name("add-submit")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("Data added Successfully", txt);
	}
	
	@Test
	public void addCustomer1() {
		driver.get("http://localhost:3000/createcustomer");
		driver.manage().window().setSize(new Dimension(1051, 798));
		driver.findElement(By.name("customerName")).sendKeys("");
		driver.findElement(By.name("mobileNumber")).sendKeys("8903423230");
		driver.findElement(By.name("emailId")).sendKeys("kumar@gmail.com");
		driver.findElement(By.name("address")).sendKeys("dgl");
		driver.findElement(By.name("orderId")).sendKeys("12");
		driver.findElement(By.name("add-submit")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("Please enter Customer's Name !!! ", txt);
	}
	
	@Test
	public void addCustomer2() {
		driver.get("http://localhost:3000/createcustomer");
		driver.manage().window().setSize(new Dimension(1051, 798));
		driver.findElement(By.name("customerName")).sendKeys("buvan");
		driver.findElement(By.name("mobileNumber")).sendKeys("890342323");
		driver.findElement(By.name("emailId")).sendKeys("kumar@gmail.com");
		driver.findElement(By.name("address")).sendKeys("dgl");
		driver.findElement(By.name("orderId")).sendKeys("12");
		driver.findElement(By.name("add-submit")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("Please enter the Valid Mobile number", txt);
	}
	
	@Test
	public void addCustomer3() {
		driver.get("http://localhost:3000/createcustomer");
		driver.manage().window().setSize(new Dimension(1051, 798));
		driver.findElement(By.name("customerName")).sendKeys("buvan");
		driver.findElement(By.name("mobileNumber")).sendKeys("");
		driver.findElement(By.name("emailId")).sendKeys("kumar@gmail.com");
		driver.findElement(By.name("address")).sendKeys("dgl");
		driver.findElement(By.name("orderId")).sendKeys("12");
		driver.findElement(By.name("add-submit")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("Please enter the Mobile number", txt);
	}
	
	@Test
	public void addCustomer4() {
		driver.get("http://localhost:3000/createcustomer");
		driver.manage().window().setSize(new Dimension(1051, 798));
		driver.findElement(By.name("customerName")).sendKeys("buvan");
		driver.findElement(By.name("mobileNumber")).sendKeys("9084234567");
		driver.findElement(By.name("emailId")).sendKeys("");
		driver.findElement(By.name("address")).sendKeys("dgl");
		driver.findElement(By.name("orderId")).sendKeys("12");
		driver.findElement(By.name("add-submit")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("Please enter the Valid email", txt);
	}
	
	
	@Test
	public void addCustomer5() {
		driver.get("http://localhost:3000/createcustomer");
		driver.manage().window().setSize(new Dimension(1051, 798));
		driver.findElement(By.name("customerName")).sendKeys("buvan");
		driver.findElement(By.name("mobileNumber")).sendKeys("9084234567");
		driver.findElement(By.name("emailId")).sendKeys("aravind@gmail.com");
		driver.findElement(By.name("address")).sendKeys("");
		driver.findElement(By.name("orderId")).sendKeys("12");
		driver.findElement(By.name("add-submit")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("Please Enter the Address", txt);
	}
}