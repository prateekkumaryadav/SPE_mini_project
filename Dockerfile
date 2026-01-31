# Use OpenJDK 21 as the base image
FROM openjdk:21

# Set the working directory
WORKDIR /app

# Copy the jar file built by Maven
COPY target/spe_mini_project_calculator-1.0-SNAPSHOT.jar /app/calculator.jar

# Run the application
CMD ["java", "-jar", "calculator.jar"]
