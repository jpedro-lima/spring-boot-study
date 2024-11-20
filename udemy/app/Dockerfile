FROM openjdk:17-slim

EXPOSE 8000

WORKDIR /app/study-spring-boot

COPY ./study-spring-boot .

RUN apt update && apt upgrade -y	\
	&& apt install maven -y			\
	&& apt clean

ENTRYPOINT ["mvn"]
