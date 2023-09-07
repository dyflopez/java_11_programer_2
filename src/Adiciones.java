import java.util.concurrent.atomic.AtomicInteger;

public class Adiciones {

    public static void main(String[] args) {
        /**
         * Las clases atomicas se usan cuando se realiza cocunrrencia ....
         *
         * ATOMIC  Estan en UTIL.Concurrent.atomic
         *
         * Garantiza la integridad de los daos
         *
         * tiene acceso dierecto a la memoria
         *
         * Contador globa
         *
         * Cuando hablamos de concurrencia  decimos que es "atomico" ,
         * Estamo diciendo a una operacion que se considera interrumplita o en hilos
         *
         *
         * AtomicInteger: Manipulacion de enteros
         * Atomic_Long: para los long
         * AtomicBooleand: para los boleand true o false
         * AtomicReference : objetos
         * DoubleAccumulator: Florantes o double
         */

        Adiciones.incremento();
    }

    public static void incremento(){

        // yo quiero correr dos hilos los cuales  tengan cada uno un tiempo de espera diferente ,
        // que sea definido por mi o usuario
        AtomicInteger contador = new AtomicInteger(0);
        int  sleep1 = 1000;
        int  sleep2 = 6000;
        Runnable incrementTask = ()->{
            String theadName = Thread.currentThread().getName();
            for (int i =0; i<100;i++){
                 contador.incrementAndGet();
                System.out.println("theadName " + theadName  +" numero " +contador.get());
                try{
                    int time = theadName.equals("thread-1")?sleep1:sleep2;
                    Thread.sleep(time);

                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }

        };

        Thread thread1 = new Thread(incrementTask);
        Thread thread2 = new Thread(incrementTask);

        thread1.setName("thread-1");
        thread2.setName("thread-2");
        thread1.start();
        thread2.start();

        System.out.println("final");

    }
}
