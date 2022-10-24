import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

public class ClientWs {
    public static void main(String[] args) {
        BanqueService stub = new BanqueWS().getBanqueServicePort();
        System.out.println(stub.conversionEuroToDH(100));
        Compte compte = stub.getCompte(1);
        System.out.println(compte.getCode());
        System.out.println(compte.getSolde());
    }
}
