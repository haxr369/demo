FROM --platform=linux/amd64 gradle:8.2.1-jdk17-alpine
COPY ./build/libs/demo-0.0.1-SNAPSHOT.jar /home/app.jar
EXPOSE 8080
CMD ["java","-jar","/home/app.jar"]