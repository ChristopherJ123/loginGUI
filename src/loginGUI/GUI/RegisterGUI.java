package loginGUI.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RegisterGUI extends JFrame implements KeyListener {

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
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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

    }
}
