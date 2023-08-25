# Utilise une image de base Java 11

FROM azul/zulu-openjdk:17-latest as build


# Définirle répertoire de travail dans le conteneur
WORKDIR /app

# Copie gradlew et le dossier gradle dans le conteneur
COPY gradlew .
COPY gradle gradle

# Rendre gradlew exécutable
RUN chmod +x ./gradlew

# Copie fichiers du projet dans le conteneur
COPY . .

# Construction l'application en utilisant Gradle
RUN ./gradlew build

#  minimiser la taille de l'image finale
FROM openjdk:11-jre-slim

WORKDIR /app

# Copie le fichier JAR construit dans la nouvelle image
COPY --from=build /app/build/libs/*.jar /app/app.jar

# Port app
EXPOSE 8080

# commande pour exécuter votre application
CMD ["java", "-jar", "/app/app.jar"]