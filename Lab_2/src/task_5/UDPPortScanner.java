package task_5;

import java.net.*;

public class UDPPortScanner {
    public static void main(String[] args) {
        for (int port = 1024; port <= 65535; port++) {
            try {
                // Строка ниже приведет к ошибке
                // если уже запущен  server на порту i
                DatagramSocket server = new DatagramSocket(port);
                server.close();
            } catch (SocketException ex) {
                System.out.println("Сервер запущен на порту " + port + ".");
            }
        }
    }
}
