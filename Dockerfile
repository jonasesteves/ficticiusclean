FROM maven:3.8.5-jdk-8 as build
WORKDIR /build
COPY . .
RUN mvn clean package

FROM openjdk:8
WORKDIR /app
COPY --from=build ./build/target/*.jar ./application.jar
EXPOSE 8080

ENTRYPOINT java -jar application.jar