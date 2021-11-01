FROM openjdk:8-jdk-alpine

# Add JAR file and run it as entrypoint
ADD target/easy-notes-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Expose the port
EXPOSE 8081