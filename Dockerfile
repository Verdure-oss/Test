FROM openjdk:14-jdk
ARG JARFILE
COPY ${JARFILE} app.jar
EXPOSE 90
ENTRYPOINT ["java","-jar","/app.jar"]