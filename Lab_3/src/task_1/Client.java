package task_1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) {
        new Client(args[0]);
    }

    public Client(String host) {
        Socket socket;
        try {
            socket = new Socket(host, Server.PORT_NUMBER);
        }
        catch(UnknownHostException ex) {
            System.out.println(host + " is not a valid host name.");
            return;
        }
        catch(IOException ex) {
            System.out.println("Error communicating with " + host);
            return;
        }
        // … initialize model, GUI, etc. ...
        InputStream in = null;
        OutputStream out = null;
        Scanner scanner = new Scanner(System.in);
        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();
            String message;

            BufferedReader inReader = new BufferedReader(new InputStreamReader(in));
            PrintWriter outWriter = new PrintWriter(out, true);

            String greetingMessage = inReader.readLine();
            System.out.println(greetingMessage);

            while (true) {
                // readLine blocks until a line-terminated string is available
                message = scanner.nextLine();
                outWriter.println(message);
                // readLine returns null if the client just presses <return>
                String inLine = inReader.readLine();
                if (inLine != null) {
                    if (inLine.trim().equalsIgnoreCase("bye")) {
                        break;
                    }
                    System.out.println(inLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static String getIPByHostName(String hostName) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName(hostName);
        return inetAddress.getHostAddress();
    }


    private static String getNameByHostIP(String ip) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName(ip);
        return inetAddress.getHostName();
    }


    private static String getHostByDatagramPacket(DatagramPacket datagramPacket) {
        return datagramPacket.getAddress().getHostAddress();
    }

    private static String getHostBySocket(Socket socket) {
        return socket.getInetAddress().getHostAddress();
    }

    private static String getLocalAddress() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostAddress();
    }
}
