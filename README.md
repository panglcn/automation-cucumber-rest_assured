What is this repository for?

Summary:
This framework using Cucumber + Selenium (Java) + Page Object Pattern + Rest-assured + Maven
to automate web application and api testing

Before run tests
 - Access to config.json file to setup something that you want automate
    + test_type: it should be ui for web application and api for api testing
    + url: default url just in case using for web application
    + grid_hub: provide grid hub server if run tests on remote
    + time_out_second: time out wait for element

How to run tests
 - Prefer the APITest.feature file for example test scripts for api testing And Login.feature file for web application
 #