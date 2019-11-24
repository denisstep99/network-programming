package task_5;

import java.io.*;
import java.net.*;

public class EchoClientThread {
    public static void main(String[] args) throws IOException {

        String serverHostname = new String ("localhost");

        System.out.println ("Попытка соединиться с хостом  " +
                serverHostname + " на порт 1037.");

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket(serverHostname, 1037);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Не известен хост: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Не проходит I/O "
                    + "соединение на: " + serverHostname);
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;

        System.out.println ("Введите сообщение (\"Bye.\" для выхода)");
        while ((userInput = stdIn.readLine()) != null)
        {
            out.println(userInput);

            // end loop
            if (userInput.equals("Bye."))
                break;

            System.out.println("echo: " + in.readLine());
        }

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}
