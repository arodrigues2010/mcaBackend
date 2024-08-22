# Etapa 1: Construcción
FROM maven:3.8.1-openjdk-11 AS builder

# Establece el directorio de trabajo en el contenedor
WORKDIR /usr/src/app

# Copia el archivo pom.xml al directorio de trabajo
COPY pom.xml .

# Copia el código fuente al directorio de trabajo
COPY src /usr/src/app/src

# Construye el proyecto usando Maven y guarda el JAR en el directorio target
RUN mvn clean package

# Etapa 2: Imagen de ejecución
FROM openjdk:11-jre-slim

# Establece el directorio de trabajo en el contenedor
WORKDIR /usr/src/app

# Copia el JAR desde la etapa de construcción
COPY --from=builder /usr/src/app/target/mcaBackend-1.0.jar /usr/src/app/mcaBackend.jar

# Establece el comando por defecto para ejecutar la aplicación
CMD ["java", "-jar", "mcaBackend.jar"]

