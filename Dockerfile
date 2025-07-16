# Base para Grails con Java JDK
FROM openjdk:21-jdk-bullseye

# Configurar directorio de trabajo
WORKDIR /usr/src/app

# Instalación de herramientas adicionales
RUN apt-get update && apt-get install -y \
    curl \
    unzip \
    wget \
    git \
    build-essential \
    && apt-get clean

# Exponer el puerto de Grails
EXPOSE 8080
