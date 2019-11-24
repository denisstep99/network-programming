package task_5;

import java.net.*;
import java.io.*;

public class EchoServerThread extends Thread
{
    protected Socket clientSocket;
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(1037);
            System.out.println ("Создется соединение сокета");
            try {
                while (true)
                {
                    System.out.println ("Ожидание соединения");
                    new EchoServerThread (serverSocket.accept());
                }
            }
            catch (IOException e)
            {
                System.err.println("Accept сбой.");
                System.exit(1);
            }
        }
        catch (IOException e)
        {
            System.err.println("Не прослушивается порт: 1037.");
            System.exit(1);
        }
        finally
        {
            try {
                assert serverSocket != null;
                serverSocket.close();
            }
            catch (IOException e)
            {
                System.err.println("Не закрывается порт: 1037.");
                System.exit(1);
            }
        }
    }

    private EchoServerThread (Socket clientSoc)
    {
        clientSocket = clientSoc;
        start();
    }

    public void run()
    {
        System.out.println ("Стартовал поток нового соединения");

        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
                    true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader( clientSocket.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null)
            {
                System.out.println ("Server: " + inputLine);
                StringBuilder sb = new StringBuilder(inputLine).reverse();
                out.println(sb.toString());

                if (inputLine.equals("Bye."))
                    break;
            }

            out.close();
            in.close();
            clientSocket.close();
        }
        catch (IOException e)
        {
            System.err.println("Проблемы с сервером");
            System.exit(1);
        }
    }
}
