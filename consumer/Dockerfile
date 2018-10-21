FROM openjdk:8-alpine
MAINTAINER Lindsay Luo
COPY build/libs/consumer-0.0.1-SNAPSHOT.jar /opt/consumer/
WORKDIR /opt/consumer/
EXPOSE "8080"
CMD ["java", "-jar", "consumer-0.0.1-SNAPSHOT.jar"]