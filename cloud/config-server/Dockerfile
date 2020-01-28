FROM openjdk:12.0.2

EXPOSE 8888

ADD ./target/*.jar config-server.jar

ENTRYPOINT ["java","-jar","/config-server.jar"]
