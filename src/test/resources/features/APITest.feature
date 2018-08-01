Feature: API test

  Using website http://restapi.demoqa.com/utilities/weather/city/<City> for api testing

  Background:
    Given user has the api to check the weather conditions as "http://restapi.demoqa.com/utilities/weather/city/"

  Scenario: AT_001_Verify user can get the weather conditions for specific city
    When user send request for city "Hanoi"
    Then user should get response status code is 200
    And user should see city as "Hanoi"

  Scenario: AT_002_Verify user can not get the weather conditions when input wrong city
    When user send request for city "Campuchia"
    Then user should get response status code is 400
    And user should see error message is "An internal error occured while servicing the request"