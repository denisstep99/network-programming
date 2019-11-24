package task_1;

import java.net.*;

class InetAddressClass {
    public static void main(String arg[]) throws SocketException {
        try {
            /*
             * Создается объект InetAddress, используя getLocalHost()
             * статический метод класса InetAddress
             */
            InetAddress address = InetAddress.getLocalHost();
            /* Получение IP адреса хоста */
            String addressHost = address.getHostAddress();
            /* Вывод IP адреса хоста */
            System.out.println("Вывод IP адреса хоста " + addressHost);
            // Вывод имени хоста
            System.out.println("Вывод имени хоста " + address.getHostName());
            byte[] addressParts = address.getAddress();
            for (byte part : addressParts) {
                System.out.println("Вывод массива " + (part & 0xff));
            }
        } catch (UnknownHostException e) {
            System.out.println("Error");
        }
    }
}
