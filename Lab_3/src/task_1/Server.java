package task_1;

import java.io.*;
import java.net.*;

public class Server extends Thread  {
    public static final int PORT_NUMBER = 8888;
    protected Socket socket;

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT_NUMBER);
            while (true) {
                new Server(server.accept());
            }
        }
        catch(IOException ex) {
            System.out.println("Unable to start server or accept connections");
            System.exit(1);
        }
        finally {
            try {
                server.close();
            }
            catch(IOException ex) {
                // not much can be done: log the error
                // exits since this is the end of main
            }
        }
    }

    private Server(Socket socket) {
        this.socket = socket;
        start();
    }

    // the server services client requests in the run method
    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();

            BufferedReader inReader = new BufferedReader(new InputStreamReader(in));
            // the constructor argument “true” enables auto-flushing
            PrintWriter outWriter = new PrintWriter(out, true);
            outWriter.println("Echo server: enter \"bye\" to exit.");
            while (true) {
                // readLine blocks until a line-terminated string is available
                String inLine = inReader.readLine();
                // readLine returns null if the client just presses <return>
                if (inLine != null) {
                    if (inLine.trim().equalsIgnoreCase("bye=")) {
                        break;
                    }
                    System.out.println(inLine);
                    outWriter.println("Echo: " + inLine);
                }
            }

        }
        catch(IOException ex) {
            System.out.println("Unable to get streams from client");
            ex.printStackTrace();
        }
        finally {
            try {
                in.close();
                out.close();
                socket.close();
            }
            catch(IOException ex) {
                // not much can be done: log the error
            }
        }
    }
}
