package task_2;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SampleServer extends Thread {
    Socket socket;
    int num;

    public SampleServer(int num, Socket socket) {
        // копируем данные
        this.num = num;
        this.socket = socket;

        // и запускаем новый вычислительный поток (см. ф-ю run())
        setDaemon(true);
        setPriority(NORM_PRIORITY);
        start();
    }

    public static void main(String args[]) {
        try {
            int i = 0; // счётчик подключений

            // присоединить сокет на localhost, порт 3128

            // port - the port number, or 0 to use a port number that is automatically allocated.
            // backlog - requested maximum length of the queue of incoming connections.
            // bindAddr - the local InetAddress the server will bind to
            // public ServerSocket(int port,
            // int backlog,
            // InetAddress bindAddr)
            // throws IOException
            ServerSocket server = new ServerSocket(
                    3128,
                    0,
                    InetAddress.getByName("localhost")
            );

            System.out.println("server is started");

            // слушаем порт
            while (true) {
                // ждём нового подключения, после чего запускаем обработку клиента
                // в новый вычислительный поток и увеличиваем счётчик на единичку
                new SampleServer(i, server.accept());
                i++;
            }
        } catch (Exception e) {
            System.out.println("init error: " + e);
        } // вывод исключений
    }

    public void run() {
        try {
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            // создаём строку, содержащую полученную от клиента информацию
            String data = "";
            String line = "";
            while(!(line = bufferedReader.readLine()).equals(" ")) {
                data += line + "\n";
            }
            System.out.println(data.trim());

            // добавляем данные об адресе сокета:
            data = "" + num + ": " + "\n" + data;

            printStream.println(data);
            printStream.close();
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("init error: " + e);
        } // вывод исключений
    }
}
