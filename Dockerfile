FROM openjdk:17-jdk-alpine as builder
WORKDIR /opt/app
ARG DB_PW
#ENV DB_PW=$ARG1
RUN echo "The ARG variable DB_PW is $DB_PW"
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install
 
FROM openjdk:17-jdk-alpine
WORKDIR /opt/app
EXPOSE 8080
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar
ENTRYPOINT ["java", "-jar", "/opt/app/*.jar" ]