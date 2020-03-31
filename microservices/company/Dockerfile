FROM openjdk:12.0.2

EXPOSE  7101

ADD ./target/*.jar company.jar

ENTRYPOINT ["java","-jar","/company.jar"]
