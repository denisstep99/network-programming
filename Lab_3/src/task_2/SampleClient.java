package task_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.stream.Collectors;

public class SampleClient extends Thread {
    public static void main(String[] args) {
        PrintStream printer;
        BufferedReader reader;

        try {
            // открываем сокет и коннектимся к localhost:3128
            // получаем сокет сервера
            Socket socket = new Socket("localhost", 3128);
            printer = new PrintStream(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()
            ));


            // берём поток вывода и выводим туда первый аргумент
            // заданный при вызове, адрес открытого сокета и его порт
            args[0] = args[0] + "\n" + socket.getInetAddress().getHostAddress()
                    + ":" + socket.getLocalPort() + "\n ";
            printer.println(args[0]);

            String data = reader.lines().collect(Collectors.joining("\n"));
            reader.close();
            // выводим ответ в консоль
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        } // вывод исключений
    }
}
