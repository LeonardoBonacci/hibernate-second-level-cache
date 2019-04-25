FROM openjdk:8-jre-alpine

ADD ./target/hibcache-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/hibcache-0.0.1-SNAPSHOT.jar"]