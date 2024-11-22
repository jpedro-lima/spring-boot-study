# Etapa 1: Build
FROM maven:3.8.6 AS build

WORKDIR /app/study-spring-boot

COPY ./study-spring-boot/pom.xml ./

COPY ./study-spring-boot/src ./src

RUN	mvn dependency:resolve dependency:resolve-plugins \
	&& mvn clean package -DskipTests

FROM openjdk:17-slim

EXPOSE 8000

WORKDIR /app

COPY --from=build /app/study-spring-boot/target/study-spring-boot-0.0.1-SNAPSHOT.jar /spring-boot-study.jar

ENTRYPOINT ["java", "-jar", "/spring-boot-study.jar"]
