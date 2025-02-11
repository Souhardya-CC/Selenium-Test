package com.project.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	
	public static void main(String[] args) throws InterruptedException, AWTException {
		
		//System.setProperty("webdriver.chrome.driver", "E:\\SeleniumTraining\\Drivers\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.name("password")).sendKeys("learning");
		driver.findElement(By.xpath("//label[2]//span[2]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
		//driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		//Thread.sleep(6000);
		Point point = driver.findElement(By.id("okayBtn")).getLocation();
		/*Coordinates cord = (Coordinates) driver.findElement(By.id("okayBtn"));
		Point point = cord.inViewPort();*/
		
		System.out.println(point.x);
		System.out.println(point.y);
		
		Robot robot = new Robot();

		robot.mouseMove(point.getX(), point.getY());
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(1000);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

	}

}
