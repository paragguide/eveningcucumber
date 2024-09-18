Feature: Amazon Login and Shopping Document
  I want to use this feature file to write different scenarios

    @amazon @uid
    Scenario: Validate userid
    Given I open browser "chrome" with url "https://www.amazon.in" and init report "AmazonLogin" with testname "Login"
    And click signin link
    When i enter valid userid "paragguide@yahoo.co.in"
    And click continue button
    Then I error should not come
    
    @amazon @pwd
    Scenario: Validate password
     Given userid is valid
     When now enter valid password "RMinfotech12#&&"
     Then i should login
    
    @amazon @search
    Scenario Outline:  Search products
      Given i am logged in
      When i search for product <product> in price <price>
      Then i should get results
    
    @data1
    Examples:
    | product | price |
    | shirt | 500 |
    | pant | 1500 |
    | coat | 3000 |
    
    @data2
    Examples:
    | product | price |
    | LCD | 20000|
    | Mobile | 6000 |
    | Laptop | 34000|
      
     @amazon @forget
     Scenario: forget password 
      Given launch "chrome" with url "https://www.amazon.in" and init report "ForgetReport" testname "Forget"
      And clickon signin button
      When i click on help link and forget link
      And enter mobile number
      Then send OTP
  
    @close
     Scenario: close browser
     Then close browser
