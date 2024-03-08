#FROM eclipse-temurin:17
#LABEL author=MateoMartinez
#COPY target/ApiRest-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java", "-jar", "app.jar"]

#---------------------------------------------------------------------------------------------------------------#

FROM postgres:latest

ENV POSTGRES_USER=postgres \
    POSTGRES_PASSWORD=admin