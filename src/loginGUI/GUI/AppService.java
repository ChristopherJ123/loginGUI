package loginGUI.GUI;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppService {

    List<String> emails = new ArrayList<>();
    List<String> usernames = new ArrayList<>();
    List<String> passwords = new ArrayList<>();

    public boolean textFieldNotEmpty(String username, String password) {
        if (username.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null, "Field cannot be empty!", "Login failed", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean textFieldNotEmpty(String email, String username, String password, String repassword, boolean checkboxed) {
        if (email.equals("") || username.equals("") || password.equals("") || repassword.equals("")) {
            JOptionPane.showMessageDialog(null, "Field cannot be empty!", "Register failed", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (!checkboxed) {
            JOptionPane.showMessageDialog(null, "TOS must be accepted!", "Register failed", JOptionPane.WARNING_MESSAGE);
            return false;
        }
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
            if (myFile.getParentFile().mkdirs()) System.out.println("UserInfo directory created successfully");
            else System.out.println("UserInfo directory already exist");
            if (myFile.createNewFile()) System.out.println("UserInfo.txt file creation success");
            else System.out.println("Userinfo.txt file already exists");
        } catch (IOException e) {
            System.out.println("File error occurred");
            e.printStackTrace();
        }
    }

    public boolean fileExists() {
        File myFile = new File("src\\loginGUI\\UserInfo\\UserInfo.txt");
        if (myFile.exists()) return true;
        else JOptionPane.showMessageDialog(null, "Credential file does not exist please register.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public void writeFile(String email, String username, String password) {
        try {
            FileWriter myWriter = new FileWriter("src\\loginGUI\\UserInfo\\UserInfo.txt", true);
            myWriter.append(email).append(" ").append(username).append(" ").append(password).append(System.lineSeparator());
            myWriter.close();
            System.out.println("Userinfo.txt write success");
            JOptionPane.showMessageDialog(null, "Regristration success", "Regristration success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            System.out.println("Userinfo.txt write error occurred");
            e.printStackTrace();
        }
    }

    public void storeDataFromFile() {
        try {
            File myFile = new File("src\\loginGUI\\UserInfo\\UserInfo.txt");
            Scanner myReader = new Scanner(myFile);
            for (int j = 0; myReader.hasNext() ; j++) {
                String word = myReader.next();
                if (j % 3 == 0) {
                    int index = j / 3;
                    if (emails.size() <= index) emails.add("");
                    emails.set(index, word);
                }
                else if (j % 3 == 1) {
                    int index = j / 3;
                    if (usernames.size() <= index) usernames.add("");
                    usernames.set(index, word);
                }
                else if (j % 3 == 2) {
                    int index = j / 3;
                    if (passwords.size() <= index) passwords.add("");
                    passwords.set(index, word);
                }
            }
            myReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred");
        }
    }

    public boolean usernameMatchPassword(String username, String password) {
        storeDataFromFile(); //Re-store data from file
        if (usernames.contains(username)) {
            int line = usernames.indexOf(username);
            if (password.equals(passwords.get(line))) {
                JOptionPane.showMessageDialog(null, "Login successful", "Login Successful", JOptionPane.PLAIN_MESSAGE);
                return true;
            } else
                JOptionPane.showMessageDialog(null, "Wrong password", "Login Failed", JOptionPane.ERROR_MESSAGE);
        } else
            JOptionPane.showMessageDialog(null, "Username does not exist", "Login Failed", JOptionPane.ERROR_MESSAGE);
        return false;
    }

}
