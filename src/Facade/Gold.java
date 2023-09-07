package Facade;

public class Gold implements Credit{
    @Override
    public void showCreditCart() {
        System.out.println("La targeta Gold tiene un credito de 5000");
    }
}
