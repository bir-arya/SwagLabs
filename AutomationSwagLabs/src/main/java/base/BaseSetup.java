package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.TestUtil;

public class BaseSetup {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	
	public BaseSetup()
	{
		try
		{
			FileInputStream read = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\AutomationSwagLabs\\src\\main\\java\\config\\config.properties");
			prop.load(read);
		}
		catch(FileNotFoundException exp)
		{
			exp.printStackTrace();
		}
		catch(IOException exp)
		{
			exp.printStackTrace();
		}
	}
	
	public void initialization()
	{
		String browser = prop.getProperty("browserName");
		if(browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser == "Firefox")
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser == "Edge")
		{
			WebDriverManager.edgedriver().setup();
			driver = new FirefoxDriver();
		}
	
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	
	}
	
}
