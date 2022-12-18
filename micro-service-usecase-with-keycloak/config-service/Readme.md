## Création d'un service de configuration

<br>

## Stack & packages
-> Have a look : [📦 pom.xml ](./pom.xml)

```
java : 17-Maven
spring : 2.7.5
packages : 
    - spring-boot-starter-actuator
    -spring-cloud-config-server
    -spring-cloud-starter-consul-discovery   
```

## Config :
-> project configuration : `application.properties`

```
server.port=8888
spring.application.name=config-service
spring.cloud.config.server.git.uri=/// 
```
<br>

## App:
-> nous devons juste ajouter l'annotation `@EnableConfigServer` pour activer le service de configuration

```
@SpringBootApplication
@EnableConfigServer
public class ConfigServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServiceApplication.class, args);
    }

}

```

<br>


## Test


