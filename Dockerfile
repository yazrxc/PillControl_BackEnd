# Etapa 1: Compilación
FROM maven:3.9.6-eclipse-temurin-17-alpine as builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final
FROM amazoncorretto:17-alpine-jdk
COPY --from=builder /app/target/demoPillControl-0.0.1-SNAPSHOT.jar /api-v1.jar
ENTRYPOINT ["java", "-jar", "/api-v1.jar"]
