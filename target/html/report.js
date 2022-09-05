$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/feature/Feature1.feature");
formatter.feature({
  "name": "Bidding Automation",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Login into Application",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Navigate to \u003cURL\u003e",
  "keyword": "Given "
});
formatter.step({
  "name": "Click on Login button",
  "keyword": "When "
});
formatter.step({
  "name": "Enter Email ID \u003cEmailID\u003e Password \u003cPassword\u003e and click on Login Button",
  "keyword": "And "
});
formatter.step({
  "name": "Click on View Results button for Auction ID \u003cAuctionID\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "Enter Bidding Amount",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "URL",
        "EmailID",
        "Password",
        "AuctionID"
      ]
    },
    {
      "cells": [
        "\"https://egold.auctiontiger.net/\"",
        "\"jimmy30678@yahoo.co.in\"",
        "\"qwer@123\"",
        "250575"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Login into Application",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Navigate to \"https://egold.auctiontiger.net/\"",
  "keyword": "Given "
});
formatter.match({
  "location": "stepdef.navigate_to(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Login button",
  "keyword": "When "
});
formatter.match({
  "location": "stepdef.click_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter Email ID \"jimmy30678@yahoo.co.in\" Password \"qwer@123\" and click on Login Button",
  "keyword": "And "
});
formatter.match({
  "location": "stepdef.enter_email_id_password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on View Results button for Auction ID 250575",
  "keyword": "When "
});
formatter.match({
  "location": "stepdef.click_view_result_button(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter Bidding Amount",
  "keyword": "And "
});
formatter.match({
  "location": "stepdef.enter_bidding_amount()"
});
formatter.result({
  "status": "passed"
});
});