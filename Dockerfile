# Usa una imagen de Java
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia tu archivo JAR al contenedor
COPY target/Wakanda-0.0.2-SNAPSHOT.jar app.jar

# Expone el puerto 8761 para Eureka Server
EXPOSE 8761
EXPOSE 8082


# Comando para ejecutar el servidor
ENTRYPOINT ["java", "-jar", "app.jar"]
