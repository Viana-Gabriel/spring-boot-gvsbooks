# Usar uma imagem base do JDK
FROM openjdk:17-jdk-slim

# Diretório de trabalho no container
WORKDIR /app

# Copiar o arquivo JAR gerado para o container
COPY target\api-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta usada pelo Spring Boot (normalmente 8080)
EXPOSE 8080

# Comando para iniciar a aplicação
CMD ["java", "-jar", "app.jar"]
