package Miscellaneous;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {

	@Test
	public void brokenLink() throws MalformedURLException, IOException {

		//set headless
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");

		HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();  //open connection using java


		con.setRequestMethod("HEAD");  //HEAD request method to set

		con.connect();  //connect

		//Note:  get status code without opening the url.
		int responseCode = con.getResponseCode(); //get response code

		System.out.println(responseCode);


		//u can create all link in list and iterate. Then u get 404 status code.
		if(responseCode > 400) {

			System.out.println("This is broken link");
		}

		driver.close();





	}
}
