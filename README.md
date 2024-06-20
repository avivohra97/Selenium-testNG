# Selenium-testNG

@BeforeSuite -> @BeforeTest -> @BeforeClass -> @BeforeMethod -> @Test -> @AfterMethod -> @AfterClass -> @AfterTest -> @AfterSuite

``` 
This will execute before the Test Suite
This will execute before the First Test
This will execute before the Class
This will execute before every Test Method
This is Test Case 1
This will execute after every Test Method
This will execute before every Test Method
This is Test Case 2
This will execute after every Test Method
This will execute after the Class
This will execute after the Last Test
This will execute after the Test Suite
```

``` 
@DataProvider(name = "SanityTestData")
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
```