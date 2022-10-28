FROM openjdk:17-alpine
# you need to compile & package your app before building a docker image !
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME
COPY ./target/*.jar app.jar
EXPOSE 8082
CMD [ "java", "-jar", "app.jar"]
