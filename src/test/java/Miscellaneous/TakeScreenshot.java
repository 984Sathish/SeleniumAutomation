package Miscellaneous;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.operator.OutputAEADEncryptor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshot {

	
	@Test
	public void getScreenshot() throws IOException {

		//set headless
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//get screenshot
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		//declare screenshot directory
		FileUtils.copyFile(file, new File("C://Users//sathish.suresh//screenshot.png"));
	}
}
