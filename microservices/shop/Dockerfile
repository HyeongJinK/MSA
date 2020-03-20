FROM openjdk:12.0.2

EXPOSE  7501

ADD ./target/*.jar shop.jar

ENTRYPOINT ["java","-jar","/shop.jar"]
