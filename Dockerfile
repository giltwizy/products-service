FROM eclipse-temurin:17-jdk-alpine

# Updating packages of the Base Image
RUN apk update && apk upgrade && apk --no-cache add shadow

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY ./target/*.jar /app/app.jar

# Create a non-root user and give non-root user ownership to application directory
RUN groupadd -r myuser && useradd -r -g myuser myuser && chown -R myuser:myuser /app

# Switch to the non-root user
USER myuser

# Expose the port where application runs on
EXPOSE 9000

# Command to run application
ENTRYPOINT [ "java","-jar","/app/app.jar" ]