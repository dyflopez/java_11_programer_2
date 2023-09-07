package Facade;

public class Black implements Credit{
    @Override
    public void showCreditCart() {
        System.out.println("La targeta BLACK tiene un credito de 10000");
    }
}
