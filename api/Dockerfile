FROM maven:3.8.6-amazoncorretto-17 as build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-ea-10-jdk-slim
COPY --from=build /target/*.jar ./api.jar
ENTRYPOINT java -jar api.jar