package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Drivermanager {

	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		if(driver==null) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Shubham\\eclipse-workspace\\Cucumber_Parallel\\chromedriver.exe");
		   
		   driver =new ChromeDriver();
		}
		return driver;
	}
}
