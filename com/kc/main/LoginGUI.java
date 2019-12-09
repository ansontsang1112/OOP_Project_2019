package com.kc.main;

import com.anson.main.LoginManager;
import com.anson.main.enums.LoginStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class LoginGUI extends JFrame implements ActionListener {
    JPanel panel;
    JLabel user_label, password_label, message;
    JTextField userName_text;
    JPasswordField password_text;
    JButton submit, cancel;
    JPanel panelTop = new JPanel();
    JButton butAboutMe = new JButton("About US");

    JButton LogIn = new JButton("login");
    JLabel labelImg = new JLabel(); // label to show image
    JScrollPane sPImg = new JScrollPane(labelImg); //
    JLabel labelStatus = new JLabel(); // label to show status info

    BufferedImage orgImg;

    public LoginGUI() { // A No-Argument Constructor
        setTitle("MyName Image Viewer");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initGUI();
    }

    void initGUI(){ // Method for initializing GUI (layout, components)
        add(LogIn, BorderLayout.NORTH);
        add(butAboutMe, BorderLayout.NORTH);
        add(sPImg, BorderLayout.CENTER);
        add(labelStatus, BorderLayout.SOUTH);

        butAboutMe.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent event) {
// show AboutMe Message Dialog window
                JOptionPane.showMessageDialog(null,
                        "Members(left to right):\n" +
                                "MyName(ME)\n CHAN Chung Man\n CHAN Siu Man",
                        "About Me: G22m2, 2019-2020, OOP",
                        JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon("AboutMe.jpg"));
            } });
    }
    



    public void login() {
        // Username Label
        user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField();

        // Password Label

        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField();

        // Submit

        submit = new JButton("SUBMIT");

        panel = new JPanel(new GridLayout(3, 1));
        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);

        message = new JLabel();
        panel.add(message);
        panel.add(submit);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adding the listeners to components..
        submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Please Login Here !");
        setSize(450, 350);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String username = userName_text.getText();
        String password = password_text.getText();

        try {
            if (LoginManager.authentication(username, password) == LoginStatus.LOGIN_SUCCESS) {
                message.setText(" Hello " + LoginManager.currentLoginUsername + "");
            } else {
                message.setText(" Invalid user .. Please Try Again");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
