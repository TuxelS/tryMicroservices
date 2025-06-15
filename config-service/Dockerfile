FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY target/*.jar /app/app.jar
ENTRYPOINT exec java $DEF_JAVA_OPTIONS -jar /app/app.jar