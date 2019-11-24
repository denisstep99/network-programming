package task_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    /* Объявляются переменные */
    DatagramSocket socket = null;
    BufferedReader in = null;
    String str = null;
    byte[] buffer;
    DatagramPacket packet;
    InetAddress address;
    int port;

    /* Конструктор класса UDPServer */
    public UDPServer() throws IOException {
        /*
         * Создается объект DatagramSocket, который получает запросы клиента на
         * номер порта 1501
         */
        socket = new DatagramSocket(1501);

        /* Вызывается метод call() */
        call();
    }

    public static void main(String args[]) throws Exception {
        /* Запускается сервер */
        System.out.println("Сервер UDP стартует...");
        new UDPServer();
    }

    public void call() {
        try {
            while (true) {
                buffer = new byte[256];
                /* Инициализируется объект DatagramPacket */
                packet = new DatagramPacket(buffer, buffer.length);
                /*
                 * Принимается пакет датаграмм, используя метод receive()
                 * класса DatagramSocket
                 */
                socket.receive(packet);
                if (packet == null) {
                    break;
                } else {
                    System.out.println(new String(packet.getData()));
                }

                System.out.println("Request string for sending to client ");
                try {
                    /*
                     *Создается входной поток, который считывает данные с консоли
                     */
                    in = new BufferedReader(new InputStreamReader(System.in));
                } catch (Exception e) {
                    System.out.println("Error : " + e);
                }
                str = in.readLine();
                buffer = str.getBytes();
                address = packet.getAddress();
                port = packet.getPort();
                packet = new DatagramPacket(buffer, buffer.length, address, port);
                /* Посылается датаграммный пакет */
                socket.send(packet);
            }
            /* Закрывается поток и сокет */
            in.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }
}

