# 1️⃣ Use official OpenJDK image
FROM openjdk:17-jdk-slim

# 2️⃣ Set working directory
WORKDIR /app

# 3️⃣ Copy Gradle wrapper and build files
COPY gradlew ./
COPY gradle ./gradle
COPY build.gradle ./
COPY settings.gradle ./

# 4️⃣ Copy the source code
COPY src ./src

# 5️⃣ Give permission to Gradle wrapper
RUN chmod +x ./gradlew

# 6️⃣ Build the JAR file
RUN ./gradlew clean build -x test

# 7️⃣ Expose the default Spring Boot port
EXPOSE 8080

# 8️⃣ Run the built JAR
CMD ["java", "-jar", "build/libs/familytree-0.0.1-SNAPSHOT.jar"]
