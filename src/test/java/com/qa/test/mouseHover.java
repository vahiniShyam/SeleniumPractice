package com.qa.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class mouseHover {

    public static WebDriver driver;
    WebElement mainItem1;
    WebElement mainItem2;
    WebElement mainItem3;


    @BeforeClass
    public static void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vahini Shyam\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://demoqa.com/menu/#");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void hover() throws InterruptedException {
        mainItem1 = driver.findElement(By.xpath("//a[text() = 'Main Item 1']"));
        mainItem2 = driver.findElement(By.xpath("//a[text() = 'Main Item 2']"));
        mainItem3 = driver.findElement(By.xpath("//a[text() = 'Main Item 3']"));

        Actions action = new Actions(driver);

        action.moveToElement(mainItem1).build().perform();
        System.out.println(mainItem1.getText());

        Thread.sleep(1000);

        action.moveToElement(mainItem2).build().perform();
        Thread.sleep(1000);

        action.moveToElement(driver.findElement(By.xpath("//a[text() = 'SUB SUB LIST »']"))).build().perform();
        Thread.sleep(1000);

        action.moveToElement(driver.findElement(By.xpath("//a[text() = 'Sub Sub Item 2']"))).build().perform();
        Thread.sleep(1000);

    }
}
