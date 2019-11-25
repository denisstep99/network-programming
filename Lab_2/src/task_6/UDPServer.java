package task_6;

import task_4.ChatServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UDPServer implements Runnable {
    private int port;
    private String name;

    UDPServer(String name, int port) {
        this.name = name;
        this.port = port;
    }

    UDPServer(String name) {
        this(name, 3443);
    }

    UDPServer(int port) {
        this("Unnamed", port);
    }

    UDPServer() {
        this(3443);
    }

    public static void main(String[] args) {
        new Thread(new UDPServer()).start();
    }

    @Override
    public void run() {
        try (DatagramSocket socket = new DatagramSocket(this.port)){
            String answer;

            byte[] receiveData = new byte[65];
            byte[] sendData;

            System.out.println("Starting server " + this.name + " on port " + this.port);

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                answer = new String(receivePacket.getData()).toUpperCase();
                sendData = answer.getBytes();

                int port = receivePacket.getPort();
                socket.send(new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), port));
            }
        } catch (IOException e) {
            Logger.getLogger(ChatServer.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
