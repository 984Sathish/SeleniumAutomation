package Selenium4;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetConsoleLogs {

	@Test
	public void getConsoleLogs() throws InterruptedException {

		//set headless
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);

		//get console logs
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> logList = logEntries.getAll();

		for(LogEntry log: logList) {
			System.out.println(log.getMessage());
		}

		driver.close();
	}

}
