package task_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

/**
 * Многопоточный сервер chat room .  Когда клиент соединяется
 * сервер запрашивает асевдоним и посылает клиенту текст
 *  "SUBMITNAME", и сохраняет запрос имени до тех пор, пока
 * не получит уникальное имя.  После этого
 * сервер подтверждает уникальность текстов "NAMEACCEPTED".  После
 * этого все сообщения  клиента  будут распространяться другим
 * клиентам, которые зашли со своими именами.  Сообщения
 * распространяются с текстом "MESSAGE ".
 *
 */
public class ChatServer {

    /**
     * Порт, который сервер прослушивает.
     */
    private static final int PORT = 9001;

    /**
     * Множество всех имен клиентов в чате.  Поддерживается
     * так что мы можем проверить, что новые клиенты не регистрируются
     * с именем, которое уже используется.
     */
    private static HashSet<String> names = new HashSet<String>();

    /**
     * Множество всех писателей из всех клиентов.  Этот
     * набор сохраняется и мы легко можем распространять сообщения.
     */
    private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();

    /**
     * Метод main method, который просто прослушивает порт и
     * порождает поток обработчика.
     */
    public static void main(String[] args) throws Exception {
        System.out.println("Чат сервер работает.");
        ServerSocket server = new ServerSocket(PORT);
        try {
            while (true) {
                new Handler(server.accept()).start();
            }
        } finally {
            server.close();
        }
    }

    /**
     * Класс управления потоками.  Handler порождается от цикла прослушивания
     * и отвечает за взаимодействие с единственным клиентом
     * и распространением его сообщений.
     */
    private static class Handler extends Thread {
        private String name;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        /**
         * Конструктор управления потоками, запускает сокет.
         * Все интересная работа делается в методе  run .
         */
        public Handler(Socket socket) {
            this.socket = socket;
        }

        /**
         * Сервисы клиентов постоянно запрашивают псевдоним
         * пока не будет введено уникальное имя, затем
         * подтверждает имя и регистрирует выходной поток для клиента
         * tв общем набое, затем постоянно получает ввод и распространяет его.
         */
        public void run() {
            try {

                // Создает поток символов для сокета.
                in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // Запрашивает имя клиента.  Продолжает запрос
                // пока представляется уже используемое имя.
                // Проверка существования имени и добавление имени
                // должны быть выполнены при блокировании набора имен.
                while (true) {
                    out.println("SUBMITNAME");
                    name = in.readLine();
                    if (name == null) {
                        return;
                    }
                    synchronized (names) {
                        if (!names.contains(name)) {
                            names.add(name);
                            break;
                        }
                    }
                }

                // Теперь псевдоним успешно выбран , добавлены
                // писатели в сокетr в набор и этот клиент
                // может отправлять распространяемые сообщения.
                out.println("NAMEACCEPTED");
                writers.add(out);

                // Принимает сообщения от клиента и распространяет их.
                // Ignore other clients that cannot be broadcasted to.
                while (true) {
                    String input = in.readLine();
                    if (input == null) {
                        return;
                    }
                    for (PrintWriter writer : writers) {
                        writer.println("MESSAGE " + name + ": " + input);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                // Это клиент отключился!  Удаляем его имя и его writer
                // из набора, и закрываем его сокет.
                if (name != null) {
                    names.remove(name);
                }
                if (out != null) {
                    writers.remove(out);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}

