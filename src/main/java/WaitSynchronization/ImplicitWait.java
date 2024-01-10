package WaitSynchronization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	@Test
	public void implicitWait() {

		//set headless
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		

		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//Driver wait 10 seconds to element present.
		//dynamically wait for the element present
		//one time global declaration is enough. It will use all test cases.

		driver.close();
	}
}
