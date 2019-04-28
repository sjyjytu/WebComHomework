## Task 3

---

My docker image can be found at my [dockerhub](<https://cloud.docker.com/u/ketianya/repository/docker/ketianya/calculator>).

---

My docker file can be found [here](<https://github.com/sjyjytu/WebComHomework/blob/phase2/Task3/Dockerfile>). 

---



### How to establish your spring boot project using docker?

1. pack your spring boot project into a jar package

   1. add spring-boot-maven-plugin to pom.xml

   ~~~java
   <build>
       <plugins>
           <plugin>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-maven-plugin</artifactId>
           </plugin>
       </plugins>
   </build>
   ~~~

    	2. run the follow command at the directory of pom.xml

   ~~~cmd
   mvn clean package -Dmaven.test.skip=true
   ~~~

   3. then you can get a file named ***.jar at /target

2. build an image using your jar package

   1. create a new folder, cd in it.(for example: haha)
   2. drag the ***.jar file to haha
   3. create a new file named Dockerfile
   4. add the follow content in Dockerfile

   ~~~dockerfile
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
   ~~~

   5. think up a beautiful image name and then run the follow command, important: the dot at last is necessary!

   ~~~c
   docker build -t your_image_name:your_image_version .
   ~~~

3. build a container using your image

   1. think up a beautiful container name and run the follow command

   ~~~c
   docker run --rm --name your_container_name -d -p 8888:8080 your_image_name:your_image_version
   ~~~

   Here 8888 is the port of your host, is casual, you can use 1234,2345,3456,3242...... whatever you want!

   But 8080 is assigned in the Dockerfile, you can change it in the Dockerfile.

