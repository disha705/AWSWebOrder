package pageClass;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import baseClass.driverClass;
import org.junit.Assert;

public class AllOrdersPage extends driverClass {

	Properties prop = driverClass.prop;

	public AllOrdersPage() {
		PageFactory.initElements(driver, this);
	}

	public void searchCreatedOrder() {
		if (driver.findElement(By.xpath(prop.getProperty("Name"))).getText().equals("xyzxyz")
				&& (driver.findElement(By.xpath(prop.getProperty("OCardNr"))).getText()).equals("123456")) {
			System.out.println("Order Created");
		} else {
			Assert.fail();
		}
	}

	public void EditOrder() {
		driver.findElement(By.xpath(prop.getProperty("Edit"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(prop.getProperty("visa"))).click();
		driver.findElement(By.xpath(prop.getProperty("Exdate"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Exdate"))).sendKeys("12/19");
		driver.findElement(By.xpath(prop.getProperty("updateB"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void VerifyEditOrder() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.findElement(By.xpath(prop.getProperty("OCard"))).getText());
		if (driver.findElement(By.xpath(prop.getProperty("OCard"))).getText().equalsIgnoreCase("visa")
				&& (driver.findElement(By.xpath(prop.getProperty("OExDate"))).getText()).equals("12/19"))
			System.out.println("Order Updated");
		else {
			System.out.println("verification failed");
		}
	}

	public void EditOrder2() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(prop.getProperty("Edit"))).click();
		String url = driver.getCurrentUrl();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(prop.getProperty("Zip"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Zip"))).sendKeys("65485");
		driver.findElement(By.xpath(prop.getProperty("city"))).clear();
		driver.findElement(By.xpath(prop.getProperty("city"))).sendKeys("oedude");
		driver.findElement(By.xpath(prop.getProperty("updateB"))).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void VerifyEditOrder2() {
		System.out.println("came here");

		if (driver.findElement(By.xpath(prop.getProperty("Zipcode"))).getText().equals("65485")
				&& (driver.findElement(By.xpath(prop.getProperty("cityO"))).getText()).equals("oedude"))
			System.out.println("Order Updated");

		else {
			System.out.println("verify faild");
		}
	}

	public void logout() {
		driver.findElement(By.xpath(prop.getProperty("logout"))).click();
		System.out.println("Logged OUT");
	}
}
