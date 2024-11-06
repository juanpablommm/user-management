FROM openjdk:17-jdk-slim

ARG VERSION="latest"

LABEL authors="juanpablo montoya opsinal" version=${VERSION} description="Microservice in charge of managing and authenticating users for e-commerce"

ENV APP_ENV=DEV

EXPOSE 8080

WORKDIR /app

COPY build/libs/user-management-1.4.0.jar .

ENTRYPOINT ["java", "-jar", "/app/user-management-1.4.0.jar", "--spring.profiles.active=local"]
