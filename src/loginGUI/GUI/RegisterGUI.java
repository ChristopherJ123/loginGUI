package loginGUI.GUI;

import loginGUI.Constants.AppConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterGUI extends JFrame implements ActionListener, KeyListener {

    AppService appService = new AppService();

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
        createAccountButton.addActionListener(this);
        panel[6].setLayout(new FlowLayout());
        panel[6].add(createAccountButton);
        createAccountButton.setFont(new Font("Arial", Font.BOLD, 16));
        createAccountButton.setForeground(Color.WHITE);
        createAccountButton.setBackground(new Color(52, 152, 219)); // set background color to blue
        createAccountButton.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30)); // add padding
        createAccountButton.setFocusPainted(false); // remove border focus
        createAccountButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // change cursor to hand
        createAccountButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createAccountButton.setBackground(new Color(41, 128, 185)); // set darker background on hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                createAccountButton.setBackground(new Color(52, 152, 219)); // set default background on exit
            }
        });

        body = new JPanel();
        body.setLayout(new GridLayout(7,1));
        body.add(panel[0]);
        body.add(panel[1]);
        body.add(panel[2]);
        body.add(panel[3]);
        body.add(panel[4]);
        body.add(panel[5]);
        body.add(panel[6]);


        this.setTitle(AppConstants.TITLE_REGISTER);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.add(body);
        this.pack();
        this.addKeyListener(this);

        ImageIcon icon = new ImageIcon("icon.jpg");
        this.setIconImage(icon.getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createAccountButton) {
            if(appService.textFieldNotEmpty(emailTextField.getText(), usernameTextField.getText(),
                    passwordTextField.getText(), reenterPasswordTextField.getText(), eulaCheckBox.isSelected())) {
                if (appService.reenterPasswordIsSame(passwordTextField.getText(), reenterPasswordTextField.getText())) {
                    appService.createFile();
                    appService.writeFile(emailTextField.getText(), usernameTextField.getText(), passwordTextField.getText());
                    appService.storeDataFromFile();
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
            if(appService.textFieldNotEmpty(emailTextField.getText(), usernameTextField.getText(),
                    passwordTextField.getText(), reenterPasswordTextField.getText(), eulaCheckBox.isSelected())) {
                if (appService.reenterPasswordIsSame(passwordTextField.getText(), reenterPasswordTextField.getText())) {
                    appService.createFile();
                    appService.writeFile(emailTextField.getText(), usernameTextField.getText(), passwordTextField.getText());
                    appService.storeDataFromFile();
                }
            }
        }
    }
}
