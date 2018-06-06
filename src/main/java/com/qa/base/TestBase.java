package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.util.WebEventListener;
import com.qa.util.testUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener listener;
	public TestBase() throws IOException {
		try {
		prop=new Properties();
		FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\config\\Config.properties");
		prop.load(fi);
	}catch(FileNotFoundException e) {
		e.printStackTrace();
		
	}catch(IOException e) {
		e.printStackTrace();
	}
	
	}
	public static void initialization() throws IOException {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",  "F:\\softwares\\Development tools\\android development tool\\eclipse\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Silpa\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Silpa\\Downloads\\Compressed\\IEDriverServer_x64_3.11.1\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		e_driver=new EventFiringWebDriver(driver);
		listener=new WebEventListener();
		e_driver.register(listener);
		driver=e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(testUtil.pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testUtil.implicitWait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}
