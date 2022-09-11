@test
Feature: Auction

  Scenario Outline: Login into Application
    Given Navigate to <URL>
    When Click on Login button
    And Enter Email ID <EmailID> Password <Password> and click on Login Button

    Examples: 
      | URL                                             | EmailID                  | Password    |
      | "https://jewel-auction.procuretiger.com/JEWEL/" | "jimmy30678@yahoo.co.in" | "icici@123" |

  Scenario Outline: Test
    When Click on View Results button for Auction ID <AuctionID>
    #When Click on Manual bid button for Auction ID <AuctionID>
    And Enter Bidding Amount start from Sr No <SrNO> for row count <rowCount> run loop for <DurationInMinute> add additional amount <AdditionalAmount> and submit <Bidding>

    Examples: 
      | AuctionID | SrNO | rowCount | DurationInMinute | AdditionalAmount | Bidding |
      |      5759 |    1 |        5 |                1 |               10 | "No"    |
