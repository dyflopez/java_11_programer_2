package Interfaces;

public class HiloAnonimo {
    public static void main(String[] args) {
         Runnable cronometro = ()->{
             for(int segundos=0;;segundos++){
                 System.out.println("tiempo transcurrido " + segundos +" segundos");
                 try {
                     Thread.sleep(1000);
                 }catch (InterruptedException e){
                     System.out.println(e.getMessage());
                     break;
                 }
             }
         };

         Thread thread  = new Thread(cronometro);
         thread.start();

        try{
            Thread.sleep(10000);
             thread.interrupt();
         }catch (Exception e){
             System.out.println(e.getMessage());
         }
    }
}
