package com.qa.test;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWaits {

    public WebDriver driver;
    WebElement text;
    WebElement enableAfter;
    WebElement colorChange;
    WebElement visibleAfter;
    WebDriverWait wait;


    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vahini Shyam\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();


        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://demoqa.com/dynamic-properties");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void impilicitWaitCheck()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        text = driver.findElement(By.xpath("//p[text() = 'This text has random Id']"));
        System.out.println("Text is: " +text.getText());
        enableAfter = driver.findElement(By.id("enableAfter"));
        System.out.println(enableAfter.isEnabled());

        enableAfter.click();

        colorChange = driver.findElement(By.id("colorChange"));
        colorChange.click();

        visibleAfter = driver.findElement(By.id("visibleAfter"));
        System.out.println(visibleAfter.isDisplayed());
        visibleAfter.click();
    }

    @Test
    public void explicitWaitCheck() throws InterruptedException {
        text = driver.findElement(By.xpath("//p[text() = 'This text has random Id']"));
        System.out.println("Text is: " +text.getText());

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        enableAfter = driver.findElement(By.id("enableAfter"));
        wait.until(ExpectedConditions.elementToBeClickable(enableAfter));
        System.out.println(enableAfter.isEnabled());
        enableAfter.click();

        Thread.sleep(1000);

        colorChange = driver.findElement(By.id("colorChange"));
        colorChange.click();

        Thread.sleep(1000);

        visibleAfter = driver.findElement(By.id("visibleAfter"));
        wait.until(ExpectedConditions.visibilityOf(visibleAfter));
        System.out.println(visibleAfter.isDisplayed());
        visibleAfter.click();

    }

}
