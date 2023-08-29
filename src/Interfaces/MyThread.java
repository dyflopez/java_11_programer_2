package Interfaces;

public class MyThread  extends  Thread{
    /**
     * Hilo : La capacidad de un programa para realizar multiples tareas simultanieamente | Son tareas que se ejecutan de forma paralelas o asincronas
     *  Multitarea:  Realizar o ejecutar varias tareas a la vez
     * asincrona:  Procesos que no se ejecutan de manera secuencial
     * Sincrono : proceso que se ejcuta de manera secuencial (linea a liena)
     * Bloqueo (lock) : un evento en el cual los procesos asincronos dejan se estancan (ejecutarce) por espera a respuesta de otros procesos.
     */
    private  String nameThread;

    private  int timepoEspara ;

    public MyThread(String nameThread, int timepoEspara) {
        this.nameThread = nameThread;
        this.timepoEspara = timepoEspara;
    }
    //polimorfismo
    public void run(){
        for (int i =0 ; i<5;i++){
            System.out.println("ejecutando "+ this.nameThread + ":"+i);
            try {
                Thread.sleep(timepoEspara);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
