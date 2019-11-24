package task_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ChatClient
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        try (DatagramSocket clientSocket = new DatagramSocket())
        {
            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] sendData = new byte[65];
            byte[] receiveData = new byte[65];

            System.out.println("Enter a username: ");
            String clientUsername = inFromUser.readLine();

            System.out.println("Send message...");

            while(true)
            {
                System.out.print("Me: ");
                String clientSentence = clientUsername + ": " + inFromUser.readLine();
                sendData = clientSentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 8877);
                clientSocket.send(sendPacket);

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                String serverSentence = new String(receivePacket.getData());

                System.out.println(serverSentence);
            }
        }

        catch(Exception e)
        {
            e.getMessage();
        }
    }
}
