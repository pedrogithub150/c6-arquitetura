FROM openjdk:16-jdk-alpine
WORKDIR /apt/java/appjava
ADD tarefaCalculadora.jar app.jar
CMD ["/usr/bin/java", "-jar", "app.jar"]
