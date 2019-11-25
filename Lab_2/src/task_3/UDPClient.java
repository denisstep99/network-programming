package task_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    /* Объявляются переменные */
    static DatagramSocket socket;
    static InetAddress address;
    static byte[] buffer;
    static DatagramPacket packet;
    static String str, str2;
    static BufferedReader br;

    public static void main(String arg[]) throws Exception {
        /* Создается входной поток, который читается с консоли */
        br = new BufferedReader(new InputStreamReader(System.in)); // Клавиатура определяется как источник данных
        while (true) {

            /* Создается новый объект DatagramSocket и связывается с портом по умолчанию */
            socket = new DatagramSocket();
            address = InetAddress.getByName("127.0.0.1");
            buffer = new byte[256];
            packet = new DatagramPacket(buffer, buffer.length, address, 1501);

            /* Посылается DatagramPacket на сервер */
            socket.send(packet);
            System.out.println("Sending request ");
            packet = new DatagramPacket(buffer, buffer.length);
            /* Принимается DatagramPacket от сервера */
            socket.receive(packet);

            /* Принимаются данные от объекта пакета датаграмм и*/
            str = new String(packet.getData());
            System.out.println("Received message : " + str.trim());
            System.out.println("Do you want continue (Yes/No) : ");
            str2 = br.readLine();
            System.out.println();

            /* Выход из цикла while */
            if (str2.toLowerCase().equals("no")) break;
        }
        /* Закрывается объект сокет */
        socket.close();
    }
}

