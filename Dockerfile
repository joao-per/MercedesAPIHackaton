FROM maven:3.8.4-openjdk-20-slim AS builder

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn package -DskipTests


FROM adoptopenjdk:20-jre-hotspot

WORKDIR /app

COPY --from=builder /app/target/my-application.jar .

EXPOSE 80

CMD ["java", "-jar", "my-application.jar"]
