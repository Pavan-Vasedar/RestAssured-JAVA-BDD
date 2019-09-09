# RestAssured_JAVA_BDD
# Objective : 
Developed a simple framework which should support to develop automation test scripts for API services in Java. 

# Tools / libraries used :

1. Java
2. Rest Assured
3. Cucumber
4. JUnit
5. Maven

install eclipse-cucumber plugin in eclipse

# Steps to start :

1. Clone / Download the project into your local
2. Open the Command prompt and navigat to project location
3. Execute the following Maven command's
    - mvn clean :- To clean the maven repo
    - mvn install :- To install the maven requirments 
    - mvn test :- To execute the test scenarios

Report folder:
target -> cucumberHtmlReport -> index.html

Bugs identified:

only one legal entity is used: CS Zurich
---When legal entity attribute has other than 'CS Zurich' we get 200 success status

American option style will have in addition the exerciseStartDate, which has to be after the trade date but before the expiry date
----if style is American and when exerciseStartDate is not passed in the request payload. we get 200 success status


Requirement is not clear:
validate the value date against the product type.




