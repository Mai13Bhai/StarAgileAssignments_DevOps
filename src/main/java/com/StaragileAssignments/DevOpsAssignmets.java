package com.StaragileAssignments;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DevOpsAssignmets {

	private WebDriver driver;
	private String baseUrl = "https://www.amazon.com/";

	public void setup(String browser)  {
		RemoteWebDriver driver = null;

		try {
			URI gridUri = new URI("http://localhost:4444/wd/hub");

			switch (browser.toLowerCase()) {
			case "chrome":
				ChromeOptions chromeOptions = new ChromeOptions();
				driver = new RemoteWebDriver(gridUri.toURL(), chromeOptions);
				break;
			case "firefox":
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				driver = new RemoteWebDriver(gridUri.toURL(), firefoxOptions);
				break;
			case "edge":
				EdgeOptions edgeOptions = new EdgeOptions();
				driver = new RemoteWebDriver(gridUri.toURL(), edgeOptions);
				break;
			default:
				throw new IllegalArgumentException("Browser parameter is invalid: " + browser);
			}
		} catch (URISyntaxException | MalformedURLException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to create RemoteWebDriver: " + e.getMessage());
		}

		this.driver = driver;
	}

	public void testAmazonHomePage(String Browser) {

		// Print browser name
		System.out.println("Running test on " + Browser);
		// Navigate to Amazon
		driver.get(baseUrl);

		// Perform actions (e.g., verify title)
		String title = driver.getTitle();
		System.out.println("Page title: " + title);

		// Example: Assert title contains "Amazon"
		if (!title.contains("Amazon")) {
			throw new AssertionError("Expected title to contain 'Amazon' but got: " + title);
		}
	}

	public void teardown() {
		// Quit the WebDriver instance
		if (driver != null) {
			driver.quit();
		}
	}

	public static void main(String[] args) throws MalformedURLException {
		DevOpsAssignmets amazonTest = new DevOpsAssignmets();

		// Test on Chrome
		amazonTest.setup("chrome");
		amazonTest.testAmazonHomePage("Chrome");
		amazonTest.teardown();

		// Test on Firefox
		amazonTest.setup("firefox");
		amazonTest.testAmazonHomePage("Firefox");
		amazonTest.teardown();

		// Test on Edge
		amazonTest.setup("edge");
		amazonTest.testAmazonHomePage("Edge");
		amazonTest.teardown();
	}
}