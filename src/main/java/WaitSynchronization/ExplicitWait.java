package WaitSynchronization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {
	
	@Test
	public void explicitWait() {

		//set headless
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		
		//declare web driver wait to 5 sec
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		//driver will wait until 5 sec once the element have visibility.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#start button")));
		
		driver.quit();
	}

}
