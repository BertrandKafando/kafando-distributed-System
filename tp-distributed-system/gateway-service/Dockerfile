FROM openjdk:17-alpine
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME
COPY ./target/*.jar app.jar
EXPOSE 8888
CMD [ "java", "-jar", "app.jar"]
