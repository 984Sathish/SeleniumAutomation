package Selenium4;

import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicAuthentication {

	@Test
	public void BasicAuth() {

		//set headless
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);

		//create Predicate URI
		Predicate<URI> uriPredicate = uri -> uri.getHost().contains("httpbin.org");

		//type username and password
		((HasAuthentication)driver).register(uriPredicate, UsernameAndPassword.of("foo", "bar"));

		driver.get("http://httpbin.org/basic-auth/foo/bar");

		driver.quit();
	}

}
