FROM openjdk:12.0.2

EXPOSE 8765 8080

ADD ./target/*.jar gateway.jar

ADD ./wait-for-it.sh wait-for-it.sh

#ENTRYPOINT ["java","-jar","/gateway.jar"]
#ENTRYPOINT ["bash", "./wait-for-it.sh", "-t", "0", "localhost:8761", "--",  "java","-jar","/gateway.jar"]
