package SeleniumConcepts;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AT02_WebTables_GetAllRowsData {

    @Test
    public void GetAllTableData() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("file:///C:/Users/Administrator/Desktop/table2.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //To Get all the cells data
        List<WebElement> ele = driver.findElements(By.xpath("//table[@summary='Sample Table']/tbody/tr"));
        //Scenario-1
        int NumCells = ele.size();
        for (int i = 0; i <= NumCells; i++) {
            System.out.println(ele.get(i).getText());
        }
        //Scenario-2
//      for(WebElement e:ele)
//      {
//       System.out.println(e.getText());
//      }
    }
}
