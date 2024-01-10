package Selenium4;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CDPCommandTest {

	@Test
	public void SetEmulation() throws InterruptedException {

		//Note: To get selenium dev tool details -> https://chromedevtools.github.io/devtools-protocol/ 

		//set headless
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		DevTools devTools = driver.getDevTools();

		devTools.createSession();

		Map<String, Object> map = new HashedMap<String, Object>();
		map.put("width", 600);
		map.put("height", 1000);
		map.put("deviceScaleFactor", 50);
		map.put("mobile", true);


		//execute custom cdp command without sending
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", map);

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("[aria-label='Toggle navigation']")).click();
		Thread.sleep(3000);

		driver.findElement(By.linkText("Library")).click();

		devTools.disconnectSession();
		driver.close();
	}

}
