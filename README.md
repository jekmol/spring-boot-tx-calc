# spring-boot-tx-calc

Spring Boot Tax Calculator

### Prerequisites
```
This application is developed with Spring Boot Java and Postgres as the database. It is also available to run with docker, please make sure you have docker and docker-compose installed on your pc.
 
System Requirements:
1. Java 1.8
2. PostgreSQL
3. Maven
4. Apache Tomcat
```

## Unit Test
```
Run unit test using JUnit, /spring-boot-tax-calculator/src/test/java/com/tax/calculator/BillTest.java
```

## API Documentation
```
http://localhost:8080/bill/swagger-ui.html

| ***Endpoints*** | ***Method*** | ***Description*** |
|-----------------|:------------:|-------------------|
|`/getbills`          | `GET`        | Get bill info (product and tax) stored in DB |
|`/addbill`          | `POST`       | Save bill into DB |
```

## Deployment
```
- Clone the project
- Create spring-boot-tax-calculator.jar file
- Build docker image: docker build -f Dockerfile -t spring-boot-tax-calculator .
- Run by typing docker-compose up -d
- App now run on localhost:8080
```
