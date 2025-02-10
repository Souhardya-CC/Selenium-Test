package com.project.practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class Candy {

    public static void main(String[] args) throws InterruptedException, AWTException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://staging.candycloudcbd.com/shop-all/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Closing the pop-up
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div[1]")));
        driver.findElement(By.xpath("/html/body/div[4]/div/div[1]")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        Actions action = new Actions(driver);

        List<WebElement> sections = driver.findElements(By.xpath("//*[@id=\"post-13411\"]/div/div/div/div/div"));
        List<WebElement> products, categories, options, sizes, packs;
        String s, p, c, s1, p1;
        //going to a product section
        for(int i = 3; i <= sections.size(); i+=2){
            s = Integer.toString(i);
            products = driver.findElements(By.xpath("//*[@id=\"post-13411\"]/div/div/div/div/div["+s+"]/div/div/div/div/ul/li"));
            //clicking on a product
            for(int j = 1; j <= products.size(); j++){
                p = Integer.toString(j);
                js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"post-13411\"]/div/div/div/div/div["+s+"]/div/div/div/div/ul/li["+p+"]")));
                driver.findElement(By.xpath("//*[@id=\"post-13411\"]/div/div/div/div/div["+s+"]/div/div/div/div/ul/li["+p+"]")).click();
                Thread.sleep(2000);
                categories = driver.findElements(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/form/div[1]/div[2]/div/div[1]/ul/li"));
                System.out.println("category list created: "+categories.size());
                //clicking on a category
                for(int k = 1; k <= categories.size(); k++){
                    System.out.println("inside category loop");
                    c = Integer.toString(k);
                    js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/form/div[1]/div[2]/span/span/bdi")));
                    driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/form/div[1]/div[2]/div/div[1]/ul/li["+c+"]")).click();
                    System.out.println("category selected");
                    options = driver.findElements(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/form/table/tbody/tr"));
                    System.out.println("Options: "+options.size());
                    //checking option count
                    if(options.size()==4){
                        sizes = driver.findElements(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/form/table/tbody/tr[1]/td/div/div"));
                        //selecting a size
                        if(sizes.size()>1){
                            for(int l = 1; l <= sizes.size(); l++){
                                System.out.println("inside size loop");
                                s1 = Integer.toString(l);
                                js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/form/div[1]/div[2]/div/div[1]/ul/li[1]")));
                                driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/form/table/tbody/tr[1]/td/div/div["+s1+"]")).click();
                                System.out.println("size selected");
                                packs = driver.findElements(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/form/table/tbody/tr[2]/td/div/div"));
                                //selecting a pack
                                if(packs.size()>1){
                                    for(int m = 1; m <= packs.size(); m++){
                                        System.out.println("inside pack loop");
                                        p1 = Integer.toString(m);
                                        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/form/table/tbody/tr[1]/td/div/div["+s1+"]")));
                                        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/form/table/tbody/tr[2]/td/div/div["+p1+"]")).click();
                                        System.out.println("pack selected");
                                        //adding to cart
                                        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/form/div[2]/div/button")).click();
                                        Thread.sleep(10000);
                                        action.moveToLocation(300, 300).click().perform();
                                    }
                                }
                                else{
                                    //adding to cart
                                    driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/form/div[2]/div/button")).click();
                                    Thread.sleep(10000);
                                    action.moveToLocation(300, 300).click().perform();
                                }
                            }
                        }
                        else{
                            packs = driver.findElements(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/form/table/tbody/tr[2]/td/div/div"));
                            //selecting a pack
                            if(packs.size()>1){
                                for(int m = 1; m <= packs.size(); m++){
                                    System.out.println("inside pack loop");
                                    p1 = Integer.toString(m);
                                    js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/form/table/tbody/tr[1]/td/div/div")));
                                    driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/form/table/tbody/tr[2]/td/div/div["+p1+"]")).click();
                                    System.out.println("pack selected");
                                    //adding to cart
                                    driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/form/div[2]/div/button")).click();
                                    Thread.sleep(10000);
                                    action.moveToLocation(300, 300).click().perform();
                                }
                            }
                            else{
                                //adding to cart
                                driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/form/div[2]/div/button")).click();
                                Thread.sleep(10000);
                                action.moveToLocation(300, 300).click().perform();
                            }
                        }
                    }
                    else{
                        packs = driver.findElements(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section[2]/div/div[2]/div/div[5]/div/div/form/table/tbody/tr[1]/td/div/div"));
                        //selecting a pack
                        if(packs.size()>1){
                            for(int m = 1; m <= packs.size(); m++){
                                System.out.println("inside pack loop");
                                p1 = Integer.toString(m);
                                js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/form/div[1]/div[2]/div/div[1]/ul/li[1]")));
                                driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section[2]/div/div[2]/div/div[5]/div/div/form/table/tbody/tr[1]/td/div/div["+p1+"]")).click();
                                System.out.println("pack selected");
                                //adding to cart
                                driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/form/div[2]/div/button")).click();
                                Thread.sleep(10000);
                                action.moveToLocation(300, 300).click().perform();
                            }
                        }
                        else{
                            //adding to cart
                            driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/section/div/div[2]/div/div[5]/div/div/form/div[2]/div/button")).click();
                            Thread.sleep(10000);
                            action.moveToLocation(300, 300).click().perform();
                        }
                    }
                }
                driver.navigate().back();
            }
        }

        //driver.close();
    }
}
