package loginGUI.Constants;

import java.io.File;

public class AppConstants {
    public static final boolean DEBUG = false; // WIP For System.out.println() functions

    public static final String PATH = "src" + File.separator + "loginGUI" + File.separator + "UserInfo" + File.separator + "UserInfo.txt";

    public static final String TITLE_LOGIN = "Login";
    public static final String TITLE_REGISTER = "Register";

    public static final String FIELD_CANNOT_BE_EMPTY = "Field cannot be empty!";
    public static final String FIELD_CANNOT_USE_SPACES = "Spaces are not allowed here!";
    public static final String TOS_CANNOT_BE_EMPTY = "TOS must be accepted!";
    public static final String PASSWORD_IS_NOT_SAME = "Password is not the same!";
    public static final String USERNAME_NOT_EXIST = "Username does not exist!";
    public static final String CREDENTIALS_NOT_EXIST = "Credential file does not exist please register.";
    public static final String WRONG_PASSWORD = "Wrong password";
    public static final String LOGIN_SUCCESSFUL = "Login successful";
    public static final String LOGIN_FAILED = "Login failed";
    public static final String REGISTER_SUCCESSFUL = "Register successful";
    public static final String REGISTER_FAILED = "Register failed";
    public static final String ERROR_OCCURRED = "An error occurred!";

}
