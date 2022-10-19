package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Drivermanager {

	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		try {
		if(driver==null) {

			System.setProperty("webdriver.chrome.driver", (new File(System.getProperty("user.dir")+ "\\chromedriver.exe").getCanonicalPath()));
			
			
			ChromeOptions options = new ChromeOptions();
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
		   driver =new ChromeDriver(options);
		 
//			DesiredCapabilities caps = new DesiredCapabilities();
//			caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");
//			
//		   driver = new RemoteWebDriver(new URL("http://192.168.1.12:4444"), caps);
		}
		
		
	}catch (IOException e) {
        e.printStackTrace();
    }
		return driver;
}
}