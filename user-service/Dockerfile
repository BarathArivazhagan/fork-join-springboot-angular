FROM openjdk:8-jdk-alpine as final
ADD target/user-service-*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]