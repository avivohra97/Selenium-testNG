import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
    public WebDriver driver = null;
    @DataProvider(name = "browserName")
    public Object[][] browserName()
    {
        return new Object[][] { { "chrome" }, { "firefox" } };
    }

    @Test(dataProvider = "browserName")
    public void crossBrowserTest(String browser)
    {

        System.out.println("Launching browser : " + browser);
        switch(browser)
        {
            case "chrome":
//                System.setProperty("webdriver.chrome.driver", "<Path_to_your_chrome_driver>");
                driver = new ChromeDriver();
                break;
            case "firefox":
//                System.setProperty("webdriver.firefox.driver", "<Path_to_your_firefox_driver>");
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Invalid browser name passed");
        }
        driver.get("http://www.lambdatest.com/");
        System.out.println("Navigated Successfully to the website");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}

/*
* @DataProvider(name = "SanityTestData")
   public Object[][] sanityTestDataProvider() {
       String[][] testData = { { "1", "4", "5" }, { "2", "4", "7" } };
       return testData;
   }

   @Test(dataProvider = "SanityTestData", description = "Test case with group and data provider but without priority", alwaysRun = true, groups = { "sanity" })
   public void testSumOfTwoValues(String firstValue, String secondValue, String expectedSum) {
       // to enter data and submit
       driver.findElement(By.id("sum1")).sendKeys(firstValue);
       driver.findElement(By.id("sum2")).sendKeys(secondValue);
       driver.findElement(By.xpath("//button[text()='Get Sum']")).click();


       // to fetch actual result
       String actualSum = driver.findElement(By.id("addmessage")).getText();


       // to assert actual and expected result
       Assert.assertEquals(actualSum, expectedSum,
               "Expected and actual results do not match. Expected : " + expectedSum + " and Actual : " + actualSum);


   }
* */