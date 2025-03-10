FROM openjdk:21-slim
WORKDIR /app
RUN apt-get update && apt-get install -y curl
COPY build/libs/abertoagora-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]