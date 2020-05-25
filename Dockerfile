FROM openjdk:14-jdk
ARG JARFILE
COPY ${JARFILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
#FROM hello-world