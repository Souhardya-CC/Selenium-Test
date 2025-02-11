package com.project.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class TestJenkins {

    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void initial() throws InterruptedException, AWTException {

        driver.manage().window().maximize();
        driver.get("https://www.wikipedia.org/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void search() throws InterruptedException {

        driver.findElement(By.id("searchInput")).sendKeys("selenium"+Keys.RETURN);
        Thread.sleep(2000);

    }

    @AfterMethod
    public void exit() {

        driver.close();
        driver.quit();

    }
}
