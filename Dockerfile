# First stage: Build the app
FROM maven:3.8.5-openjdk-17-slim AS builder
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests

# Second stage: Run the app
FROM openjdk:17-jdk-slim
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
