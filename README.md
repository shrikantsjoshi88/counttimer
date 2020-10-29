# counttimer

This is Selenium/Java POM Framework

I have used Maven Build tool which comes with a predefined folder structure as src>>main>>java and src>>test>>java
I have used TestNG Test runner with comes with predefined annotations to run the tests.
I have also created a suite file under src>>test>>Suitefiles
I have added all the Maven Dependencies to pom.xml

I have further created the following,

basepage Package with Base Page class - Here all the variables used throught the project are initialized - Under Src>>Main>>Java
commonactions Package with Common Actions class - Here all the common actions used throught the project are created in form of reusable methods Under Src>>Main>>Java
configuration Package with Configuration class, Listner, Retry and Transform class - Here the property file reading mechanism and retry failed test mechanism is taken care.
modulepages Package with Module class - Here the each individual page is maintained as a class, all the element identifiers and the methods are maintained here.
timeinfo Package with TimeInfo class - This is a pojo class with getters and setters.
Reports - I have used Allure reports for reporting and hence it can be accessed as allure serve <absolute pathname> (example - allure serve C:\eggtimer\allure-results)

Note : Tests can be run either by right clicking on the src>>test>>java>>TestTimer.java or by clicking the green Icon next to the method testCountdownTimer(). 
Additionally it can also be run through command line using mvn command and the suite file name.  mvn test -Dtest=TestTimer#testCountdownTimer
