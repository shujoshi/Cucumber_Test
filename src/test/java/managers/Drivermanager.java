package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

public class Drivermanager {

	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		try {
		if(driver==null) {

			System.setProperty("webdriver.chrome.driver", (new File(System.getProperty("user.dir")+ "\\chromedriver.exe").getCanonicalPath()));
			
			
			ChromeOptions options = new ChromeOptions();
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
		   driver =new ChromeDriver(options);
		}
		
		
	}catch (IOException e) {
        e.printStackTrace();
    }
		return driver;
}
}