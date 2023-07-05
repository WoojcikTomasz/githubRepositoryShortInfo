Github Repository Short Info

## Description:
REST service which returns short details of given Github repository.
● full name of repository
● description of repository
● git clone url
● number of stargazers
● date of creation formatted in requesters local date format

## Running service:
Run 'mvn clean install' to start service
To build application run command *mvn clean install* from root directory of project.
Project runs on port 8081 and provides one endpoint for HTTP GET method.
Example of usage: 
http://localhost:8081/repositories/{owner}/{repositoryname}

## Used technologies:
● Java 17
● Spring Boot 3
