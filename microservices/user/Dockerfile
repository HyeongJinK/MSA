FROM openjdk:12.0.2

EXPOSE  7210

ADD ./target/*.jar user.jar

ENTRYPOINT ["java","-jar","/user.jar"]
