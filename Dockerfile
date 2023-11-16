# Use an official OpenJDK runtime as a parent image
#FROM maven:3.8.3-openjdk-17

FROM eclipse-temurin:17-jdk-jammy

#COPY src /home/app/src
#COPY pom.xml /home/app
#RUN mvn -f /home/app/pom.xml clean package
#EXPOSE

# Define the command to run your application when the container starts
#CMD ["java", "-jar", "/home/app/target/lab1_backend.jar"]

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
USER root
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]


