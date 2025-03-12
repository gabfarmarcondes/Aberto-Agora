FROM openjdk:21-slim
WORKDIR /app
RUN apt-get update && apt-get install -y curl
COPY build/libs/abertoagora-0.0.1-SNAPSHOT.jar app.jar
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app/app.jar"]