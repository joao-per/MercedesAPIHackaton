FROM maven:3.8.3-openjdk-17-slim AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-slim

WORKDIR /app

COPY --from=builder /app/target/my-application.jar .

EXPOSE 80

CMD ["java", "-jar", "my-application.jar"]

