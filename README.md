#Automation-Cucumber-rest-assured

The framework using Cucumber + Selenium (Java) + Page Object Patternn (include page factory) + Rest-assured + Maven
to automate web application and api testing

--What is this repository for?
https://github.com/xuyenauto/automation-cucumber-rest_assured.git

--Configuration
 - Install Java 8 version
 - Install an IDE (Eclipse| IntelliJ)
 - Install Cucumber plugin in your installed IDE
 - Install Maven 3 version at least (I'm using version 3.3.9)
 - git clone https://github.com/xuyenauto/automation-cucumber-rest_assured.git
 - Import the project in your installed IDE
 - run maven to download dependencies by command mvn test

--Before run tests
 - Access to config.json file to setup something that you want automate
    + test_type: it should be ui for web application and api for api testing
    + browser: currently, it runs with chrome browser as default, but we can custom to support multiple browsers
    by modify Hooks class
    + remote: no if run on local and yes if run on remote
    + url: default url just in case using for web application
    + grid_hub: provide grid hub server if run tests on remote
    + time_out_second: time out wait for element

--How to run tests
 - Prefer the APITest.feature file for example test scripts for api testing And Login.feature file for web application
 - right click and run scenario what you want

--Contact Information
If any idea/feedback please mail to khacxuyenit@gmail.com