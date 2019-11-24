package task_2;

import javafx.util.Pair;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Scanner;

public class IPChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Введите имя хоста или IP адрес: ");
            input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            try {
                Pair answer = getHostInfo(input);
                System.out.println("Имя хоста: " + answer.getKey());
                System.out.println("IP адрес хоста: " + answer.getValue());
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }

    private static Pair<String, String> getHostInfo(String hostName) throws UnknownHostException {
        InetAddress address = InetAddress.getByName(hostName);
        return new Pair<>(
                address.getHostName(),
                address.getHostAddress()
        );
    }
}
