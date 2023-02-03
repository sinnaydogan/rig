FROM openjdk:11-jdk
MAINTAINER rig
COPY target/*.jar rig-application.jar
ENTRYPOINT ["java","-jar","/rig-application.jar"]