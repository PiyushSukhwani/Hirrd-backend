FROM maven:3.9.9-eclipse-temurin-22 AS build
COPY . . 
RUN mvn clean package -DskipTests

FROM openjdk:22.0.2-jdk-slim
COPY --from=build /target/Hirrd-0.0.1-SNAPSHOT.jar  Hirrd.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","Hirrd.jar"]