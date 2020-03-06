FROM openjdk:12.0.2

EXPOSE  8080

ADD ./target/*.jar startup.jar

ENTRYPOINT ["java","-jar","/startup.jar"]
