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
public class Login {

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
	public void login() throws InterruptedException {
		driver.get("http://localhost:3000/login");
		driver.manage().window().setSize(new Dimension(1051, 798));
		driver.findElement(By.name("username")).sendKeys("pandi");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.name("user-login")).submit();
		Thread.sleep(5);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("login success", txt);
	}
	
	@Test
	public void login1() {
		driver.get("http://localhost:3000/login");
		driver.manage().window().setSize(new Dimension(1051, 798));
		driver.findElement(By.name("username")).sendKeys("");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.name("user-login")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("Please enter user id", txt);
	}
	
	@Test
	public void login2() {
		driver.get("http://localhost:3000/login");
		driver.manage().window().setSize(new Dimension(1051, 798));
		driver.findElement(By.name("username")).sendKeys("buvan");
		driver.findElement(By.name("password")).sendKeys("");
		driver.findElement(By.name("user-login")).submit();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String txt = alert.getText();
		System.out.println(txt);
		alert.accept();
		assertEquals("please enter password", txt);
	}

}
