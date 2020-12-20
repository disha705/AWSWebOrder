package pageClass;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.driverClass;

public class loginPage extends driverClass{

	Properties prop= driverClass.prop;
	
	public loginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loginFunction(String xpathKey, String data)
	{   
		System.out.println("DATA REY_"+data);
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(data);
	}
	
	public void clickfunction(String xpathKey)
	{
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).click();
	}
	
	public void TextboxU(String xpathKey)
	{

		if(driver.findElement(By.xpath(prop.getProperty(xpathKey)))!= null){

			System.out.println("Element is Present");

			}else{

			System.out.println("Element is Absent");

			}
	}
	public void TextboxP(String xpathKey)
	{
		if(driver.findElement(By.xpath(prop.getProperty(xpathKey)))!= null){

			System.out.println("Element is Present");

			}else{

			System.out.println("Element is Absent");

			}
	}
	public void ButtonB(String xpathKey)
	{
		if(driver.findElement(By.xpath(prop.getProperty(xpathKey)))!= null){

			System.out.println("Element is Present");

			}else{
			System.out.println("Element is Absent");
			}
	}
	
	public OrderPage verifyLogin(String xpathKey)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("loginVerify_xpath"))));
		
		System.out.println(driver.findElement(By.xpath(prop.getProperty(xpathKey))).getText());
		if((driver.findElement(By.xpath(prop.getProperty(xpathKey))).getText()).equals("Welcome, Tester! | Logout"))
			System.out.println("logged in successfully");
		else
			System.out.println("Login credentials are incorrect");
		driver.findElement(By.xpath(prop.getProperty("Order_xpath"))).click();
		return new OrderPage();
	}
}
