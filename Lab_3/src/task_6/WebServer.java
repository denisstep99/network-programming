package task_6;

import java.io.*;
import java.net.*;
import java.util.*;

class WebServer
{
    public static void main (String args[]) throws Exception
    {
        String requestMessageLine;
        String fileName;

        // Проверка введенного в аргументе номера порта
        // если аргумент отсутствует, используется порт 6789
        int myPort = 6789;
        if (args.length > 0)
        {
            try {
                myPort = Integer.parseInt(args[0]);
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Требуется номер порта в качествеаргумента");
                System.exit(-1);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Вводите номер порта как целое.");
                System.exit(-1);
            }
        }

        // установка сокета соединения
        ServerSocket listenSocket = new ServerSocket (myPort);

        // прослушиваем (т.е. ожидаем) запроса на соединение
        System.out.println ("Web server waiting for request on port " + myPort);
        Socket connectionSocket = listenSocket.accept();

        // set up the read and write end of the communication socket
        BufferedReader inFromClient = new BufferedReader (
                new InputStreamReader(connectionSocket.getInputStream()));
        DataOutputStream outToClient = new DataOutputStream (
                connectionSocket.getOutputStream());

        // получает первую строку для разбора
        requestMessageLine = inFromClient.readLine();
        System.out.println ("Request: " + requestMessageLine);
        StringTokenizer tokenizedLine = new StringTokenizer(requestMessageLine);

        // проверка напроса GET
        if (tokenizedLine.nextToken().equals("GET"))
        {
            fileName = tokenizedLine.nextToken();

            // удаляет первый слеш из строки, если он есть
            if (fileName.startsWith("/") == true)
                fileName = fileName.substring(1);
            System.out.println("fileName " + fileName);
            // доступ на запрошенный файл
            File file = new File(fileName);

            // конвертируем файл в массив байтов
            int numOfBytes = (int) file.length(); // длина файла
            FileInputStream inFile = new FileInputStream (fileName);
            byte[] fileInBytes = new byte[numOfBytes];
            inFile.read(fileInBytes);

            // Отправляем ответ
            outToClient.writeBytes ("HTTP/1.0 200 Document Follows\r\n");
            if (fileName.endsWith(".jpg"))
                outToClient.writeBytes ("Content-Type: image/jpeg\r\n");
            if (fileName.endsWith(".gif"))
                outToClient.writeBytes ("Content-Type: image/gif\r\n");
            outToClient.writeBytes ("Content-Length: " + numOfBytes + "\r\n");
            outToClient.writeBytes ("\r\n");
            outToClient.write(fileInBytes, 0, numOfBytes);

            // Читаем и выврдим  оставшиеся строки запроса
            requestMessageLine = inFromClient.readLine();
            while (requestMessageLine.length() >= 5)
            {
                System.out.println ("Request: " + requestMessageLine);
                requestMessageLine = inFromClient.readLine();
            }
            System.out.println ("Request: " + requestMessageLine);

            connectionSocket.close();
        }
        else
        {
            System.out.println ("Bad Request Message");
        }
    }
}
