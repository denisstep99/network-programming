package task_6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Простой на основе Swing клиент для чат-сервера. Графически
 * это фрейм с текстовым полем для ввода сообщения и
 * текстовая область для просмотра всего диалога.
 *
 * Клиент следует протоколу чата, который выглядит следующим образом.
 * Когда сервер передает "SUBMITNAME" клиент устанваливает
 * псевдоним. Сервер будет продолжать посылать "SUBMITNAME"
 * запросы до тех пор, как клиент представляет экранные имена, которые
 * Уже используется. Когда сервер отправляет строку, начинающуюся
 * С "NAMEACCEPTED" клиенту теперь разрешено начать
 * отправки серверу произвольные строки, которая будет транслироваться для всех
 * участникам, подключенные к серверу. Когда сервер посылает
 * строку, начинающаяся с "MESSAGE", то все символы, следующие
 * за этой строкой должны отображаться в области сообщений.
 */
public class ChatClient {

    BufferedReader in;
    PrintWriter out;
    JFrame frame = new JFrame("Chatter");
    JTextField textField = new JTextField(40);
    JTextArea messageArea = new JTextArea(8, 40);

    /**
     * Конструктор клиента  определяет  GUI и регистрирует
     * listener на  textfield, чтобы нажатие Return в
     * listener отправляло содержимое textfield на сервер.
     * Однако первоначально textfield нередактируемое , и
     *становится редактируемым ьолько после того, как клиент получил
     * сообщение NAMEACCEPTED от сервера.
     */
    public ChatClient() {

        // Layout GUI
        textField.setEditable(false);
        messageArea.setEditable(false);
        frame.getContentPane().add(textField, "North");
        frame.getContentPane().add(new JScrollPane(messageArea), "Center");
        frame.pack();

        // Add Listeners
        textField.addActionListener(new ActionListener() {
            /**
             * Отвечает на нажатие ENTER  в  textfield отправляя
             * содержимое текстового поля на сервер.    После чего
             * текстовое поле готовится для следующего сообщения.
             */
            public void actionPerformed(ActionEvent e) {
                out.println(textField.getText());
                textField.setText("");
            }
        });
    }

    /**
     * Prompt for and return the address of the server.
     */
    private String getServerAddress() {
        return JOptionPane.showInputDialog(
                frame,
                "Введите IP адрес сервера:",
                "Добро пожаловать",
                JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * Предлагает ввести псевдоним.
     */
    private String getName() {
        return JOptionPane.showInputDialog(
                frame,
                "Введите псевдоним:",
                "Выбор псевдонима",
                JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Соединяемся с сервером и входим в цикл.
     */
    private void run() throws IOException {

        // Make connection and initialize streams
        String serverAddress = getServerAddress();
        Socket socket = new Socket(serverAddress, 9001);
        in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        // Обработка всех сообщений с сервера по протоколу.
        while (true) {
            String line = in.readLine();
            if (line.startsWith("SUBMITNAME")) {
                out.println(getName());
            } else if (line.startsWith("NAMEACCEPTED")) {
                textField.setEditable(true);
            } else if (line.startsWith("MESSAGE")) {
                messageArea.append(line.substring(8) + "\n");
            }
        }
    }

    /**
     * Запускается клиент как приложение с фреймом.
     */
    public static void main(String[] args) throws Exception {
        ChatClient client = new ChatClient();
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.setVisible(true);
        client.run();
    }
}

