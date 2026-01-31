# Use Eclipse Temurin 21 as the base image (OpenJDK replacement)
FROM eclipse-temurin:21-jre

# Set the working directory
WORKDIR /app

# Copy the jar file built by Maven
COPY target/spe_mini_project_calculator-1.0-SNAPSHOT.jar /app/calculator.jar

# Run the application
CMD ["java", "-jar", "calculator.jar"]
