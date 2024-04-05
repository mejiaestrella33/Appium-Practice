package com.qa;

import com.qa.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class BaseTest {
	protected static AppiumDriver driver;
	protected static Properties props;
	
	public BaseTest(){
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

  @Parameters({"platformName", "platformVersion", "deviceName", "UDID", "avd"})
  @BeforeTest
  public void beforeTest(String platformName, String platformVersion, String deviceName, String UDID, String avd) throws Exception {
	  InputStream inputStream = null;
	  Properties props = new Properties();
	  
	  try {
		  props = new Properties();
		  String propFileName = "config.properties";
		  
		  inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		  props.load(inputStream);
		  
		  DesiredCapabilities caps = new DesiredCapabilities();
		  caps.setCapability("platformName", platformName);
		  caps.setCapability("platformName", platformVersion);
	      caps.setCapability("deviceName", deviceName);
	      caps.setCapability("UDID", UDID);
	      caps.setCapability("avd", avd);   
	      

	      caps.setCapability("automationName", props.getProperty("androidAutomationName"));
			/*
			 * caps.setCapability("appPackage", props.getProperty("androidAppPackage"));
			 * caps.setCapability("appActivity", props.getProperty("androidAppActivity"));
			 * caps.setCapability("app", props.getProperty("androidAppLocation"));
			 */
		  caps.setCapability("app", props.getProperty("androidAppXLocation"));      //App: App X
		     
		  
		  URL appUrl = getClass().getClassLoader().getResource(props.getProperty("androidAppLocation"));
		  caps.setCapability("app", appUrl);
			  
	      URL url = new URL(props.getProperty("appiumURL"));
	     
	      
	      driver = new AndroidDriver(url, caps);
	      //String sessionID = driver.getSessionId().toString();
	      
			//WebElement signinButton = (WebElement) driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"Log in here\"]")); signinButton.click();
			 
	  }catch(Exception e) {
		  e.printStackTrace();
		  throw e;
	  }
  }
	
	public void waitForVisibility(WebElement e) {
		WebDriverWait wait = new WebDriverWait((WebDriver) driver,Duration.ofSeconds(TestUtils.WAIT));
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void click(WebElement e) {
		waitForVisibility(e);
		e.click();
	}

	public void sendKeys(WebElement e, String txt) {
		waitForVisibility(e);
		e.sendKeys(txt);
	}
	
	public String getAttribute(WebElement e, String attribute) {
		waitForVisibility(e);
		return e.getAttribute(attribute);
	}

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
