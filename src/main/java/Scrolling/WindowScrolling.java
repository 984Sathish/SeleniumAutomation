package Scrolling;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowScrolling {

	@Test
	public void scrolling() {

		//set headless
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		JavascriptExecutor js = (JavascriptExecutor) driver;

		//window scrolling
		js.executeScript("window.scrollBy(0, 500)");


		//element scrolling
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
	}

}
