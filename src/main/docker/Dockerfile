FROM java:7
ADD configserver-0.0.1-SNAPSHOT.jar app.jar
VOLUME /target
EXPOSE 8888
ENTRYPOINT ["java","-jar","/app.jar"]