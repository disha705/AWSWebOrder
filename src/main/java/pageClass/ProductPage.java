package pageClass;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import baseClass.driverClass;

public class ProductPage extends driverClass {
	Properties prop = driverClass.prop;
	public ProductPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void Verifyvalues(String pn1,String pn2,String pn3,String p1,String p2,String p3,String d1,String d2,String d3)
	{
		driver.findElement(By.xpath(prop.getProperty("product1_name"))).getText();
		if(driver.findElement(By.xpath(prop.getProperty("product1_name"))).getText().equals(pn1) )
		{
			System.out.println("Name matched");
		}
		else
		{
			System.out.println("Name Not matched");
		}
	}
	public void logout2() {
		driver.findElement(By.xpath(prop.getProperty("logout"))).click();
		System.out.println("Logged OUT");
	}
}
