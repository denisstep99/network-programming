package task_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader fromUserReader = new BufferedReader(new InputStreamReader(System.in));
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] sendData;
            byte[] receiveData = new byte[65];

            while(true)
            {
                System.out.println("Type your message: ");
                String clientMessage = fromUserReader.readLine();
                sendData = clientMessage.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 3443);
                socket.send(sendPacket);

                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String serverSentence = new String(receivePacket.getData());

                System.out.println("Server's answer:");
                System.out.println(serverSentence + "\n\n");
            }
        }

        catch(Exception e)
        {
            e.getMessage();
        }
    }
}
