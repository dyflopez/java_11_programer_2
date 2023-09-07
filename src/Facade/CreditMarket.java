package Facade;

public class CreditMarket {

    private Credit gold;
    private Credit silver;
    private Credit black;

    public CreditMarket() {
        this.gold = new Gold();
        this.silver = new Silver();
        this.black = new Black();
    }

    public void showCreditGold(){
        gold.showCreditCart();
    }
    public void showCreditSilver(){
        silver.showCreditCart();

    }
    public void showCreditBlack(){
        black.showCreditCart();
    }
}
