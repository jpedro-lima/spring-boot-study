# FROM maven:3.9.9 AS build

# WORKDIR /app/study-spring-boot

# COPY ./study-spring-boot/pom.xml ./

# COPY ./study-spring-boot/src ./src

# RUN	mvn dependency:resolve dependency:resolve-plugins \
# 	&& mvn clean package -DskipTests

# FROM openjdk:17-slim

# EXPOSE 8000

# WORKDIR /app

# COPY --from=build /app/study-spring-boot/target/study-spring-boot-0.0.1-SNAPSHOT.jar ./app.jar

# COPY ./startup.sh ./

# RUN	apt update 					\
# 	&& apt install netcat -y	\
# 	&& apt clean				\
# 	&& chmod +777 startup.sh

# ENTRYPOINT ["/bin/sh", "-c", "./startup.sh"]

FROM openjdk:17-slim

EXPOSE 8000

COPY ./study-spring-boot /app/study-spring-boot

COPY ./startup.sh /app/

WORKDIR /app/study-spring-boot
RUN ./mvnw dependency:resolve dependency:resolve-plugins	\
 	&& ./mvnw clean package -DskipTests						\
	&& cp ./target/study-spring-boot-0.0.1-SNAPSHOT.jar ../app.jar

RUN	apt update 					\
	&& apt install netcat -y	\
	&& apt clean				\
	&& chmod +777 /app/startup.sh

ENTRYPOINT ["/bin/sh", "-c", "/app/startup.sh"]
