What is this repository for?
https://github.com/xuyenauto/automation-cucumber-rest_assured.git

Summary:
The framework using Cucumber + Selenium (Java) + Page Object Pattern + Rest-assured + Maven
to automate web application and api testing

Before run tests
 - Access to config.json file to setup something that you want automate
    + test_type: it should be ui for web application and api for api testing
    + browser: currently, it runs with chrome, but we can custom to support multiple browsers 
    by modify Hooks class
    + url: default url just in case using for web application
    + grid_hub: provide grid hub server if run tests on remote
    + time_out_second: time out wait for element

How to run tests
 - Prefer the APITest.feature file for example test scripts for api testing And Login.feature file for web application
 #