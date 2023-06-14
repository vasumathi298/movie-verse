# latest oracle openjdk is the basis
FROM openjdk:oracle
# copy jar file into container image under app directory
COPY target/spring-boot-movie-data-finder-0.0.1-SNAPSHOT.jar app/spring-boot-movie-data-finder-0.0.1-SNAPSHOT.jar
# expose server port accept connections
EXPOSE 8080
# start application
CMD ["java", "-jar", "app/demoApp.jar"]