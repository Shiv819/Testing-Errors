package SeleniumConcepts;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AT03_WebTables_GetOneRowData {

    @Test
    public void GetAllTableData(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.get("file:///C:/Users/Administrator/Desktop/table2.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Row1, column2 cell value print
        WebElement cellValue=driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody/tr[1]/td[2]"));
        System.out.println("printing specific cell vale: " + cellValue.getText());

        //To print all the values in the row which has header as "clock tower hotel"
        String sRowValue="Clock Tower Hotel";
        //heading count in first column
        List<WebElement> ele = driver.findElements(By.xpath("//table[@summary='Sample Table']/tbody/tr/th"));
        int NumCells=ele.size();
        // size 4

        //get count for row 2
        List <WebElement> row2Counts = driver.findElements(By.xpath("/html/body/table/tbody/tr[2]/td"));
        int row2Count=row2Counts.size();
        // row has 6 values

        for(int i=1;i<=NumCells;i++)
        {
            //Print headers in column one until it matches with "Clock Tower Hotel"
            String sVal=driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody/tr["+i+"]/th")).getText();
            System.out.println("this is "+sVal);
            if(sVal.equalsIgnoreCase(sRowValue))
            {
                for(int j = 1;j<=row2Count;j++)
                {
                    WebElement textValue=driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody/tr["+i+"]/td["+j+"]"));
                    System.out.println("text contained row values : " + textValue.getText());
                }
                break;
            }
        }
        driver.quit();




    }
}

