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

public class Property_File 
{
	WebDriver driver;
	Properties con;
	
	@BeforeTest
	public void setup() throws Throwable 
	{
		con = new Properties();
		con.load(new FileInputStream("OrengeHrm.properties"));
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(con.getProperty("Url"));
	}
@Test
public void verifyLogin()
{
	driver.findElement(By.xpath(con.getProperty("objReset"))).click();
	driver.findElement(By.xpath(con.getProperty("objuser"))).sendKeys(con.getProperty("Enteruser"));
	driver.findElement(By.xpath(con.getProperty("objpass"))).sendKeys(con.getProperty("Enterpass"));
	driver.findElement(By.xpath(con.getProperty("objLoginbtn"))).click();
	
	String Expected_tittel="Dashboard « Stock Accounting";
	
	String Actual_tittle=driver.getTitle();
	
	if(Expected_tittel.equalsIgnoreCase(Actual_tittle))
	{
		Reporter.log("Login Sucess::"+Expected_tittel+" "+ Actual_tittle ,true);
	}else
	{
		Reporter.log("Login Fail::"+Expected_tittel+" "+ Actual_tittle ,true);
	}
	
}

@AfterTest
public void teardown()
{
	driver.quit();
}
}
