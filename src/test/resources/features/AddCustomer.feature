@regression
Feature: Add customer details
Scenario: Add a new customer with valid details
    Given the user is logged into the application
    When the user navigates to the Add New Customer page
    And the user enters customer name as "Siva"
    And the user selects gender as "male"
    And the user enters date of birth as "10", "15", "1985"
    And the user enters address as "INDIA"
    And the user enters city as "HYD"
    And the user enters state as "AP"
    And the user enters pin number as "5000074"
    And the user enters telephone number as "987890091"
    And the user enters a unique email address
    And the user enters password as "abcdef"
    And the user submits the customer form
    Then the user should see a confirmation message "Customer Registered Successfully!!!"