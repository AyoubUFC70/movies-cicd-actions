# Étape 1 : Utilisation d'une image de base Java pour compiler l'application
#FROM maven:3.8.5-openjdk-17 AS build
#WORKDIR /app
#COPY . .
#RUN mvn clean package

# Étape 2 : Création d'une image pour l'exécution de l'application Spring Boot
FROM openjdk:17.0.2-slim
#WORKDIR /app
#COPY --from=build /app/target/*.jar app.jar
ADD target/spring-k8s-demo-0.0.1-SNAPSHOT.jar app.jar

# Port exposé par l'application
EXPOSE 8080

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
