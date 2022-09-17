package stepdefs;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import managers.Drivermanager;

public class Hooks {
	public static WebDriver driver;
	@Before
  public void setup() {
		
		
	   driver = Drivermanager.getDriver();
  }

}
