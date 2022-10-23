public class Compte {
   public static int nbcompte;
   private  float sum;
   public Compte(float sum) {
      this.sum = sum;
      nbcompte++;
   }
    public void crediter(float somme) {
        this.sum += somme;
    }
    public void debiter(float somme) {
        this.sum -= somme;
    }
    public float getSum() {
        return sum;
    }
    public void setSum(float sum) {
        this.sum = sum;
    }

}

