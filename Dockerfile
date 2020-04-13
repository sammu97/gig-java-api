#
# Build stage
#
FROM maven:3.6.3-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk
COPY --from=build /home/app/target/gig-java-api.jar /usr/local/lib/gig-java-api.jar
EXPOSE 8080

COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

ENTRYPOINT ["java","-jar","/usr/local/lib/gig-java-api.jar"]
