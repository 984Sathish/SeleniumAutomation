package Selenium4;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

	@Test
	public void handleChildFrame() {

		//set headless
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.switchTo().newWindow(WindowType.WINDOW);      //new window open

		//getWindowHandles() --> get all window opening at the time.
		Set<String> windowSet = driver.getWindowHandles();

		//iterate windows set
		Iterator<String> windowsIterator = windowSet.iterator();

		String parentWindow = windowsIterator.next();

		String childWindow = windowsIterator.next();

		//switch to child window
		driver.switchTo().window(childWindow);

		driver.get("https://rahulshettyacademy.com/");

		String childWindowtitle = driver.getTitle();

		//switch to parent window
		driver.switchTo().window(parentWindow);

		driver.findElement(By.cssSelector("input[name='name']")).sendKeys(childWindowtitle);

		driver.quit();
	}

}
