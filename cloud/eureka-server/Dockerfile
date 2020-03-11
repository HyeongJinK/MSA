FROM openjdk:12.0.2

EXPOSE 8761

ADD ./target/*.jar eureka-server.jar

ADD ./wait-for-it.sh wait-for-it.sh

ENTRYPOINT ["bash", "./wait-for-it.sh", "-t", "0", "config-server:8888", "--",  "java","-jar","/eureka-server.jar"]
