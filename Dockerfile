# Use an official OpenJDK runtime as a parent image
FROM openjdk:18

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file (built Spring Boot application) into the container at the defined working directory
COPY target/lab1_backend.jar .

# Expose the port your Spring Boot application is listening on
EXPOSE 8080

# Define the command to run your application when the container starts
CMD ["java", "-jar", "lab1_backend.jar"]
