FROM openjdk:12.0.2

EXPOSE  7001

ADD ./target/*.jar board.jar

ENTRYPOINT ["java","-jar","/board.jar"]