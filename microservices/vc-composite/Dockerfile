FROM openjdk:12.0.2

EXPOSE  8081

ADD ./target/*.jar vc.jar

ENTRYPOINT ["java","-jar","/vc.jar"]
