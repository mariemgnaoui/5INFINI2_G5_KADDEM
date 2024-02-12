FROM openjdk:11
EXPOSE 8089
ADD target/kaddem-0.0.3.jar kaddem-0.0.3.jar
ENTRYPOINT ["java", "-jar", "kaddem-0.0.3.jar"]
