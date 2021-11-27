FROM openjdk:11
COPY target/JumiaTest.jar JumiaTest.jar
ENTRYPOINT ["java","-jar","/JumiaTest.jar"]