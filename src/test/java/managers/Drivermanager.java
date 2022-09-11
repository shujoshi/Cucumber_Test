package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;

public class Drivermanager {

	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		try {
		if(driver==null) {

			System.setProperty("webdriver.chrome.driver", (new File(System.getProperty("user.dir")+ "\\chromedriver.exe").getCanonicalPath()));
			
		   driver =new ChromeDriver();
		}
		
		
	}catch (IOException e) {
        e.printStackTrace();
    }
		return driver;
}
}