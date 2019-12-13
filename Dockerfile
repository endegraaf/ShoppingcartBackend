FROM openjdk:8-jdk-alpine

LABEL maintainer="eric.degraaf@alten.nl"

EXPOSE 8090

ADD target/cars-0.0.1-SNAPSHOT.jar cars.jar

RUN /bin/sh -c 'touch /cars.jar'

ENTRYPOINT ["java","-Xmx256m","-Djava.security.egd=file:/dev/./urandom","-jar","/cars.jar"]
