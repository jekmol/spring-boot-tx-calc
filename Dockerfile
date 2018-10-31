FROM openjdk:8
MAINTAINER jakamaulana

ADD target/spring-boot-tax-calculator.jar spring-boot-tax-calculator.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-boot-tax-calculator.jar"]
