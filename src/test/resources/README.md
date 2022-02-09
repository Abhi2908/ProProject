# Test Automation
This is a test project for SyndicationPro Service End to End testing
       
    									AUTOMATION INTRODUCTION
•Setup and Technology Used

•Usage Explained

•Steps to Execute

•Status Introduction

#                     Setup and Technology Used

This framework is keyword driven, based on Page Object Model. It is a design pattern to create object repository for web UI elements which have different page in SyndicationPro.web package like TestData, TestBase GetDriver, CommonUtils and config.properties which is build through maven utilities, to support all the jars used in project. I have defined all dependency in pom.xml which is at parent level. 

1.                 Java 8 (Java language)
2.                 TestNg 6.10 (Testing framework to execute test cases manually)
3.                 WebDriverManager 3.7.1 (Helps to execute and support every browser)
4.                 Java Faker 1.0.1 (To generates fake data)
5.				   Selenium Java 3.14.0 (Help to implementations webDriver) 
5.                 ExtentReports 2.41.2 (To create reporting chart)
6.                 Log 4J 1.2.17(to log the project)
7.                 ATUTestLib 5.5_BETA(To enable the recording and taking the screenshot before raising the bug)

For deployment, used maven tool. All the project dependencies are defined in the POM.xml of the project.

#Usage Explained

The automation framework is completely dynamic.

1.					All the common Java classes are placed in different packages and all are kept in src.main.java.
2.					All these classes to perform operation called as helper classes, which are defined in the SyndicationPro.helpers package.
3.					All these classes having object repository corresponding to the different pages, which are defined in the SyndicationPro.pages package.
4.					CommonUtils.java class contains all the methods such as scrollBy, click, click by action, sendkeys etc. And this class is defined in SyndicationPro.web package.
5.					GetDriver.java class is declaring the Webdriver interface which is implemented by respective driver class. And this class is defined in SyndicationPro.web package.
6.					TestBase.java class based on the type of the browser required to verify the test cases. And the class return the web driver of the browser like firefox, chrome etc. And this class is defined in SyndicationPro.web package.
7.					TestData.java contains the data which is using in every class. And this class is defined in SyndicationPro.web package.
8.					And, there is only one class (WebTest.web) for executing end to end test scenarios/cases on the basis of setting the testNG priority, which is defined in src.test.java under SyndicationPro.web package.
9.					There is a config.properties file. This file is loaded when the application bootstrap. This file contains all the key value pairs that I can change dynamically, which is under src.test.resources.
10.					The flow starts from testNg.xml. It connect chromeSuite.xml and firefoxSuite.xml, which is main test script class. The main test script class contains all the test suits and cases which are prioritize as per the sequence of execution.
11.					Once the test execution get finish, a report get generated for all to see what all test cases are passed. It will show the graphical presentation under test-output folder.
12.					If there is any bug encountered during the test execution, then the automation framework will create the video of that module and take the screen shot for the developer and present the same in the report. This feature can further be integrated with bug raising tool.
13.					The SyndicationProWeb project framework is designed in such a way that if tomorrow new browser is required then only the browser properties will add in TestBase.java class otherwise the entire code will remain same and untouchable.

#Steps to Execute
1.					Download the project in the suitable folder 
2.					Open the folder and navigate to that project folder where pom.xml lies. And use below commands to clean, compile and execute. 
  *mvn clean test -P Regression*
3.					To run the tests in the Maven lifecycle, import the project in tool like "Spring" and "Eclipse". Once the project is import, just right-click on the Project and select Run As | Maven test. Maven will execute test from the project.
4.					To run the tests from the testNG framework, Right-click on the *testNg.xml* and select Run As | TestNG test.

#Status Introduction


    S.No | Test Case Name|             Description                        |Status Result  |Browser
     --- | ------------  |    ------------------------------------        | ------------- | Chrome
       1 | TC-1          | ---------------------------------------------  | ------------- | Chrome
       1 | TC-2          | ---------------------------------------------  | ------------- | Chrome
       1 | TC-3          | ---------------------------------------------  | ------------- | Firefox
       1 | TC-4          | ---------------------------------------------  | ------------- | Firefox
       
       
