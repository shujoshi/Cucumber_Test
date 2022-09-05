Feature: Bidding Automation

Scenario Outline: Login into Application 
	Given Navigate to <URL>
	When Click on Login button 
	And Enter Email ID <EmailID> Password <Password> and click on Login Button
	When Click on View Results button for Auction ID <AuctionID>
	And Enter Bidding Amount
	
	Examples:
	| URL                               | EmailID                  | Password   | AuctionID |
	| "https://egold.auctiontiger.net/" | "jimmy30678@yahoo.co.in" | "qwer@123" | 250575    |

