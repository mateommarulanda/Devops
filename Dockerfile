#FROM eclipse-temurin:17
#LABEL author=MateoMartinez
#COPY target/ApiRest-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]

#---------------------------------------------------------------------------------------------------------------#

#FROM openjdk:17
#COPY target/ApiRest-0.0.1-SNAPSHOT.jar ApiRest-0.0.1-SNAPSHOT.jar
#COPY ./target/employee-jdbc-0.0.1-SNAPSHOT.jar employee-jdbc-0.0.1-SNAPSHOT.jar
#CMD ["java", "-jar", "ApiRest-0.0.1-SNAPSHOT.jar"]

FROM openjdk:17
ADD target/ApiRest-0.0.1-SNAPSHOT.jar ApiRest-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","ApiRest-0.0.1-SNAPSHOT.jar"]