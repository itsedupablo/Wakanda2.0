# Etapa 1: Construcción del JAR
FROM maven:3.8.6-eclipse-temurin-17 as builder

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo POM y descargar las dependencias (cachear esta capa)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar el resto de la aplicación y compilar
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final para ejecutar el JAR
FROM eclipse-temurin:17-jdk

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el JAR generado desde la etapa de construcción
COPY --from=builder /app/target/*.jar eureka-server.jar

# Exponer el puerto 8761 (Eureka Server)
EXPOSE 8761

# Comando para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "eureka-server.jar"]
