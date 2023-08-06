package com.qa.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsAndPopups {

    public static WebDriver driver;
    WebElement alertButton;
    WebElement timerAlertButton;
    WebElement confirmButton;
    WebElement promtButton;

    @BeforeClass
    public static void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vahini Shyam\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://demoqa.com/alerts");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void alertButton()
    {
        alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();

        Alert alert1 = driver.switchTo().alert();
        System.out.println("Alert1 " +alert1.getText());
        alert1.accept();
    }

    @Test
    public void timerAlertButton()
    {
        timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        timerAlertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert2 = driver.switchTo().alert();
        System.out.println("Alert2 " +alert2.getText());
        alert2.accept();
    }

    @Test
    public void confirmButton()
    {
        confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();

        Alert alert3 = driver.switchTo().alert();
        System.out.println("Alert3 " +alert3.getText());

        alert3.dismiss();

        System.out.println(driver.findElement(By.id("confirmResult")).getText());
    }

    @Test
    public void promtButton()
    {
        promtButton = driver.findElement(By.id("promtButton"));
        promtButton.click();

        Alert alert4 = driver.switchTo().alert();
        System.out.println("Alert4 " +alert4.getText());
        alert4.sendKeys("Test Alert");
        alert4.accept();

        System.out.println(driver.findElement(By.id("promptResult")).getText());
        System.out.println("END");
    }
}
