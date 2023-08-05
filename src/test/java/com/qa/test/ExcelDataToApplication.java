package com.qa.test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.time.Duration;

public class ExcelDataToApplication {

    public static WebDriver driver;
    File file;
    FileInputStream fis;
    FileOutputStream fos;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;
    int rowCount;
    int cellCount;

    JavascriptExecutor js;
    WebElement firstName;
    WebElement lastName;
    WebElement userEmail;
    WebElement genderMale;
    WebElement hobbies;
    WebElement userNumber;
    WebElement submit;
    WebElement message;
    WebElement closeBtn;

    @BeforeClass
    public static void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vahini Shyam\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.get("https://demoqa.com/automation-practice-form");


    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void readExcelData() throws IOException, InterruptedException {
        file = new File("C:\\Users\\Vahini Shyam\\Desktop\\ExcelData.xlsx");

        fis = new FileInputStream(file);

        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet("Sheet1");

        rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        System.out.println("No of rows: " +rowCount);

            for(int i=1; i <= rowCount; i++)
        {
            //cellCount = sheet.getRow(i).getLastCellNum();

            /*for(int j = 0; j < cellCount; j++)
            {*/
            firstName = driver.findElement(By.id("firstName"));
            firstName.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
            Thread.sleep(1000);

            lastName = driver.findElement(By.id("lastName"));
            lastName.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
            Thread.sleep(1000);

            userEmail = driver.findElement(By.id("userEmail"));
            userEmail.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
                Thread.sleep(1000);

            genderMale = driver.findElement(By.id("gender-radio-1"));
            js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", genderMale);
            Thread.sleep(1000);

            userNumber = driver.findElement(By.id("userNumber"));
            userNumber.sendKeys(sheet.getRow(i).getCell(3).getStringCellValue());
            Thread.sleep(1000);

            hobbies = driver.findElement(By.id("hobbies-checkbox-1"));
            js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", hobbies);
            Thread.sleep(1000);

            submit = driver.findElement(By.id("submit"));
            js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", submit);
            Thread.sleep(1000);

            message = driver.findElement(By.id("example-modal-sizes-title-lg"));

            cell = sheet.getRow(i).createCell(4);

            if(message.isDisplayed())
            {
                cell.setCellValue("PASS");
            }
            else
            {
                cell.setCellValue("FAIL");
            }

            fos = new FileOutputStream(file);
            workbook.write(fos);

            closeBtn = driver.findElement(By.id("closeLargeModal"));
            js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", closeBtn);
            Thread.sleep(1000);

        }


    }
}
