FROM openjdk:8-jdk-alpine as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
COPY target target

RUN ./mvnw install -DskipTests

COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
