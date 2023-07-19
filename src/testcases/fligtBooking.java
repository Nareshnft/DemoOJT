package testcases;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class fligtBooking 
{
	WebDriver driver;
	Properties con;

	
	@BeforeTest
	public void setup() throws Throwable
	{
		con= new Properties();
		con.load(new FileInputStream("flight.properties"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(con.getProperty("BaseUrl"));

	}

	@Test
	public void verifyLogin()

	{
		driver.findElement(By.xpath(con.getProperty("objemai"))).sendKeys(con.getProperty("Enteremail"));
		driver.findElement(By.xpath(con.getProperty("objpassword"))).sendKeys(con.getProperty("Enterpass"));
		driver.findElement(By.xpath(con.getProperty("objsignbtn"))).click();

		String expect_tittle="Flight Reservation | Dashboard";
		String actual_tittle= driver.getTitle();
		
		if(expect_tittle.contains(actual_tittle))
		{
			Reporter.log(" login Sucess::"+expect_tittle +" "+ actual_tittle,true);
			
			
		}else
		{
			Reporter.log(" login Fail::"+expect_tittle +" "+ actual_tittle,true);	
			
		}
	}



	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
