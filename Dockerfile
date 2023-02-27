FROM quay.io/devfile/maven:3.8.1-openjdk-17-slim AS build  
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package

FROM gcr.io/distroless/java  
COPY --from=build /usr/src/app/target/orders-app-0.0.1-SNAPSHOT.jar /usr/app/orders-app.jar  
EXPOSE 8080  
ENTRYPOINT ["java","-jar","/usr/app/orders-app.jar ", "--server.port=8080"]  
