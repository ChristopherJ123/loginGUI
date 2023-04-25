package loginGUI.GUI;

import loginGUI.Constants.AppConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;


public class LoginGUI extends JFrame implements ActionListener, KeyListener, MouseListener {

    AppService appService = new AppService();

    JPanel usernamePanel;
    JPanel passwordPanel;
    JPanel panel13;
    JPanel signinPanel;
    JButton signinButton;
    JTextField userNameTextField;
    JPasswordField passwordTextField;
    JLabel staticLabel;
    JLabel registerLabel;

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
        signinButton.setFont(new Font("Arial", Font.BOLD, 16));
        signinButton.setForeground(Color.WHITE);
        signinButton.setBackground(new Color(52, 152, 219)); // set background color to blue
        signinButton.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30)); // add padding
        signinButton.setFocusPainted(false); // remove border focus
        signinButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // change cursor to hand
        signinButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signinButton.setBackground(new Color(41, 128, 185)); // set darker background on hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signinButton.setBackground(new Color(52, 152, 219)); // set default background on exit
            }
        });
        signinButton.addActionListener(this);
        signinPanel.add(signinButton);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new GridLayout(4,1,5,5));
        this.setTitle(AppConstants.TITLE_LOGIN);

        this.add(usernamePanel);
        this.add(passwordPanel);
        this.add(panel13);
        this.add(signinPanel);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signinButton) {
            if (appService.fileExists()) {
                if (appService.textFieldNotEmpty(userNameTextField.getText(), new String(passwordTextField.getPassword())) && appService.fileExists()) {
                    if (appService.usernameMatchPassword(userNameTextField.getText(), new String(passwordTextField.getPassword()))) {
                        System.out.println("Login successful");
                    }
                }
            }
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
            if (appService.fileExists()) {
                if (appService.textFieldNotEmpty(userNameTextField.getText(), new String(passwordTextField.getPassword())) && appService.fileExists()) {
                    if (appService.usernameMatchPassword(userNameTextField.getText(), new String(passwordTextField.getPassword()))) {
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
