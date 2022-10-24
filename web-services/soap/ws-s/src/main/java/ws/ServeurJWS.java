package ws;

import jakarta.xml.ws.Endpoint;

public class ServeurJWS {
    public static void main(String[] args) {
        //demarre un serveur http sur le port 9191 pour consulter le jws
        Endpoint endpoint = Endpoint.publish("http://0.0.0.0:9191/WS/", new BanqueService());
        System.out.println("JWS deployé sur le port 9191");
    }
}
