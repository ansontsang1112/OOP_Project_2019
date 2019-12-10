package com.kc.main;

import com.anson.main.G22LoginManager;
import com.anson.main.enums.G22LoginStatus;
import com.group.main.G22HomePageGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginGUI extends JFrame implements ActionListener {
    JPanel panel;
    JLabel user_label, password_label, message;
    JTextField userName_text;
    JPasswordField password_text;
    JButton submit, cancel;

    public LoginGUI() {
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

        String ADM = "";
        if(G22HomePageGUI.ADM) {
            ADM = "Administrator";
        } else {
            ADM = "Customer";
        }

        // Adding the listeners to components..
        submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Login Page for " + ADM + " - WF Gaming Training Center");
        setSize(450, 350);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String username = userName_text.getText();
        String password = password_text.getText();

        try {
            if (G22LoginManager.authentication(username, password) == G22LoginStatus.LOGIN_SUCCESS) {
                setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                setVisible(false);
                dispose();
                ControlPanelGUI.ControlPanelGUIEXE();
            } else {
                message.setText(" Invalid user .. Please Try Again");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
