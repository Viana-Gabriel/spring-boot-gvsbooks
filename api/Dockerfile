# Build Stage (Windows container base)
FROM mcr.microsoft.com/windows/servercore:ltsc2022 AS build

WORKDIR /app

# Install dependencies (Windows uses PowerShell or choco for packages)
RUN powershell -Command "Install-WindowsFeature -Name Web-Server"

# Copy project files
COPY . .

# Build application
RUN mvn clean install -DskipTests

# Runtime Stage (Windows container base)
FROM mcr.microsoft.com/windows/servercore:ltsc2022

WORKDIR /app

# Expose the port
EXPOSE 8080

# Copy the JAR file from the build stage
COPY --from=build /app/target/api-0.0.1-SNAPSHOT.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
p.jar" ]