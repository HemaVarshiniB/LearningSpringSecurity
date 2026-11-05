FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /workspace

COPY . .
RUN bash ./mvnw --batch-mode --no-transfer-progress -DskipTests package

FROM eclipse-temurin:17-jre

WORKDIR /app
RUN useradd --system --uid 10001 appuser
COPY --from=build --chown=10001:10001 /workspace/target/*.jar /app/app.jar

USER 10001:10001
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
