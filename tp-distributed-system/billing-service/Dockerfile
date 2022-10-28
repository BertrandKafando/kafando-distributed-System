FROM openjdk:17-alpine
# you need to compile & package your app before building a docker image !
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME
COPY ./target/billing-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
CMD [ "java", "-jar", "app.jar"]
