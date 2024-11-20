FROM openjdk:17

EXPOSE 8000

WORKDIR /app/study-spring-boot

COPY ./study-spring-boot .

RUN ./mvnw clean install -DskipTests

ENTRYPOINT ["./mvnw", "spring-boot:run"]
