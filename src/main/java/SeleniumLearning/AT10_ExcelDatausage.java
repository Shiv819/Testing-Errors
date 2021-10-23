package SeleniumLearning;

import excelReader.Xls_Reader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class AT10_ExcelDatausage {

    @Test
    public void selectDropDown()  {

        //setup the chromedriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.harveynorman.com.au/customer/account/create/");
        //Wait few seconds for the page to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //location of excel workbook
        Xls_Reader reader = new Xls_Reader("D:\\SeleniumMaterial-StudentsDistribution\\06_DataDrivenTesting\\05_SeleniumParameterization\\TestDataHN1.xlsx");
        // we did rowcount in worksheet
        int rowcount =reader.getRowCount("RegTestData");
        //we start picking data from line 2
        for (int i=2;i<rowcount;i++){
            //we picked firstname and entered into firstname field on the website
            String FirstName = reader.getCellData("RegTestData", "FirstName", i);
            //we clear the field
            driver.findElement(By.id("firstname")).clear();
            driver.findElement(By.id("firstname")).sendKeys(FirstName);

            String LastName = reader.getCellData("RegTestData", "LastName", i);
            driver.findElement(By.id("lastname")).clear();
            driver.findElement(By.id("lastname")).sendKeys(LastName);

            String EmailAddress = reader.getCellData("RegTestData", "EmailAddress", i);
            driver.findElement(By.id("email_address")).clear();
            driver.findElement(By.id("email_address")).sendKeys(EmailAddress);

        }


    }
}


