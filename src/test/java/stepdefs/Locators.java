package stepdefs;

public class Locators {
	
	String LoginButton = "//a[@id='loginLink']";
	
	String EmailInputField = "//input[@id='j_username']";
	
	String PasswordInputField = "//input[@id='j_password']";
	
	String LoginButtonPopUp = "//button[@name='btnlogin']";
	
	String AuctionIDText = "//*[@id=\"reportDetail\"]/tr/td[2]/div/p/b[text()='Auction ID:']";
	
	String viewResults = "(//a[text()='View result'])[1]";
	
	String yourRank = "//span[contains(@id,'bidRank')]";
	
	String yourRankDynamic = "(//span[contains(@id,'bidRank')])[index]";
	
	String nextPossibleBidAmount = "//span[contains(@id,'netBidAmt')]";
	
	String bidButton = "//button[text()='Bid']";
	
	String popYes = "//span[@id='popup_ok']";
	
	String popNo = "//span[@id='popup_cancel']']";
}
