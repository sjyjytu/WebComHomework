# Docker image for springboot file run

# Version: 1.0

# Author: JY

FROM adoptopenjdk/openjdk11:latest
VOLUME /tmp

# expose the container port
EXPOSE 8080

# add jar package and rename to jbook.jar

ADD demo-0.0.1-SNAPSHOT.jar demo.jar

# run it

RUN bash -c 'touch /demo.jar'
ENV JAVA_OPTS = ""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/urandom","-jar","/demo.jar"