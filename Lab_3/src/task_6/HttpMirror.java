package task_6;

import java.io.*;
import java.net.*;

/**
 * Эта программа представляет очень простой Web server. Когда она получает
 * запрос HTTP она отправляет обратно ответ. Это может быть интересно, когда
 * хочется увидеть, что запрашивает Web client, или какие данные посылаются,
 * когда представляется form.
 **/
public class HttpMirror {
    public static void main(String args[]) {
        try {
            // Назначение порта порта для прослушивания в строке параметров
            int port = Integer.parseInt(args[0]);
            // Создаем ServerSocket для прослушивания порта.
            ServerSocket ss = new ServerSocket(port);
            // Теперь определяем бесконечный цикл, ожидание и управление
            // соединением.
            for (;;) {
                // Ждем соединения с клиентом. Метод блокируется,
                // когда им возвращенный socket будет соединяться с клиентом
                Socket client = ss.accept();

                // Определение потоков input и output для разговоров с клиентом
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream());

                // Начало отправки нашего ответа, используя протокол HTTP 1.0
                out.print("HTTP/1.0 200 \n"); // Вервия & код состояния
                out.print("Content-Type: text/plain\n"); // Тип данных
                out.print("\n"); // Конец заголовка

                // Теперь, читаем запрос HTTP от клиента , и посылаем его
                // обратно клиенту как часть тела нашего ответа
                // Клиент не разъединяется , и таким образом мы никонда не
                // получаем EOF.
                // Однако, он отправляет пустую линию в конце заголовка
                // Таким образом, когда мы онаруживаем пустую строку,мы
                // заканчиваем чтение.
                // Это означает, что мы не зеркалируем контент запроса
                // POST,например,
                // когда данные запроса передаются отдельно, а не в строке
                // запроса.
                // Заметьте, что метод readLine()
                // работает в Unix, Windows, и Mac строкой терминатором.
                String line;
                while ((line = in.readLine()) != null) {
                    if (line.length() == 0)
                        break;
                    out.print(line + "\n");
                }

                // Закрывается сокет, прерывание соединения с клиентом и
                // закрытие потоков input и output
                out.close(); // Очистка и закрытия потока close
                in.close(); // Закрытие потка input
                client.close(); // Закрытие самого socket
            } // Теперь возобновляется цикл, ожидающий нового соединения
        }
        // Если что-то идет не так, выводится сообщение об ошибке
        catch (Exception e) {
            System.err.println(e);
            System.err.println("Usage: java HttpMirror <port>");
        }
    }
}

