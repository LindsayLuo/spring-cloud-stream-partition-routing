FROM openjdk:8-alpine
MAINTAINER Lindsay Luo
COPY build/libs/producer-0.0.1-SNAPSHOT.jar /opt/producer/
WORKDIR /opt/producer/
EXPOSE "8180"
CMD ["java", "-jar", "producer-0.0.1-SNAPSHOT.jar"]