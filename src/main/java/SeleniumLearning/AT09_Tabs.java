package SeleniumLearning;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class AT09_Tabs {

    @Test
    public void SelectDropDown() {
        //setup the chromedriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.harveynorman.com.au/customer/account/login");

        //Wait few seconds for the page to load
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // click on CustomiseMe link
        driver.findElement(By.xpath("//a[contains(text(),'CustomiseMe')]")).click();
        //Wait few seconds for the page to load
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // get all tabs into an array
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        //get tabs size
        System.out.println(tabs.size());
        //got to second tab
        driver.switchTo().window(tabs.get(1));
        // refresh page
        driver.navigate().refresh();
        // switch back to tab-1
        driver.switchTo().window(tabs.get(0));
     /*
        for (int i=0; i<tabs.size();i++){
            driver.switchTo().window(tabs.get(i));
            break;
        }

*/



    }
}
