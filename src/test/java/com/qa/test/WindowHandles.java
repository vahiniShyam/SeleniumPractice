package com.qa.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandles {

    public static WebDriver driver;
    String mainWindow;
    WebElement tabButton;
    WebElement windowButton;
    WebElement messageWindowButton;
    String childWindowText;
    String childWindow1;
    String childWindow2;
    String childWindow1Text;
    String childWindow2Text;

    Wait<WebDriver> wait;

    @BeforeClass
    public static void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vahini Shyam\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://demoqa.com/browser-windows");
    }

    /*@AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }*/

    @Test
    public void windowHandling()
    {
        mainWindow = driver.getWindowHandle();
        System.out.println("Main Window:" +mainWindow);

        windowButton = driver.findElement(By.id("tabButton"));
        tabButton.click();

        Set<String> windowHandles = driver.getWindowHandles();
        for(String childwindow : windowHandles)
        {
            if(!mainWindow.equalsIgnoreCase(childwindow))
            {
                driver.switchTo().window(childwindow);
                childWindowText = driver.findElement(By.id("sampleHeading")).getText();
                System.out.println(childWindowText);
                driver.close();

                driver.switchTo().window(mainWindow);
            }
        }
    }

    @Test
    public void MultipleWindowsHandling() throws InterruptedException {
        /*mainWindow = driver.getWindowHandle();
        System.out.println("Main Window:" +mainWindow);*/

        windowButton = driver.findElement(By.id("windowButton"));
        windowButton.click();

        messageWindowButton = driver.findElement(By.id("messageWindowButton"));
        messageWindowButton.click();

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles.size());
        Iterator<String> it = windowHandles.iterator();


            mainWindow = it.next();
            System.out.println("Main Window ID is " +mainWindow);

            childWindow1 = it.next();
            System.out.println("child window1 ID is " +childWindow1);

            childWindow2 = it.next();
            System.out.println("child window2 ID is " +childWindow2);

            driver.switchTo().window(childWindow1);
            System.out.println("Current Window handle is: " +driver.getWindowHandle());

            wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(5)).ignoring(TimeoutException.class);


            System.out.println("Title of child window 1 is " +driver.getTitle());

            //new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(driver.findElement(By.id("sampleHeading"))));
            /*childWindow1Text = driver.findElement(By.id("sampleHeading")).getText();
            System.out.println(childWindow1Text);*/

            Thread.sleep(2000);
            driver.close();

            driver.switchTo().window(childWindow2);
            System.out.println("Current Window handle is: " +driver.getWindowHandle());

            System.out.println("Title of child window 2 is " +driver.getTitle());

            childWindow2Text = driver.findElement(By.tagName("body")).getText();
            System.out.println(childWindow2Text);

            Thread.sleep(2000);
            driver.close();

            driver.switchTo().window(mainWindow);
            System.out.println("Current Window handle is: " +driver.getWindowHandle());

            System.out.println("Title of main window is " +driver.getTitle());

            Thread.sleep(2000);
            driver.close();

    }
}
