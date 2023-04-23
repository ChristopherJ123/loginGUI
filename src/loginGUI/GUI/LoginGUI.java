package loginGUI.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Arrays;


public class LoginGUI extends JFrame implements ActionListener, KeyListener, MouseListener {

    LoginService loginService = new LoginService();

    JPanel usernamePanel;
    JPanel passwordPanel;
    JPanel panel13;
    JPanel signinPanel;
    JButton signinButton;
    JTextField userNameTextField;
    JPasswordField passwordTextField;
    JLabel staticLabel;
    JLabel registerLabel;

    char[] password = {'t', 'o', 't', 'o'};

    public LoginGUI() {
        userNameTextField = new JTextField();
        userNameTextField.setPreferredSize(new Dimension(250,40));
        userNameTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        userNameTextField.addKeyListener(this);

        passwordTextField = new JPasswordField();
        passwordTextField.setPreferredSize(new Dimension(250,40));
        passwordTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordTextField.addKeyListener(this);

        usernamePanel = new JPanel();
        usernamePanel.setLayout(new BorderLayout());
        staticLabel = new JLabel("Username");
        usernamePanel.add(staticLabel);
        usernamePanel.add(userNameTextField, BorderLayout.EAST);

        passwordPanel = new JPanel();
        passwordPanel.setLayout(new BorderLayout());
        staticLabel = new JLabel("Password");
        passwordPanel.add(staticLabel);
        passwordPanel.add(passwordTextField, BorderLayout.EAST);

        panel13 = new JPanel();
        registerLabel = new JLabel("<HTML><U>Don't have an account? Register now!</U></HTML>");
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.setFont(new Font(null, Font.PLAIN, 12));
        registerLabel.addMouseListener(this);
        panel13.add(registerLabel);

        signinPanel = new JPanel();
        signinPanel.setLayout(new FlowLayout());
        signinButton = new JButton("Login");
        signinButton.addActionListener(this);
        signinPanel.add(signinButton);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new GridLayout(4,1,5,5));

        this.add(usernamePanel);
        this.add(passwordPanel);
        this.add(panel13);
        this.add(signinPanel);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.addKeyListener(this);
    }

    public void login(String username, char[] password) {
        if (username.equals("christopherj") && Arrays.equals(password, this.password)) {
            JOptionPane.showMessageDialog(null, "Welcome user", "Login success", JOptionPane.PLAIN_MESSAGE);
            this.dispose();
        } else if (username.length() == 0 || password.length == 0) {
            JOptionPane.showMessageDialog(null, "Field cannot be empty!", "Login failed", JOptionPane.WARNING_MESSAGE);
        } else
            JOptionPane.showMessageDialog(null, "Login failed", "Login failed", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        LoginGUI loginGUIInitiate = new LoginGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signinButton) {
            login(userNameTextField.getText(), passwordTextField.getPassword());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            if (loginService.textFieldNotEmpty(userNameTextField.getText(), new String(passwordTextField.getPassword())) && loginService.fileExists()) {
                if (loginService.fileExists()) {
                    if (loginService.usernameMatchPassword(userNameTextField.getText(), new String(passwordTextField.getPassword()))) {
                        System.out.println("Login successful");
                    }
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == registerLabel) {
            registerLabel.setEnabled(false);
            this.setEnabled(false);
            new RegisterGUI();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == registerLabel) {
            registerLabel.setForeground(Color.BLUE);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == registerLabel) {
            registerLabel.setForeground(Color.BLACK);
        }
    }
}
