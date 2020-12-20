package pageClass;

import java.util.Properties;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.driverClass;

public class OrderPage extends driverClass {
	public OrderPage() {
		PageFactory.initElements(driver, this);
	}

	Properties prop = driverClass.prop;

	public void OrderCalculate() {

		Select dropdown = new Select(driver.findElement(By.xpath(prop.getProperty("dropdown"))));
		dropdown.selectByVisibleText("FamilyAlbum");
		driver.findElement(By.xpath(prop.getProperty("quantity"))).clear();
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath(prop.getProperty("quantity"))).sendKeys(Keys.chord(Keys.CONTROL, "a"), "5");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(prop.getProperty("calculate"))).click();
	}

	public void verifyCalculate() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String total = driver.findElement(By.xpath(prop.getProperty("Total"))).getAttribute("value");
		String quan = driver.findElement(By.xpath(prop.getProperty("quantity"))).getAttribute("value");
		String price = driver.findElement(By.xpath(prop.getProperty("price"))).getAttribute("value");
		int t = Integer.parseInt(total);
		int q = Integer.parseInt(quan);
		int p = Integer.parseInt(price);
		System.out.println("t = " + total + "  q = " + q + "  p = " + p);
		if (t == (q * p))
			System.out.println("correct");
	}

	public void Reseting() {
		driver.findElement(By.xpath(prop.getProperty("resetB"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void VerifyReset() {
		String total = driver.findElement(By.xpath(prop.getProperty("Total"))).getAttribute("value");
		String quan = driver.findElement(By.xpath(prop.getProperty("quantity"))).getAttribute("value");
		if ((total.equals("0")) && (quan.equals("0"))) {
			System.out.println("resestted");
		} else {
			Assert.fail();
		}
	}

	public void addressinput(String Cname,String str,String city,String sta) {
		System.out.println("Cname:--  "+Cname);
		driver.findElement(By.xpath(prop.getProperty("CName"))).sendKeys(Cname);
		driver.findElement(By.xpath(prop.getProperty("Street"))).sendKeys(str);
		driver.findElement(By.xpath(prop.getProperty("city"))).sendKeys(city);
		driver.findElement(By.xpath(prop.getProperty("State"))).sendKeys(sta);
		driver.findElement(By.xpath(prop.getProperty("Zip"))).sendKeys(("56485"));
	}

	public void Creditdata() {
		driver.findElement(By.xpath(prop.getProperty("visa"))).click();
		driver.findElement(By.xpath(prop.getProperty("CardNr"))).sendKeys("123456");
		driver.findElement(By.xpath(prop.getProperty("Exdate"))).sendKeys("12/12");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Process() {
		driver.findElement(By.xpath(prop.getProperty("processB"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void confirm() {
		String edo = driver.findElement(By.xpath(prop.getProperty("strong"))).getText();
		System.out.println(edo);
	}
	
	public AllOrdersPage AllOrders() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("loginVerify_xpath"))));
		driver.findElement(By.xpath(prop.getProperty("allOrders"))).click();
		return new AllOrdersPage();
	}
	public ProductPage ProductP() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("loginVerify_xpath"))));
		driver.findElement(By.xpath(prop.getProperty("Product_xpath"))).click();
		return new ProductPage();
	}
}
