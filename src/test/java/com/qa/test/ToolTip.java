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

public class ToolTip {

    public static WebDriver driver;

    public static Actions action;
    WebElement toolTipButton;
    WebElement tooltip;
    WebElement toolTipTextField;
    WebElement tooltip1;
    WebElement contrary;
    WebElement tooltip2;
    WebElement section;
    WebElement tooltip3;


    @BeforeClass
    public static void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vahini Shyam\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://demoqa.com/tool-tips");

        action = new Actions(driver);
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void toolTipButton()
    {
        toolTipButton = driver.findElement(By.id("toolTipButton"));

        action.moveToElement(toolTipButton).perform();
        tooltip = driver.findElement(By.xpath("//div[@id = 'buttonToolTip']/div[@class = 'tooltip-inner']"));
        System.out.println("toolTipButton text is: " +tooltip.getText());
    }

    @Test
    public void toolTipTextField()
    {
        toolTipTextField = driver.findElement(By.id("toolTipTextField"));

        action.moveToElement(toolTipTextField).perform();
        tooltip1 = driver.findElement(By.xpath("//div[@id = 'textFieldToolTip']/div[@class = 'tooltip-inner']"));
        System.out.println("toolTipTextField text is: " +tooltip1.getText());
    }

    @Test
    public void textToolTopContainer()
    {
        contrary = driver.findElement(By.xpath("//a[text() = 'Contrary']"));
        action.moveToElement(contrary).perform();
        tooltip2 = driver.findElement(By.xpath("//div[@id = 'contraryTexToolTip']/div[@class = 'tooltip-inner']"));
        System.out.println("contraryTexToolTip text is: " +tooltip2.getText());

        section = driver.findElement(By.xpath("//a[text() = '1.10.32']"));
        action.moveToElement(section).perform();
        tooltip3 = driver.findElement(By.xpath("//div[@id = 'sectionToolTip']/div[@class = 'tooltip-inner']"));
        System.out.println("sectionToolTip text is: " +tooltip3.getText());
    }
}
