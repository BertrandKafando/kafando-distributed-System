package ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Date;
import java.util.List;
//POJO plian old java object

//-->service web
@WebService(serviceName = "BanqueWS")
public class BanqueService {
    @WebMethod(operationName = "conversionEuroToDH")
    public double conversion( @WebParam(name = "montant") double montant) {
        return montant * 10;
    }
    @WebMethod
    public Compte getCompte(@WebParam(name = "code") int code) {
        Compte c = new Compte();
        c.setCode(code);
        c.setSolde(Math.random() * 9000);
        return c;
    }

    @WebMethod
    List<Compte> listComptes() {
        return List.of(
                new Compte(1, 1000, new Date()),
                new Compte(2, 2000, new Date()),
                new Compte(3, 3000, new Date())
        );
    }



}
