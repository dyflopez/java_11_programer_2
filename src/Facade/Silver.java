package Facade;

public class Silver implements Credit{
    @Override
    public void showCreditCart() {
        System.out.println("La targeta Silver tiene un credito de 2000");
    }
}
