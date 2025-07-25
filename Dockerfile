# Этап 1: Сборка проекта
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Этап 2: Запуск в Tomcat
FROM tomcat:9.0-jdk17
COPY --from=build /app/target/gyrmaniya.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
