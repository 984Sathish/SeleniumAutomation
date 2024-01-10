package Selenium4;

import org.openqa.selenium.By;	
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlePopupByUrl {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Original url --> http://the-internet.herokuapp.com/
		
		//we can add username and password with this url, to by pass popup
		driver.get("http://admin:admin@the-internet.herokuapp.com/"); 
		driver.findElement(By.linkText("Basic Auth")).click();
		
		Thread.sleep(2000);
		String text = driver.findElement(By.tagName("p")).getText();
		if(text == "Congratulations! You must have the proper credentials.") {
			System.out.println("Verify text: "+text);
		}
		
		driver.close();
	}

}
