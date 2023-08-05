package com.qa.test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
public class ExcelReading {

    public static WebDriver driver;

    WebElement login;
    WebElement email;
    WebElement password;
    WebElement rememberMe;
    WebElement loginBtn;
    WebElement logout;
    File file;
    FileInputStream fis;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row1;
    XSSFCell cell1;


    @BeforeClass
    public static void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vahini Shyam\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://demo.nopcommerce.com/login");


    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void readExcelData() throws IOException {

        file = new File("C:\\Users\\Vahini Shyam\\Desktop\\LoginData.xlsx");

        fis = new FileInputStream(file);

        workbook = new XSSFWorkbook(fis);

        sheet = workbook.getSheet("sheet1");

        row1 = sheet.getRow(0);
        cell1 = row1.getCell(0);
        System.out.println("Cell1 value is " +cell1.getStringCellValue());

        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        System.out.println("No of rows: " +rowCount);

        for(int i = 0; i <= rowCount; i++)
        {
            int cellCount = sheet.getRow(i).getLastCellNum();

            System.out.println("No of cells: " + cellCount);

            for(int j = 0; j < cellCount; j++)
            {
                System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() + " ");
            }
            System.out.println();

        }
            /*login = driver.findElement(By.xpath("//a[text() = 'Log in']"));
            login.click();

            email = driver.findElement(By.id("Email"));
            email.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());

            password = driver.findElement(By.id("Password"));
            password.sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());

            rememberMe = driver.findElement(By.id("RememberMe"));

            loginBtn = driver.findElement(By.xpath("//button[text() = 'Log in']"));
            loginBtn.click();

            System.out.println("Title is " +driver.getTitle());

            logout = driver.findElement(By.xpath("//a[text() = 'Log in']"));
            logout.click();

            System.out.println("Title is " +driver.getTitle());
        }*/



    }
}
