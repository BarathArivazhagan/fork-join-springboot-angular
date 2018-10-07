FROM openjdk:8-jdk-alpine as final
ADD target/bank-service-*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]