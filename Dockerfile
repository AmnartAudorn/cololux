FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -cololux

FROM openjdk:17.0.1-jdk-slim
COPY --from=build target/cololux-0.0.1-SNAPSHOT.jar cololux.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","cololux.jar"]