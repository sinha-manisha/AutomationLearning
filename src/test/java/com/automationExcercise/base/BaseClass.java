package com.automationExcercise.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.automationExercise.utilities.ReadConfig;
import com.google.common.io.Files;


public class BaseClass {
	
	public static WebDriver driver;
	public static Logger Log;
	ReadConfig config=new ReadConfig();
	
	public String baseUrl=config.getURL();
	public String homeTitle=config.getHomeTitle();
	public String signupText=config.getSignUpText();
	public String signupForm=config.getSignUpForm();
	public String accountCreated=config.getAccountCreated();
	public String accountDeleted=config.getAccountDeleted();
	public String loginText=config.getLoginText();
	public String contactUsText=config.getContactUsText(); 
	public String testPageTitle=config.getTestPageTitle();
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br)
	{
		switch(br)
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver", config.getChromePath());
			ChromeOptions options =new ChromeOptions();
			String downloadFile=System.getProperty("user.dir") + File.separator + "DownloadFile";
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFile);
			//options.addExtensions(new File(".//Extensions/extension_3_17_1_0.crx"));
			options.setExperimentalOption("prefs",chromePrefs);
			driver=new ChromeDriver(options);
//			driver=new ChromeDriver();
			break;
		case "gecko":
			System.setProperty("webdriver.gecko.driver", config.getFireFoxPath());
			driver=new FirefoxDriver();
			break;
		}
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Log=LogManager.getLogger(BaseClass.class);
		Log.info("Launched the "+br+" browser");
		
	}
	public void captureScreenshot(String testFolder,String testName)
	{
		String timeStamp=LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss"));
		TakesScreenshot ts =(TakesScreenshot)driver;
		byte[] srcFile=ts.getScreenshotAs(OutputType.BYTES);
		File destFile= new File(".//ScreenShots/"+testFolder+"/"+testName+timeStamp+".png");
		try {
			Files.write(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("Screen shot taken");
		Log.info("Screenshot taken for "+testName);
	}
	@AfterClass
	public void teardown() {
		driver.quit();
		Log.info("Quit the driver");
	}
	
	public String randomstring()
	{
		String str=RandomStringUtils.randomAlphabetic(12);
		return str;
	}
	public void scrollToElement(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element );
	}
	public void waitForWebElement(WebElement ele)
	{
	WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(2000));
    w.until(ExpectedConditions.visibilityOf(ele));
	}
	public void waitForWebElementToCilckable(WebElement ele)
	{
	WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(2000));
    w.until(ExpectedConditions.elementToBeClickable(ele));
	}
	

}
