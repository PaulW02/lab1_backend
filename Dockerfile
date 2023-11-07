# Use an official OpenJDK runtime as a parent image
FROM maven:3.8.3-openjdk-17

ENV SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/patient_journal
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=1234
ENV HIBERNATE_DIALECT=org.hibernate.dialect.MySQLDialect


COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
EXPOSE 8080

# Define the command to run your application when the container starts
CMD ["java", "-jar", "/home/app/target/lab1_backend.jar"]
