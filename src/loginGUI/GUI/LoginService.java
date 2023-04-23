package loginGUI.GUI;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LoginService {

    public boolean textFieldNotEmpty(String username, String password) {
        if (username.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null, "Field cannot be empty!", "Login failed", JOptionPane.WARNING_MESSAGE);
            return false;
        } else
            return true;
    }

    public boolean textFieldNotEmpty(String email, String username, String password, String repassword) {
        if (email.equals("") || username.equals("") || password.equals("") || repassword.equals("")) {
            JOptionPane.showMessageDialog(null, "Field cannot be empty!", "Register failed", JOptionPane.WARNING_MESSAGE);
            return false;
        } else
            return true;
    }

    public boolean reenterPasswordIsSame(String password, String repassword) {
        if (!repassword.equals(password)) {
            JOptionPane.showMessageDialog(null, "Password is not the same!", "Register failed", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else return true;
    }

    public void createFile() {
        try {
            File myFile = new File("src\\loginGUI\\UserInfo\\UserInfo.txt");
            myFile.getParentFile().mkdirs();
            if (myFile.createNewFile()) {
                System.out.println("File creation success");
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("File error occurred");
            e.printStackTrace();
        }
    }

    public boolean fileExists() {
        File myFile = new File("src\\loginGUI\\UserInfo\\UserInfo.txt");
        if (myFile.exists());
        else JOptionPane.showMessageDialog(null, "Credential file does not exist", "Login Failed", JOptionPane.ERROR_MESSAGE);
        return myFile.exists();
    }

    public void writeFile(String email, String username, String password) {
        try {
            FileWriter myWriter = new FileWriter("src\\loginGUI\\UserInfo\\UserInfo.txt");
            myWriter.write("email=" +email + " username=" + username + " password=" + password);
            myWriter.close();
            System.out.println("Write success");
        } catch (IOException e) {
            System.out.println("Write error occurred");
            e.printStackTrace();
        }
    }

    public boolean usernameMatchPassword(String username, String password) {
        boolean foundMatch = false;
        try {
            File myFile = new File("src\\loginGUI\\UserInfo\\UserInfo.txt");
            Scanner myReader = new Scanner("src\\loginGUI\\UserInfo\\UserInfo.txt");
            String myFileToString = Files.readString(myFile.toPath());

            Map<String, String> fileMap = Arrays.stream(myFileToString.split(" ")).map(s -> s.split("="))
                    .collect(Collectors.toMap(
                            a -> a[0],
                            a -> a[1]
                    ));
            //IDK logic behind this code^ (src stackoverflow)

            if (username.equals(fileMap.get("username")) && password.equals(fileMap.get("password"))) {
                JOptionPane.showMessageDialog(null, "Login Successful", "Login Successful", JOptionPane.PLAIN_MESSAGE);
                foundMatch = true;
            } else
                JOptionPane.showMessageDialog(null, "Login Failed", "Login Failed", JOptionPane.ERROR_MESSAGE);
            myReader.close();
        } catch (IOException e) {
            System.out.println("Error on usernameMatchPassword method");
            e.printStackTrace();
        }
        return foundMatch;
    }

}
