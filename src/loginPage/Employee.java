package loginPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.AppUtils;

public class Employee extends AppUtils
{

	public boolean addEmployee(String empname, String emplastname ) 
	{
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.partialLinkText("Add Employee")).click();
		driver.findElement(By.id("firstName")).sendKeys(empname);

		driver.findElement(By.id("lastName")).sendKeys(emplastname);
		String empid=driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.linkText("Employee List")).click();
		driver.findElement(By.id("empsearch_id")).sendKeys(empid);
		driver.findElement(By.id("searchBtn")).click();

		WebElement emptable= driver.findElement(By.id("resultTable"));
		List<WebElement>  emprows= emptable.findElements(By.tagName("tr"));
		boolean res= false;
		for (int i = 1; i < emprows.size(); i++) 
		{
			List<WebElement> empcolms= emprows.get(i).findElements(By.tagName("td"));
			if(empcolms.get(1).getText().equals(empid))
			{
				System.out.println(empcolms.get(1).getText());
				res= true;
				break;

			}else
			{
				res=false;
			}

		}
		return res;



	}

	public boolean addsystemUsers(String uesrRole,String empname, String userName, String pwd) throws Throwable
	{
		driver.findElement(By.linkText("Admin")).click();
		driver.findElement(By.linkText("User Management")).click();
		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.id("btnAdd")).click();

		Select droplist= new Select(driver.findElement(By.id("systemUser_userType")));
		droplist.selectByVisibleText(uesrRole);
		driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(empname);
		driver.findElement(By.id("systemUser_userName")).sendKeys(userName);
		driver.findElement(By.id("systemUser_password")).sendKeys(pwd);
		driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(pwd);
		Thread.sleep(2000);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys(userName);
		driver.findElement(By.id("searchBtn")).click();

		WebElement emptable= driver.findElement(By.id("resultTable"));
		List<WebElement>  emprows= emptable.findElements(By.tagName("tr"));
		boolean res= false;
		for (int i = 1; i < emprows.size(); i++) 
		{
			List<WebElement> empcolms= emprows.get(i).findElements(By.tagName("td"));
			if(empcolms.get(1).getText().equals(userName))
			{
				System.out.println(empcolms.get(1).getText());
				res= true;
				break;

			}else
			{
				res=false;
			}

		}
		return res;

	}

	public boolean isEmployeeDisplay()
	{
		boolean res= false;
		try {

			driver.findElement(By.linkText("Admin")).isDisplayed();
			{
				res= false;
			}


		} catch (Exception e) 
		{
			res= true;
			//System.out.println(e.getMessage());
		}
		return res;

	}




}
