FROM openjdk:12.0.2

EXPOSE  7201

ADD ./target/*.jar investorRelations.jar

ENTRYPOINT ["java","-jar","/investorRelations.jar"]