package ru.project.business;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UserIO {
    public static void add(User user, String filepath) throws IOException {
        File file = new File(filepath);
        FileOutputStream outputStream = new FileOutputStream(file, true);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        out.println(user.getFirstName() + "|"+ user.getLastName()+ "|"+user.getEmailAddress() + "|" );
        out.close();
    }
    public static ArrayList<User> getUsers(String filepath) {
        ArrayList<User> products = new ArrayList<User>();
        File file = new File(filepath);
        try {
            InputStream inputStream = new FileInputStream(file);
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String firstName = t.nextToken();
                String lastName = t.nextToken();
                String emailAddress = t.nextToken();
                User p = new User();
                p.setFirstName(firstName);
                p.setLastName(lastName);
                p.setEmailAddress(emailAddress);
                products.add(p);
                line = in.readLine();
            }
            in.close();
            return products;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
