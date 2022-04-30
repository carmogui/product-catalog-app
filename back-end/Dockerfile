FROM openjdk:17-oracle

WORKDIR /productcatalog

COPY target/*.jar /productcatalog/app.jar

EXPOSE 8080

CMD java -XX:+UseContainerSupport -jar app.jar