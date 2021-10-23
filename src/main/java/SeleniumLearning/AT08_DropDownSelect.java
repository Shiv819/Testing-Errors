package SeleniumLearning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AT08_DropDownSelect {

    @Test
    public void SelectDropDown() {
        //setup the chromedriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.harveynorman.com.au/dyson-v7-cordfree-vacuum-cleaner.html");

        //Wait few seconds for the page to load
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Select Warranty = new Select(driver.findElement(By.id("select_999999900")));
        //First Method
        //   Warranty.selectByVisibleText("2 years Product Care Replacement");

        //Second Method
        int j= Warranty.getOptions().size();
        //      Warranty.selectByIndex(1);

        //Third Method
        for(int i=0;i<j;i++){
            String WarName=Warranty.getOptions().get(i).getText();
            System.out.println(WarName);

            if(WarName.equalsIgnoreCase("2 years Product Care Replacement")){
                Warranty.getOptions().get(i).click();
            }



        }





    }
}