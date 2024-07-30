package com.aravind.testing;


import org.junit.Test;
import org.junit.jupiter.api.Disabled;
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

public class TestUpdateCustomer {
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
	public void updateCustomer() throws InterruptedException {
		driver.get("http://localhost:3000/updatecustomer/15");
		driver.manage().window().setSize(new Dimension(1051, 798));
		driver.findElement(By.name("customerName")).clear();
		driver.findElement(By.name("customerName")).sendKeys("Raj");
		driver.findElement(By.name("mobileNumber")).clear();
		driver.findElement(By.name("mobileNumber")).sendKeys("8203423239");
		driver.findElement(By.name("emailId")).clear();
		driver.findElement(By.name("emailId")).sendKeys("Rkumar@gmail.com");
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys("dgl");
		driver.findElement(By.name("customer-update")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("Customers Updated Successfully", txt);
	}
	
	@Test
	public void updateCustomer1() {
		driver.get("http://localhost:3000/updatecustomer/1");
		driver.manage().window().setSize(new Dimension(1051, 798));
		driver.findElement(By.name("customerName")).click();
		driver.findElement(By.name("customerName")).clear();
		driver.findElement(By.name("customerName")).sendKeys("Aravind2#");
		driver.findElement(By.name("mobileNumber")).clear();
		driver.findElement(By.name("mobileNumber")).sendKeys("8903423239");
		driver.findElement(By.name("emailId")).clear();
		driver.findElement(By.name("emailId")).sendKeys("kumar@gmail.com");
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys("dgl");
		driver.findElement(By.name("customer-update")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("Name should contain only alphabet characters", txt);
	}
	
	@Test
	public void updateCustomer2() {
		driver.get("http://localhost:3000/updatecustomer/1");
		driver.manage().window().setSize(new Dimension(1051, 798));
		driver.findElement(By.name("customerName")).clear();
		driver.findElement(By.name("customerName")).sendKeys("buvan");
		driver.findElement(By.name("mobileNumber")).clear();
		driver.findElement(By.name("mobileNumber")).sendKeys("89034232");
		driver.findElement(By.name("emailId")).clear();
		driver.findElement(By.name("emailId")).sendKeys("kumar@gmail.com");
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys("dgl");
		driver.findElement(By.name("customer-update")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("Please enter the Valid Mobile number", txt);
	}
	
	@Test
	public void updateCustomer3() {
		driver.get("http://localhost:3000/updatecustomer/1");
		driver.manage().window().setSize(new Dimension(1051, 798));
		driver.findElement(By.name("customerName")).clear();
		driver.findElement(By.name("customerName")).sendKeys("buvan");
		String s = Keys.chord(Keys.CONTROL, "a");
		driver.findElement(By.name("mobileNumber")).sendKeys(s);
		driver.findElement(By.name("mobileNumber")).sendKeys(Keys.DELETE);
		driver.findElement(By.name("emailId")).clear();
		driver.findElement(By.name("emailId")).sendKeys("kumar@gmail.com");
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys("dgl");
		driver.findElement(By.name("customer-update")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("Please enter the Mobile number", txt);
	}
	
	@Test
	public void updateCustomer4() {
		driver.get("http://localhost:3000/updatecustomer/1");
		driver.manage().window().setSize(new Dimension(1051, 798));
		driver.findElement(By.name("customerName")).click();
		driver.findElement(By.name("customerName")).clear();
		driver.findElement(By.name("customerName")).sendKeys("Aravind");
		driver.findElement(By.name("mobileNumber")).clear();
		driver.findElement(By.name("mobileNumber")).sendKeys("8903423239");
		String s = Keys.chord(Keys.CONTROL, "a");
		driver.findElement(By.name("emailId")).sendKeys(s);
		driver.findElement(By.name("emailId")).sendKeys(Keys.DELETE);
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys("dgl");
		driver.findElement(By.name("customer-update")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("Please enter the Valid email !!!", txt);
	}
	
	
	@Test
	public void  updateCustomer5() {
		driver.get("http://localhost:3000/updatecustomer/1");
		driver.manage().window().setSize(new Dimension(1051, 798));
		driver.findElement(By.name("customerName")).clear();
		driver.findElement(By.name("customerName")).sendKeys("buvan");
		driver.findElement(By.name("mobileNumber")).clear();
		driver.findElement(By.name("mobileNumber")).sendKeys("9084234567");
		driver.findElement(By.name("emailId")).clear();
		driver.findElement(By.name("emailId")).sendKeys("aravind@gmail.com");
		String s = Keys.chord(Keys.CONTROL, "a");
		driver.findElement(By.name("address")).sendKeys(s);
		driver.findElement(By.name("address")).sendKeys(Keys.DELETE);
		driver.findElement(By.name("customer-update")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("Please Enter the Address!!!", txt);
	}
	
	@Test
	public void updateCustomer6() {
		driver.get("http://localhost:3000/updatecustomer/1");
		driver.manage().window().setSize(new Dimension(1051, 798));
		String s = Keys.chord(Keys.CONTROL, "a");
		driver.findElement(By.name("customerName")).sendKeys(s);
		driver.findElement(By.name("customerName")).sendKeys(Keys.DELETE);
		driver.findElement(By.name("mobileNumber")).clear();
		driver.findElement(By.name("mobileNumber")).sendKeys("8934567892");
		driver.findElement(By.name("emailId")).clear();
		driver.findElement(By.name("emailId")).sendKeys("kumar@gmail.com");
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys("dgl");
		driver.findElement(By.name("customer-update")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("Please enter Customer's Name !!! ", txt);
	}
}
