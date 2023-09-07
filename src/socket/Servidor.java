package socket;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private  static  final  int PORT=12345;

    public static void main(String[] args) {

        System.out.println("Char Server is running");

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true){
                new ClientHandler(serverSocket.accept()).start();
            }
        }catch (Exception e){

        }finally {

        }
    }


    private  static class ClientHandler extends Thread{
        private Socket socket;
        private PrintWriter writer;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }
    }
}
