package task_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatServer implements Runnable {
    public static void main(String[] args) throws Exception {
        new Thread(new ChatServer()).start();
    }

    @Override
    public void run() {
        try {
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

            DatagramSocket serverSocket = new DatagramSocket(8877);

            byte[] receiveData = new byte[65];
            byte[] sendData = new byte[65];

            System.out.println("Enter a username: ");
            String serverUsername = inFromUser.readLine();

            System.out.println("Send message...");

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String clientSentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println(clientSentence);

                InetAddress IPAddress = receivePacket.getAddress();

                int port = receivePacket.getPort();

                System.out.print("Me: ");
                String serverSentence = serverUsername + ": " + inFromUser.readLine();

                sendData = serverSentence.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                serverSocket.send(sendPacket);
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

