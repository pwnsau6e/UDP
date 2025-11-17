import java.io.*;
import java.net.*;
import java.util.Scanner;



public class DatagramSocketServer {
   
    public static void main(String[] args) throws   IOException {
      final int port = 1234 ; 
      DatagramSocket dgsrv = new DatagramSocket(port);
      Scanner scanner = new Scanner(System.in);
        System.out.println("Server is running on port " + port);
        byte[] receive = new byte[1024];
        DatagramPacket packet = null ; 

        while (true){
            packet = new DatagramPacket(receive, receive.length);
            dgsrv.receive(packet);
            System.out.println("Client " + packet.getAddress() + " : " + packet.getPort() + " says: " + new String(packet.getData()));

            if (String .valueOf(packet.getData()).trim().equals("exit")){
                System.out.println("Client is Saying Goodbye ");
                break;  
            }
            receive = new byte[1024];

        }
        dgsrv.close();
        scanner.close();

    }



}
