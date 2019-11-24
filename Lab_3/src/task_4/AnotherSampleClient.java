package task_4;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.stream.Collectors;

public class AnotherSampleClient{
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

            printer.println("hello from new client! \n ");
            Thread.sleep(5000);

            String data = reader.lines().collect(Collectors.joining("\n"));
            reader.close();
            // выводим ответ в консоль
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        } // вывод исключений
    }
}
