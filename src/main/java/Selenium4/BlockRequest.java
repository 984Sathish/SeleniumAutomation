package Selenium4;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.network.Network;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlockRequest {


	@Test
	public void BlockImageRequest() {

		//set headless
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);

		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		//network enable
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

		//block url
		devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg", "*.css")));

		driver.get("https://www.amazon.in/");

		devTools.disconnectSession();
		driver.quit();

	}

}
