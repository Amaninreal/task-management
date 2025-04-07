# Use an official Java runtime as a parent image
FROM eclipse-temurin:21-jdk-jammy

# Install Maven
RUN apt-get update && apt-get install -y maven

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files (including pom.xml) into the container
COPY . /app

# Run Maven to build the project (this will generate the JAR file)
RUN mvn clean install

# Expose the application port (adjust based on your app's port)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/target/taskmanagement-0.0.1-SNAPSHOT.jar"]
