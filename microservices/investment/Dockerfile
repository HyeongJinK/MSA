FROM openjdk:12.0.2

EXPOSE  7801

ADD ./target/*.jar investment.jar

ENTRYPOINT ["java","-jar","/investment.jar"]