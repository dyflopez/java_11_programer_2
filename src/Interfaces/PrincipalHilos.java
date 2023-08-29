package Interfaces;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrincipalHilos {

    public static void main(String[] args) {
        ExecutorService execute = Executors.newFixedThreadPool(2);
        MyThread myThread1 = new MyThread("Daniel",3000);

        MyThread myThread2 = new MyThread("Yesid",2000);

        /*myThread1.run();
        myThread2.run();*/

        execute.submit(myThread1);
        execute.submit(myThread2);
        System.out.println("Hola soy Daniel Florez");

        execute.shutdown();

        System.out.println("Chao ");

        /**
         * Process 1
         * Process 2
         *
         *    System.out.println("Hola soy Daniel Florez");
         */
    }
}
