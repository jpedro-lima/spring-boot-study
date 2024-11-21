# FROM openjdk:17-slim

# EXPOSE 8000

# WORKDIR /app/study-spring-boot

# COPY ./study-spring-boot .

# RUN	./mvnw clean install -DskipTests \
# 	&& ./mvnw dependency:resolve

# ENTRYPOINT ["./mvnw", "spring-boot:run", "-X"]

FROM maven:3.8.6 AS build

WORKDIR /app/study-spring-boot

COPY ./study-spring-boot .

RUN mvn dependency:resolve \
	&& mvn clean package -DskipTests

FROM openjdk:17-slim

EXPOSE 8000

WORKDIR /app

COPY --from=build /app/study-spring-boot/target/study-spring-boot-0.0.1-SNAPSHOT.jar /spring-boot-study.jar

ENTRYPOINT ["java", "-jar", "/spring-boot-study.jar"]