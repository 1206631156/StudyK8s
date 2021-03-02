FROM java:8
MAINTAINER pjt
ADD activiti-test-0.0.1-SNAPSHOT.jar activiti.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","activiti.jar"]
