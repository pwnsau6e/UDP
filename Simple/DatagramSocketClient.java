import java.net.*;
import java.io.*;
import java.util.Scanner;

public class DatagramSocketClient {
    public static void main (String [] args ) throws UnknownHostException, SocketException, IOException {
        final int port = 1234 ;

        Scanner sc = new Scanner(System.in);
        DatagramSocket dgsrv = new DatagramSocket();
        Inet4Address ip = (Inet4Address) Inet4Address.getLocalHost();
        byte[] buffer = null;

        while (true){
            String message = sc.nextLine();
            buffer = message.getBytes();
            DatagramPacket sPacket = new DatagramPacket(buffer, buffer.length, ip, port);
            dgsrv.send(sPacket);

            if (message.equals("bye")){
                break;
            }
        }

    }


}
