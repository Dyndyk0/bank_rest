FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/bank_rest-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]