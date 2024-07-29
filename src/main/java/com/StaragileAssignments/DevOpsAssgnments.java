package com.StaragileAssignments;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
public class DevOpsAssgnments {

	public static final String GRID_URL = "http://localhost:4444/wd/hub";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 // Define desired capabilities
        DesiredCapabilities capabilities;

        // Chrome
        ChromeOptions chromeOptions = new ChromeOptions();
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        WebDriver driver = new RemoteWebDriver(new URL(GRID_URL), capabilities);
        runTest(driver, "Chrome");

        // Firefox
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
        driver = new RemoteWebDriver(new URL(GRID_URL), capabilities);
        runTest(driver, "Firefox");

        // Edge
        EdgeOptions edgeOptions = new EdgeOptions();
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(EdgeOptions.CAPABILITY, edgeOptions);
        driver = new RemoteWebDriver(new URL(GRID_URL), capabilities);
        runTest(driver, "Edge");

        // Quit all drivers
        driver.quit();

	}
	 public static void runTest(WebDriver driver, String browserName) {
	        driver.get("https://www.amazon.com/");
	        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
	        searchBox.sendKeys("Selenium WebDriver");
	        searchBox.submit();
	        System.out.println("Title of the page using " + browserName + ": " + driver.getTitle());
	    }

}
