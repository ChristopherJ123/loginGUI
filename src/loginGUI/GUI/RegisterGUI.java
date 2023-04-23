package loginGUI.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class RegisterGUI extends JFrame implements KeyListener, WindowListener {

    LoginService loginService = new LoginService();

    JPanel body;
    JPanel[] panel;

    JLabel staticLabel;

    JButton createAccountButton;

    JTextField emailTextField;
    JTextField usernameTextField;
    JTextField passwordTextField;
    JTextField reenterPasswordTextField;

    JCheckBox eulaCheckBox;

    RegisterGUI() {
        panel = new JPanel[7];

        emailTextField = new JTextField();
        emailTextField.setPreferredSize(new Dimension(250,40));
        emailTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        emailTextField.addKeyListener(this);

        usernameTextField = new JTextField();
        usernameTextField.setPreferredSize(new Dimension(250,40));
        usernameTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        usernameTextField.addKeyListener(this);

        passwordTextField = new JTextField();
        passwordTextField.setPreferredSize(new Dimension(250,40));
        passwordTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        passwordTextField.addKeyListener(this);

        reenterPasswordTextField = new JTextField();
        reenterPasswordTextField.setPreferredSize(new Dimension(250,40));
        reenterPasswordTextField.setFont(new Font("Arial", Font.PLAIN, 16));
        reenterPasswordTextField.addKeyListener(this);

        eulaCheckBox = new JCheckBox();

        panel[0] = new JPanel();
        staticLabel = new JLabel("Registration");
        panel[0].setLayout(new FlowLayout());
        panel[0].add(staticLabel);

        panel[1] = new JPanel();
        staticLabel = new JLabel("Email");
        panel[1].setLayout(new GridLayout(1,2));
        panel[1].add(staticLabel);
        panel[1].add(emailTextField);

        panel[2] = new JPanel();
        staticLabel = new JLabel("Username");
        panel[2].setLayout(new GridLayout(1,2));
        panel[2].add(staticLabel);
        panel[2].add(usernameTextField);

        panel[3] = new JPanel();
        staticLabel = new JLabel("Password");
        panel[3].setLayout(new GridLayout(1,2));
        panel[3].add(staticLabel);
        panel[3].add(passwordTextField);

        panel[4] = new JPanel();
        staticLabel = new JLabel("Re-enter Password");
        panel[4].setLayout(new GridLayout(1,2));
        panel[4].add(staticLabel);
        panel[4].add(reenterPasswordTextField);

        panel[5] = new JPanel();
        staticLabel = new JLabel("Agree terms of service");
        panel[5].setLayout(new FlowLayout());
        panel[5].add(staticLabel);
        panel[5].add(eulaCheckBox);

        panel[6] = new JPanel();
        createAccountButton = new JButton("Create account");
        panel[6].setLayout(new FlowLayout());
        panel[6].add(createAccountButton);

        body = new JPanel();
        body.setLayout(new GridLayout(7,1));
        body.add(panel[0]);
        body.add(panel[1]);
        body.add(panel[2]);
        body.add(panel[3]);
        body.add(panel[4]);
        body.add(panel[5]);
        body.add(panel[6]);


        this.setTitle("setTitle goes here");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(this);
        this.setResizable(true);
        this.setVisible(true);
        this.add(body);
        this.pack();

        ImageIcon icon = new ImageIcon("icon.jpg");
        this.setIconImage(icon.getImage());
    }

    public static void main(String[] args) {
        new RegisterGUI();
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
            if(loginService.textFieldNotEmpty(emailTextField.getText(), usernameTextField.getText(),
                    passwordTextField.getText(), reenterPasswordTextField.getText())) {
                if (loginService.reenterPasswordIsSame(passwordTextField.getText(), reenterPasswordTextField.getText())) {
                    loginService.createFile();
                    loginService.writeFile(emailTextField.getText(), usernameTextField.getText(),
                            passwordTextField.getText());
                }
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {
        new LoginGUI();
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
