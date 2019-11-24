package task_3;

/* Программа для реализации простого клиентского сокета */
import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket clientSocket;
        PrintStream out = null;
        BufferedReader in = null;

        try {
            /* Создается объект сокет для установки соединения с сервером */
            clientSocket = new Socket("localhost", 1001);

            /* Создается выходной поток для отправки данных на сервер */
            out = new PrintStream(clientSocket.getOutputStream());

            /* Создается входной поток для приема данных с сервера */
            in = new BufferedReader(new InputStreamReader(
                    clientSocket.getInputStream()
            ));
        } catch (UnknownHostException e) {
            System.err.println("Unidentified hostname ");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O ");
            System.exit(1);
        }
        /* Создается входной поток для чтения данных из окна консоли */
        BufferedReader stdin = new BufferedReader(new InputStreamReader((System.in)));
        /* Чтение из сокета */
        String login = in.readLine();
        System.out.println(login); //Login:
        /* Прием login */
        String logName = stdin.readLine();
        out.println(logName);
        /* Чтение из сокета */
        String password = in.readLine();
        System.out.println(password);
        /* Прием password */
        String pass = stdin.readLine();
        out.println(pass);
        String str = in.readLine();
        System.out.println(str);
        while ((str = stdin.readLine()) != null) {
            out.println(str);
            System.out.println(in.readLine());
            if (str.equals("Bye"))
                break;
        }

        out.close();
        in.close();
        stdin.close();
    }
}
