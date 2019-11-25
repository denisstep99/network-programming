package ru.ifmo;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class UserIO {
    public static void add(User user, String filepath) throws IOException {
        File file = new File(filepath);
        FileOutputStream outputStream = new FileOutputStream(file, true);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        out.println(user.getEmailAddress() + " | " + user.getFirstName() + " | "
                + user.getLastName());
        out.close();
    }
}
