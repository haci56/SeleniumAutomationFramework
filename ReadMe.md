Content of the Project

This project is an example project for Selenium training.

You can find how to success parallel execution with POM pattern.

Tools and Technologies :

Selenium WebDriver, Cucumber, JUnit, TestNG, Java , Extent Spark Report

Patterns :

OOP and POM pattern was used

Prerequest :

Java8 JDK

https://www.oracle.com/tr/java/technologies/javase/javase-jdk8-downloads.html


How to execute tests :


Open terminal and type below command.

-DbrowserName="value"

You can use chrome, firefox or safari as browserName value

-Dcucumber.filter.tags="@value"

You can filter your scenarios or features also by using cucumber tags. Using tag is optional.

mvn clean test -DbrowserName="value" -Dcucumber.filter.tags="@value"

Reporting

You will have 2 reports after execution is completed.

ExtentPdf.pdf

available at below directory

SeleniumAutomationFramework/test output/PdfReport/ExtentPdf.pdf

Extended-Spark-Report

available at below directory

SeleniumAutomationFramework/test-output/SparkReport/Index.html




