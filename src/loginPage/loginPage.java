package loginPage;

import org.openqa.selenium.By;

import utils.AppUtils;

public class loginPage extends AppUtils
{

	public void login( String uname,String pwd)
	{
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();
	}
  
	
	public void logOutPage()
	{
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	public boolean isDisplayAdminPage()
	{
		try {
			driver.findElement(By.linkText("Admin")).isDisplayed();
			return true;

		} catch (Exception e) 
		{
			System.out.println(e.getMessage());
			return false;

		}
	}

	public boolean isErrorMsgDisplay()
	{
		String Errormsg= driver.findElement(By.id("spanMessage")).getText();
		if(Errormsg.contains("Invalid"))
		{
			return true;
		}else
		{
			return false;
		}
	}


}
