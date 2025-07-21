package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();


        driver.findElement(By.id("input-email")).sendKeys("pintupatil@gmail.om");
        driver.findElement(By.id("input-password")).sendKeys("pppp");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();



        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        WebElement laptopMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[2]/a")));

        Actions actions = new Actions(driver);
        actions.moveToElement(laptopMenu).perform();

        WebElement allLaptopLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[2]/div/a")));
        allLaptopLink.click();


        driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[2]/div/div[2]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[3]/div/div[2]/div[2]/button[1]")).click();


        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/span")).click();
        String product1 = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr[1]/td[2]/a")).getText();
        String product2 = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr[2]/td[2]/a")).getText();
        String total = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/table/tbody/tr[4]/td[2]")).getText();

        if(product1.equals("MacBook") && product2.equals("MacBook Air")){
            System.out.println("products added correctly");
        }else {
            System.out.println("Added incorrect products");
        }

        if(total.equals("$1,804.00")){
            System.out.println("Total is correct");
        }else {
            System.out.println("wrong total");
        }


    }
}