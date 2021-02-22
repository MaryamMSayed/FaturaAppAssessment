# FaturaAppAssessment
# Using Appium to Automate UI Testing of Fatura Egypt Android  App with Java
## Overview:
### What's in this repository?
**This repository contains a minimalistic Appium Test Suite written in Java that runs a few simple tests on the Fatura mentioned Android app .
To run the tests successfully you'll need have the .apk  file of the app either installed on your androi phone or have it as a seperate file .**
## System Requirements:
* Mac OSX or Windows or Linux
* Android SDK ≥ 16
## Set Up:
**Basically you need to have appium installed along . I won't go into a walkthrough of setting these up as there are plenty resources out there to guide you in setting up Appium. See below for a some helpful links to help you get appium installed.**
* http://appium.io/
* http://appium.io/slate/en/tutorial/android.html
## Running the tests:
**To run your tests simply you need to execute the following command from inside the project directory.**


{
mvn test
}

**You can also run all classes as a teng.suite by running the testng.xml file directley**
## Reporting Tool:
**I have added allure report you can see the results after running the project directly by opening the project in cmd and run { **allure serve** } command**
