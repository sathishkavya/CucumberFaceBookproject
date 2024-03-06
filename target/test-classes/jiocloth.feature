Feature: Ajio Mens and Womens Clothing

Background: Ajio Launching Function
Given Launch the Ajio "https://www.ajio.com/" 
When Navigate to mens and click on clothing 

@Lowest
Scenario: Mens Clothing Sorting with Lowest Price
When User clicks on sort dropdown and selects Lowest price in the dropdown
Then Validate the price sorter based on lowest price

@Highest
Scenario: Mens Clothing Sorting with Highest Price
When User clicks on sort dropdown and selects Highest price in the dropdown
Then Validate the price sorter based on Highest price

@Ratings
Scenario: Mens Clothing Sorting with Ratings Price
When User clicks on sort dropdown and selects Ratings price in the dropdown
Then Validate the price sorter based on Ratings price


Scenario:Womens Clothing Sorting 
When Navigate to Womens and click on clothing

