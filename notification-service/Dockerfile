# Используем JDK 21
FROM eclipse-temurin:21-jdk-jammy

# Рабочая директория внутри контейнера
WORKDIR /app

# Копируем JAR
COPY target/notification-service-0.0.1-SNAPSHOT.jar app.jar

# Запуск приложения
ENTRYPOINT ["java", "-jar", "app.jar"]