package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageClass.loginPage;


public class driverClass {

	protected static WebDriver driver;
	public static Properties prop;

    //Local FireFoxDriverSetup
	public void invokeBrowser() throws MalformedURLException {
		 try {
	            ChromeOptions chromeOptions;
	            FirefoxOptions firefoxOptions;
	            //URL testGridUrl = new URL(System.getProperty("gridURL").trim());
	            String strExecutionPlatform = "LOCAL_CHROME";
	            //String strExecutionPlatform = System.getProperty("executionPlatform").trim().toUpperCase();
	            //LOCAL_CHROME, LOCAL_FIREFOX, AWS_CHROME, AWS_FIREFOX, AWS_DEVICEFARM_CHROME, AWS_DEVICEFARM_FIREFOX
	            System.out.println("Enterting switch");


	            switch (strExecutionPlatform) {

	                case "LOCAL_CHROME":
	                	System.out.println("came here");
	                	System.setProperty("webdriver.chrome.driver",
	         					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
	         			driver = new ChromeDriver();
	         			driver.manage().window().maximize();
	         			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
	                    break;
	                case "AWS_CHROME":
	                	ChromeOptions chromeOptions1 = new ChromeOptions();    
	                    chromeOptions1.setHeadless(true);
	                    chromeOptions1.addArguments("--no-sandbox");
	                    chromeOptions1.addArguments("--disable-dev-shm-usage");
	                    chromeOptions1.addArguments("start-maximized");
	                    chromeOptions1.addArguments("--disable-gpu");
	                    chromeOptions1.addArguments("enable-automation");
	                    chromeOptions1.addArguments("--disable-infobars");
	                    chromeOptions1.setBinary(readData().getProperty("AWS_CHROME_BROWSER_PATH").trim());
	                    System.setProperty("webdriver.chrome.driver", readData().getProperty("AWS_CHROME_DRIVER_PATH").trim());
	                    driver = new ChromeDriver(chromeOptions1);
	                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
	                    break;
	                    
	                case "AWS_FIREFOX":
	                	FirefoxOptions firefoxOptions1 = new FirefoxOptions();
	                    firefoxOptions1.setHeadless(true);
	                    firefoxOptions1.setBinary(readData().getProperty("AWS_FIREFOX_BROWSER_PATH").trim());
	                    System.setProperty("webdriver.gecko.driver",readData().getProperty("AWS_FIREFOX_DRIVER_PATH").trim());
	                    driver = new FirefoxDriver(firefoxOptions1);
	                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	                    break;
	                default:
	            }
	            } catch(Exception ex) {
	            ex.printStackTrace();
	        }
		 
		 if (prop == null) {
				prop = new Properties();
				FileInputStream file = null;
				try {
					file = new FileInputStream(
							System.getProperty("user.dir") + "\\src\\main\\java\\objectRepository\\data.properties");
					prop.load(file);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
	}
		

    
    public static Properties readData() {
        Properties objProp = new Properties();
        try {
           String env = System.getProperty("env");
            File file = new File("\\src\\main\\java\\objectRepository\\data.properties");
            FileInputStream fileInput = null;
            fileInput = new FileInputStream(file);
            objProp.load(fileInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objProp;
    }
    
    public void openURL2(String xpathKey) {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get(prop.getProperty(xpathKey));
	}

	public void openURL(String xpathKey) {
		driver.get(prop.getProperty(xpathKey));
	}

	public void openURL3(String xpathKey) {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
		driver.get(prop.getProperty(xpathKey));
	}

	public String actualTitle, expectedTitle;

	public loginPage verifyLoginPage() {
		actualTitle = driver.getTitle();
		expectedTitle = prop.getProperty("expected");
		if (actualTitle.matches(expectedTitle))
			System.out.println("Landed on home page successfully");
		else
			System.out.println("Not landed on home page successfully");
		return new loginPage();
	}

	
}
