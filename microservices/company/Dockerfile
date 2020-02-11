FROM openjdk:12.0.2

EXPOSE  7101

ADD ./target/*.jar company.jar

ADD ../../wait-for-it.sh wait-for-it.sh

#ENTRYPOINT ["bash", "./wait-for-it.sh", "-t", "0", "localhost:8761", "--",  "java","-jar","/company.jar"]
