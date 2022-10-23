public class Application {
    public final static void main(String[] args) {
        Compte c1 = new Compte(1000);
        Compte c2 = new Compte(2000);
        c1.crediter(1000);
        c2.debiter(500);
        System.out.println("Le solde du compte 1 est : " + c1.getSum());
        System.out.println("Le solde du compte 2 est : " + c2.getSum());
        System.out.println("Le nombre de comptes est : " + Compte.nbcompte);
    }
}
