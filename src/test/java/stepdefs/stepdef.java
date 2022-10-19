package stepdefs;


import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class stepdef {
	public static WebDriver driver = Hooks.driver;

	Locators locator = new Locators();

	@Given("Navigate to {string}")
	public void navigate_to(String string) {
		try {
			driver.get(string);
			driver.switchTo().alert().accept();

			driver.manage().window().maximize();
		} catch (Exception NoAlertPresentException) {

			driver.manage().window().maximize();
		}
	}

	@When("Click on Login button")
	public void click_login_button() {
		try {
			driver.findElement(By.xpath(locator.LoginButton)).click();	
		}catch(Exception e) {
			System.out.println("Failed due to + " + e);
		}

		

	}

	@When("Enter Email ID {string} Password {string} and click on Login Button")
	public void enter_email_id_password(String arg1, String arg2) {

		try {
			driver.findElement(By.xpath(locator.EmailInputField)).sendKeys(arg1);

			driver.findElement(By.xpath(locator.PasswordInputField)).sendKeys(arg2);

			driver.findElement(By.xpath(locator.LoginButtonPopUp)).click();

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			List<WebElement> popUp = driver.findElements(By.xpath(locator.popYes));

			if (popUp.size() > 0) {
				driver.findElement(By.xpath(locator.popYes)).click();
			}	
		}catch(Exception e) {
			System.out.println("Failed due to + " + e);
		}
		
		
		
	}

	@When("Get Auction IDs")
	public void get_Auction_ID() {

		try {
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

			List<WebElement> paraList = driver.findElements(By.xpath("//*[@id='reportDetail']/tr/td[2]/div/p"));

			for (int i = 1; i <= paraList.size(); i++) {

				String paragraph = driver.findElement(By.xpath("(//*[@id='reportDetail']/tr/td[2]/div/p)[" + i + "]"))
						.getText();

				String[] paragraphArray = paragraph.split("Auction ID: ");

				String[] stringArray = paragraphArray[1].split("\n");

				String auctionID = stringArray[0];

				System.out.println("auctionID is: " + auctionID);
			}	
		}catch(Exception e) {
			System.out.println("Failed due to + " + e);
		}
		
		

	}

	@When("Click on View Results button for Auction ID {int}")
	public void click_view_result_button(Integer auctionID) {
		try {

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='reportDetail']/tr/td[2]/div/p")));

		List<WebElement> paraList = driver.findElements(By.xpath("//*[@id='reportDetail']/tr/td[2]/div/p"));

		for (int i = 1; i <= paraList.size(); i++) {

			String paragraph = driver.findElement(By.xpath("(//*[@id='reportDetail']/tr/td[2]/div/p)[" + i + "]"))
					.getText();

			String[] paragraphArray = paragraph.split("Auction ID: ");

			String[] stringArray = paragraphArray[1].split("\n");

			String auctionIDAct = stringArray[0];

			System.out.println("auctionIDAct is: " + auctionIDAct);

			if (auctionIDAct.equals(auctionID.toString())) {
				driver.findElement(By.xpath("(//a[text()='View result'])[" + i + "]")).click();
				break;
			}
		}
		}catch(Exception e) {
			System.out.println("Failed due to " + e);
		}
	}

	@When("Click on Manual bid button for Auction ID {int}")
	public void click_manual_bid_button(Integer auctionID) {
try {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='reportDetail']/tr/td[2]/div/p")));

		List<WebElement> paraList = driver.findElements(By.xpath("//*[@id='reportDetail']/tr/td[2]/div/p"));

		for (int i = 1; i <= paraList.size(); i++) {

			String paragraph = driver.findElement(By.xpath("(//*[@id='reportDetail']/tr/td[2]/div/p)[" + i + "]"))
					.getText();

			String[] paragraphArray = paragraph.split("Auction ID: ");

			String[] stringArray = paragraphArray[1].split("\n");

			String auctionIDAct = stringArray[0];

			System.out.println("auctionIDAct is: " + auctionIDAct);

			if (auctionIDAct.equals(auctionID.toString())) {
				driver.findElement(By.xpath("(//a[text()='Manual bid'])[" + i + "]")).click();
				break;
			}
		}
}catch(Exception e) {
	System.out.println("Failed due to " + e);
}
	}

	// @When("Enter Bidding Amount start from Sr No {int} for row count {int}")
	// public void enter_bidding_amount(Integer arg1, Integer arg2) {
	//
	// WebDriverWait wait = new WebDriverWait(driver, 20);
	//
	// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator.yourRank)));
	// List<WebElement> weList = driver.findElements(By.xpath(locator.yourRank));
	//
	// System.out.println("weList is: " + weList.size());
	// long endTime = System.nanoTime() +
	// TimeUnit.NANOSECONDS.convert(arg1.longValue(), TimeUnit.MINUTES);
	// while (System.nanoTime() < endTime) {
	// int i = arg1;
	// for (i = arg1; i < (arg1 + arg2); i++) {
	//
	// String rank =
	// driver.findElement(By.xpath("(//span[contains(@id,'bidRank')])[" + i +
	// "]")).getText();
	// Integer intRank = 0;
	// if (rank.equals("Not bidded")) {
	// intRank = 2;
	// } else {
	// intRank = Integer.valueOf(rank);
	// }
	// if (intRank > 1) {
	//
	// String amount =
	// driver.findElement(By.xpath("(//span[contains(@id,'netBidAmt')])[" + i +
	// "]"))
	// .getText();
	//
	// Double intAmount = Double.valueOf(amount);
	//
	// Double increasedAmount = intAmount + 10;
	//
	// driver.findElement(By.xpath("(//td[@class='a-center biddercell']/input)[" + i
	// + "]")).clear();
	//
	// driver.findElement(By.xpath("(//td[@class='a-center biddercell']/input)[" + i
	// + "]"))
	// .sendKeys(increasedAmount.toString());
	//
	//// driver.findElement(By.xpath("(//button[text()='Bid'])[" + i +
	// "]")).click();
	////
	//// driver.findElement(By.xpath(locator.popYes));
	//
	// System.out.println("Rank is: " + intRank + " and amount is: " + amount);
	// }
	//
	// }
	//
	// }
	// }

	@When("Enter Bidding Amount start from Sr No {int} for row count {int} run loop for {int} add additional amount {int} and submit {string}")
	public void enter_bidding_amount_with_Parameters(Integer arg1, Integer arg2, Integer arg3, Integer arg4, String arg5) {

		try {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator.yourRank)));
		List<WebElement> weList = driver.findElements(By.xpath(locator.yourRank));

		System.out.println("weList is: " + weList.size());
		long endTime = System.nanoTime() + TimeUnit.NANOSECONDS.convert(arg3.longValue(), TimeUnit.MINUTES);
		while (System.nanoTime() < endTime) {
			int i = arg1;
			for (i = arg1; i < (arg1 + arg2); i++) {

				String rank = driver.findElement(By.xpath("(//span[contains(@id,'bidRank')])[" + i + "]")).getText();
				System.out.println("rank is: " + rank + " i values is: " + i);
				Integer intRank = 0;
				if (rank.equals("Not bidded")) {
					intRank = 2;
				} else {
					intRank = Integer.valueOf(rank);
				}
				if (intRank > 1) {

					String amount = driver.findElement(By.xpath("(//span[contains(@id,'netBidAmt')])[" + i + "]"))
							.getText();

					Double intAmount = Double.valueOf(amount);

					Double increasedAmount = intAmount + arg4;

					driver.findElement(By.xpath("(//td[@class='a-center biddercell']/input)[" + i + "]")).clear();

					driver.findElement(By.xpath("(//td[@class='a-center biddercell']/input)[" + i + "]"))
							.sendKeys(increasedAmount.toString());

					if (arg5.equals("Yes") ) {
						 driver.findElement(By.xpath("(//button[text()='Bid'])[" + i + "]")).click();
						
						 driver.findElement(By.xpath(locator.popYes)).click();

						 driver.findElement(By.xpath(locator.popYes)).click();

					}
					System.out.println("Rank is: " + intRank + " and amount is: " + amount);
				}

			}
		}
		}catch(Exception e) {
			System.out.println("Failed due to " + e);
		}
	}

	@When("Check Bidding Amount with Max Amount start from Sr No {int} for row count {int} run loop for {int} add additional amount {int} and submit {string}")
	public void Check_enter_bidding_amount_with_Parameters(Integer arg1, Integer arg2, Integer arg3, Integer arg4, String arg5) throws IOException, ParseException, InterruptedException {
try {

		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator.yourRank)));
		List<WebElement> weList = driver.findElements(By.xpath(locator.yourRank));

		System.out.println("weList is: " + weList.size());
		long endTime = System.nanoTime() + TimeUnit.NANOSECONDS.convert(arg3.longValue(), TimeUnit.MINUTES);
		while (System.nanoTime() < endTime) {
			int i = arg1;
			for (i = arg1; i < (arg1 + arg2); i++) {

				String rank = driver.findElement(By.xpath("(//span[contains(@id,'bidRank')])[" + i + "]")).getText();
				System.out.println("rank is: " + rank + " i values is: " + i);
				Integer intRank = 0;
				if (rank.equals("Not bidded")) {
					intRank = 2;
				} else {
					intRank = Integer.valueOf(rank);
				}
				if (intRank > 1) {

					JSONParser jsonParser = new JSONParser();
					FileReader fileReader = new FileReader(".\\src\\test\\java\\AmountJson\\MaxAmount.json");
					Object obj = jsonParser.parse(fileReader);
					JSONObject amtObj = (JSONObject)obj;
					int maxAmt =  (int) (long) amtObj.get("" + i + "");
					
				//	double maxAmt =  (double) (long) amtObj.get(i);
					
					String amount = driver.findElement(By.xpath("(//span[contains(@id,'netBidAmt')])[" + i + "]"))
							.getText();

					Double intAmount = Double.valueOf(amount);

		
					
					if(intAmount<=maxAmt) {

						Double increasedAmount = intAmount + arg4;
					driver.findElement(By.xpath("(//td[@class='a-center biddercell']/input)[" + i + "]")).clear();

					driver.findElement(By.xpath("(//td[@class='a-center biddercell']/input)[" + i + "]"))
							.sendKeys(increasedAmount.toString());

					if (arg5.equals("Yes") ) {
						 driver.findElement(By.xpath("(//button[text()='Bid'])[" + i + "]")).click();
						
						 driver.findElement(By.xpath(locator.popYes)).click();

						 driver.findElement(By.xpath(locator.popYes)).click();

					}
					}
					System.out.println("Rank is: " + intRank + " and amount is: " + amount);
				}

			}

		}
	}catch(Exception e) {
		System.out.println("Failed due to " + e);
	}
	}
	
}
