FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/Autentification-service-0.0.1-SNAPSHOT.jar autentification-service.jar
ENTRYPOINT ["java", "-jar", "autentification-service.jar"]
