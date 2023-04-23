package loginGUI.GUI;

import loginGUI.Constants.AppConstants;

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
        if (username.contains(" ") || password.contains(" ")) {
            JOptionPane.showMessageDialog(null, AppConstants.FIELD_CANNOT_USE_SPACES, AppConstants.REGISTER_FAILED, JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (username.equals("") || password.equals("")) {
            JOptionPane.showMessageDialog(null, AppConstants.FIELD_CANNOT_BE_EMPTY, AppConstants.LOGIN_FAILED, JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean textFieldNotEmpty(String email, String username, String password, String repassword, boolean checkboxed) {
        if (email.contains(" ") || username.contains(" ") || password.contains(" ") || repassword.contains(" ")) {
            JOptionPane.showMessageDialog(null, AppConstants.FIELD_CANNOT_USE_SPACES, AppConstants.REGISTER_FAILED, JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (email.equals("") || username.equals("") || password.equals("") || repassword.equals("")) {
            JOptionPane.showMessageDialog(null, AppConstants.FIELD_CANNOT_BE_EMPTY, AppConstants.REGISTER_FAILED, JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (!checkboxed) {
            JOptionPane.showMessageDialog(null, AppConstants.TOS_CANNOT_BE_EMPTY, AppConstants.REGISTER_FAILED, JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean reenterPasswordIsSame(String password, String repassword) {
        if (!repassword.equals(password)) {
            JOptionPane.showMessageDialog(null, AppConstants.PASSWORD_IS_NOT_SAME, AppConstants.REGISTER_FAILED, JOptionPane.WARNING_MESSAGE);
            return false;
        }
        else return true;
    }

    public void createFile() {
        try {
            File myFile = new File(AppConstants.PATH);
            if (myFile.getParentFile().mkdirs()) System.out.println("UserInfo directory created successfully");
            else System.out.println("UserInfo directory already exist");
            if (myFile.createNewFile()) System.out.println("UserInfo.txt file created successfully");
            else System.out.println("Userinfo.txt file already exist");
        } catch (IOException e) {
            System.out.println("File error occurred");
            e.printStackTrace();
        }
    }

    public boolean fileExists() {
        File myFile = new File(AppConstants.PATH);
        if (myFile.exists()) return true;
        else JOptionPane.showMessageDialog(null, AppConstants.CREDENTIALS_NOT_EXIST, AppConstants.LOGIN_FAILED, JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public void writeFile(String email, String username, String password) {
        try {
            FileWriter myWriter = new FileWriter(AppConstants.PATH, true);
            myWriter.append(email).append(" ").append(username).append(" ").append(password).append(System.lineSeparator());
            myWriter.close();
            System.out.println("Userinfo.txt written successfully");
            JOptionPane.showMessageDialog(null, AppConstants.REGISTER_SUCCESSFUL, AppConstants.REGISTER_SUCCESSFUL, JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            System.out.println("Userinfo.txt write error occurred");
            e.printStackTrace();
        }
    }

    public void storeDataFromFile() {
        try {
            File myFile = new File(AppConstants.PATH);
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
            System.out.println("storeDataFromFile() error occurred");
        }
    }

    public boolean usernameMatchPassword(String username, String password) {
        storeDataFromFile(); //Re-store data from file
        if (usernames.contains(username)) {
            int line = usernames.indexOf(username);
            if (password.equals(passwords.get(line))) {
                JOptionPane.showMessageDialog(null, AppConstants.LOGIN_SUCCESSFUL, AppConstants.LOGIN_SUCCESSFUL, JOptionPane.PLAIN_MESSAGE);
                return true;
            } else
                JOptionPane.showMessageDialog(null, AppConstants.WRONG_PASSWORD, AppConstants.LOGIN_FAILED, JOptionPane.ERROR_MESSAGE);
        } else
            JOptionPane.showMessageDialog(null, AppConstants.USERNAME_NOT_EXIST, AppConstants.LOGIN_FAILED, JOptionPane.ERROR_MESSAGE);
        return false;
    }

}
