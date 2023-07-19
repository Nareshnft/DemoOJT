package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Extended_report 
{
	WebDriver driver;
	//ExtentReports report;
	//ExtentTest test;

/*
	@BeforeTest
	public void setupreport()
	{
		//report= new ExtentReports("C:\\Naresh\\Hydrid_framework\\ExtentReports\\Demo.htm");
	}
*/
	@BeforeMethod
	public void setup() 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}

	@Test
	public void testcase1()
	{
		//test=report.startTest(" Test pass");
		String expect_tittle="Google";
		String actual_tittle= driver.getTitle();

		if(expect_tittle.equalsIgnoreCase(actual_tittle))
		{
			//test.log(LogStatus.PASS, "Tittle is maching::"+expect_tittle +" "+ actual_tittle);
			Reporter.log("Tittle is maching::"+expect_tittle +" "+ actual_tittle);

		}else
		{
			//test.log(LogStatus.FAIL, "Tittle is not maching::"+expect_tittle +" "+ actual_tittle);
			Reporter.log("Tittle is not maching::"+expect_tittle +" "+ actual_tittle);

		}

	}
	
	@Test
	public void testcase2()
	{
		//test=report.startTest(" Test Fail");
		String expect_tittle="Gmail";
		String actual_tittle= driver.getTitle();

		if(expect_tittle.equalsIgnoreCase(actual_tittle))
		{
			//test.log(LogStatus.PASS, "Tittle is maching::"+expect_tittle +" "+ actual_tittle);
			Reporter.log("Tittle is maching::"+expect_tittle +" "+ actual_tittle);

		}else
		{
			//test.log(LogStatus.FAIL, "Tittle is not maching::"+expect_tittle +" "+ actual_tittle);
			Reporter.log("Tittle is not maching::"+expect_tittle +" "+ actual_tittle);

		}

	}
	
	@AfterMethod
	public void teardown()
	{
		//report.endTest(test);
		//report.flush();
		driver.quit();
	}

}
