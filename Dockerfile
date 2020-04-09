FROM openjdk
ADD target/gig-java-api.jar gig-java-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "gig-java-api.java"]