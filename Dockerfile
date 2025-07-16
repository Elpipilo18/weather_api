# Dockerfile

FROM openjdk:21-jdk-bullseye

WORKDIR /usr/src/app

# Copiar el archivo WAR generado por Grails
COPY build/libs/api-mobileApp.war app.war

EXPOSE 8080

# Ejecutar el WAR al iniciar el contenedor
CMD ["java", "-jar", "app.war"]
