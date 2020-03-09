FROM openjdk:12.0.2

EXPOSE  7201

ADD ./target/*.jar ir.jar

ENTRYPOINT ["java","-jar","/ir.jar"]