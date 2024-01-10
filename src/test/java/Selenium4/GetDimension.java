package Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetDimension {

	@Test
	public void getDimension() {

		//set headless
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		WebElement fldName = driver.findElement(By.cssSelector("input[name='name']"));

		//get height
		int heightOfElement = fldName.getRect().getDimension().getHeight();
		System.out.println("Height: "+heightOfElement);

		//get width
		int widthOfElement = fldName.getRect().getDimension().getWidth();
		System.out.println("Width: "+widthOfElement);

		driver.quit();
	}

}
