FROM devstackhub/alpine-java:8
COPY target/restexample-0.0.1-SNAPSHOT.jar /app.jar
ENV server.port=9090
EXPOSE 9090
CMD ["java", "-jar", "/app.jar"]
