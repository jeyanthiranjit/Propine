package newPackage;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class DateParse {
	
	WebDriver driver;
	

	String fileName = "C:\\Users\\jeyan\\eclipse-workspace\\Propine\\data\\testData.xlsx";
	String outputFileName = "C:\\Users\\jeyan\\eclipse-workspace\\Propine\\data\\result.xlsx";
	
	String inputSheet = "Sheet1";
	String outputSheet = "Sheet2";
String Flag;
  private Map<String, Object> vars;
  JavascriptExecutor js;
	
  @Test(dataProvider = "dp")
  public void Dataparse(Integer n, String s) {
   
	  String invalid = "Invalid date";
	 // System.out.println("parameters are" + s);
	  
    driver.get("https://vast-dawn-73245.herokuapp.com/");
    driver.manage().window().setSize(new Dimension(1550, 838));
    driver.findElement(By.name("date")).click();
       
   
          driver.findElement(By.name("date")).sendKeys(s);
          driver.findElement(By.cssSelector(".btn")).click();
          String date1 = driver.findElement(By.cssSelector(".col-md-6 > div")).getText();
          
  if(date1.contains(invalid))
  		 Flag = "FAIL";
  else 
	   Flag = "PASS";

  Assert.assertNotEquals(date1, invalid, "INvalid Date entered");
  
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "17-Marc-2020" },
      new Object[] { 2, "17 Marc 2020" },
      new Object[] { 3, "17/Marc/2020" },
      new Object[] { 4, "17-March-20" },
      new Object[] { 5, "17 March 20" },
      new Object[] { 6, "17/March/20" },
      new Object[] { 7, "17-Mar-2020" },
      new Object[] { 8, "17 Mar 2020" },
      new Object[] { 9, "17/Mar/2020" },
      new Object[] { 10, "17-Mar-20" },
      new Object[] { 11, "17 Mar 20" },
      new Object[] { 12, "17/Mar/20" },
      new Object[] { 13, "17-03-2020"},
      new Object[] { 14, "17 03 2020"},
      new Object[] { 15, "17/03/2020"},
      new Object[] { 16, "17-03-20"},
      new Object[] { 17, "17 03 20"},
      new Object[] { 18, "17/03/20"},
      new Object[] { 19, "March-17-2020"},
      new Object[] { 20, "March 17 2020"},
      new Object[] { 21, "March/17/2020"},
      new Object[] { 22, "March-17-20"},
      new Object[] { 23, "March 17 20"},
      new Object[] { 24, "March/17/20"},
      new Object[] { 25, "Mar-17-2020"},
      new Object[] { 26, "Mar 17 2020"},
      new Object[] { 27, "Mar/17/2020"},
      new Object[] { 28, "Mar-17-20"},
      new Object[] { 29, "Mar 17 20"},
      new Object[] { 30, "Mar/17/20"},
      new Object[] { 31, "03-17-2020"},
      new Object[] { 32, "03 17 2020"},
      new Object[] { 33, "03/17/2020"},
      new Object[] { 34, "03-17-20"},
      new Object[] { 35, "03 17 20"},
      new Object[] { 36, "03/17/20"}
      
    };
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver","C:\\Users\\jeyan\\eclipse-workspace\\Propine\\resources\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
  }

  @AfterTest
  public void afterTest() {
  
	  driver.quit();
  }

}
