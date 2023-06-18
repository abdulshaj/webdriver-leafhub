package com.framework.selenium.api.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import com.framework.config.ConfigurationManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.testng.AbstractTestNGCucumberTests;

public class DriverInstance  extends AbstractTestNGCucumberTests{

	private static final ThreadLocal<RemoteWebDriver> remoteWebdriver = new ThreadLocal<RemoteWebDriver>();
	private static final ThreadLocal<WebDriverWait> wait = new  ThreadLocal<WebDriverWait>();

	public void setWait() {
		//System.out.println("");
		wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(30)));
	}

	public WebDriverWait getWait() {
		return wait.get();
	}

	public void setDriver(String browser, boolean headless) throws MalformedURLException {

		String gridUrl = ConfigurationManager.configuration().gridUrl();

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName ("chrome") ;



		switch (browser) {
		case "chrome":
			ChromeOptions chrome_options = new ChromeOptions();
			chrome_options.addArguments("--start-maximized"); 
			chrome_options.addArguments("--disable-notifications"); 
			//remoteWebdriver.set(new ChromeDriver(chrome_options));
			//new URL(gridUrl),chrome_options));
			remoteWebdriver.set(new RemoteWebDriver(new URL(gridUrl),chrome_options));
			//remoteWebdriver.set(new URL(gridUrl),chrome_options));
			break;

		case "firefox":
			FirefoxOptions firefox_options = new FirefoxOptions();
			firefox_options.addArguments("--no-sandbox");
			firefox_options.addArguments("--disable-dev-shm-usage"); 
			//remoteWebdriver.set(new FirefoxDriver(firefox_options));
			remoteWebdriver.set(new RemoteWebDriver(new URL(gridUrl),firefox_options));
			break;
		case "msEdge":
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--no-sandbox");
			edgeOptions.addArguments("--disable-dev-shm-usage");
			//remoteWebdriver.set(new FirefoxDriver(firefox_options));
			remoteWebdriver.set(new RemoteWebDriver(new URL(gridUrl),edgeOptions));
			break;

		default:
			break;
		}
	}
	public RemoteWebDriver getDriver() {
		return remoteWebdriver.get();
	}
	
}
