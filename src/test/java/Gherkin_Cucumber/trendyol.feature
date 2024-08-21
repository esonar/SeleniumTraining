Feature: Login functionality on Trendyol

  Scenario: Verify successful login after trying with valid user credentials
    Given user is on the login page
    When user enters valid username and password
    Then user should see the homepage

  Scenario: Verify error message is shown after trying with invalid username
    Given user is on the login page
    When user enters invalid username and valid password
    Then user should see an error message

  Scenario: Verify Searching for a “Telefon” Item
    Given user is logged in
    When user searches for "Telefon" item
    Then user should see a list of "Telefon" items

  Scenario: Verify the number results of "Telefon" items
    Given user has searched for "Telefon"
    Then user should see a total count of the "Telefon" items

  Scenario: Verify Adding one of the "Telefon" Item to the Cart and the number of the items in the cart
    Given user is viewing the search results for "Telefon"
    When user adds one "Telefon" item to the cart
    Then user should see that the item is added to the cart
    Then user should see the correct number of items (1) in the cart