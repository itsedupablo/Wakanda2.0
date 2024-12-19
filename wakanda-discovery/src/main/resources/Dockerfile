
# Usa una imagen base de Java
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado por el build al contenedor
COPY target/eureka-server-0.0.1-SNAPSHOT.jar eureka-server.jar

# Expone el puerto que usará el Eureka Server
EXPOSE 8761

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "eureka-server.jar"]
