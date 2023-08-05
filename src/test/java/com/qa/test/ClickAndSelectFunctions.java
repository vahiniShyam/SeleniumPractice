package com.qa.test;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClickAndSelectFunctions {

public static WebDriver driver;
WebElement iframe;
WebElement checkboxRadio;
WebElement radio;
WebElement checkbox1;
WebElement checkbox2;
WebElement selectMenu;
WebElement speed;

    @BeforeClass
    public static void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vahini Shyam\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://jqueryui.com/");
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test()
    public void ACheckBoxRadioButton()
    {

        checkboxRadio = driver.findElement(By.xpath("//a[text() = 'Checkboxradio']"));
        checkboxRadio.click();
    }

    @Test
    public void BradioButton()
    {
        iframe = driver.findElement(By.xpath("//iframe[@class = 'demo-frame']"));
        driver.switchTo().frame(iframe);
        radio = driver.findElement(By.xpath("//label[@for = 'radio-2']"));
        radio.click();
    }

    @Test
    public void CcheckBox() throws InterruptedException {
        checkbox1 = driver.findElement(By.xpath("//label[@for = 'checkbox-3']"));
        checkbox1.click();
        Thread.sleep(1000);
        checkbox2 = driver.findElement(By.xpath("//label[@for = 'checkbox-4']"));
        checkbox2.click();
        driver.switchTo().defaultContent();
    }

    @Test
    public void DselectMenu()
    {
        driver.switchTo().defaultContent();
        selectMenu = driver.findElement(By.xpath("//a[text() = 'Selectmenu']"));
        selectMenu.click();

    }

    @Test
    public void Edropdown() throws InterruptedException {
        iframe = driver.findElement(By.xpath("//iframe[@class = 'demo-frame']"));
        System.out.println(iframe.isDisplayed());
        driver.switchTo().frame(iframe);

        speed = driver.findElement(By.id("speed"));
        System.out.println(speed.isDisplayed());
        System.out.println(speed.getText());

        Select select = new Select(speed);
        List<WebElement> list = select.getOptions();
        System.out.println(list.get(0).getText());

        Thread.sleep(1000);
        select.selectByIndex(4);
    }

}
