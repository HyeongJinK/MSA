FROM openjdk:12.0.2

EXPOSE  8080

ADD ./target/*.jar communication.jar

ENTRYPOINT ["java","-jar","/communication.jar"]
