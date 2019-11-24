package task_1.HTTP;

import java.net.*;
import java.io.*;
import java.nio.charset.Charset;

public class URLDemo
{
    public static void main(String args[]) throws Exception
    {
        try
        {
	    /* Проверка введенных параметров в строке
            if (args.length != 1)
            {
                 // Выводится сообщение, пвуза на реакцию и exit
                 System.err.println ("Invalid command parameters");
                 System.in.read();
                 System.exit(0);
            }*/
            // Создаем экземпляр ссылки task_1.URL
            URL url = new URL ("http://aad.vuztc.ru");//(args[0]);

            // Получаем входной поток для чтения
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("UTF-16")));

            String inputString;
            while((inputString = in.readLine()) != null) {
                System.out.println(inputString);
            }

        }
        catch (MalformedURLException mue)
        {
            System.err.println ("Invalid task_1.URL");
        }
        catch (IOException ioe)
        {
            System.err.println ("I/O Error - " + ioe);
        }
    }
}
