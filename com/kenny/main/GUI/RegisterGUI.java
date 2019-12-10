package com.kenny.main.GUI;

import com.anson.main.PasswordManager;
import com.anson.main.enums.PasswordStatus;
import com.anson.main.enums.RegisterStatus;
import com.anson.main.enums.RemovalStatus;
import com.group.main.Utils;
import com.kenny.main.RegisterManager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class RegisterGUI implements ActionListener {

    private JFrame frame;
    private JTextField username;
    private JTextField password;
    private JTextField fullname;
    private JTextField yob;
    private JTextField remark;

    public static void RegisterGUIEXE() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegisterGUI window = new RegisterGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RegisterGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblUsername = new JLabel("username:");
        lblUsername.setBounds(91, 31, 57, 15);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("password:");
        lblPassword.setBounds(91, 56, 46, 15);
        frame.getContentPane().add(lblPassword);

        JLabel lblFullname = new JLabel("fullname:");
        lblFullname.setBounds(91, 81, 46, 15);
        frame.getContentPane().add(lblFullname);

        JLabel lblNewLabel = new JLabel("Year of Birth:");
        lblNewLabel.setBounds(75, 115, 73, 15);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblRemark = new JLabel("remark:");
        lblRemark.setBounds(91, 140, 46, 15);
        frame.getContentPane().add(lblRemark);

        username = new JTextField();
        username.setBounds(142, 28, 168, 21);
        frame.getContentPane().add(username);
        username.setColumns(10);

        password = new JTextField();
        password.setBounds(142, 56, 168, 21);
        frame.getContentPane().add(password);
        password.setColumns(10);

        fullname = new JTextField();
        fullname.setBounds(142, 81, 168, 21);
        frame.getContentPane().add(fullname);
        fullname.setColumns(10);

        yob = new JTextField();
        yob.setBounds(142, 112, 168, 21);
        frame.getContentPane().add(yob);
        yob.setColumns(10);

        remark = new JTextField();
        remark.setBounds(142, 137, 168, 21);
        frame.getContentPane().add(remark);
        remark.setColumns(10);

        JButton btnRegister = new JButton("Register To WFGTC");
        btnRegister.setBounds(162, 178, 100, 23);
        frame.getContentPane().add(btnRegister);
        btnRegister.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        String uName = username.getText();
        String pWord = password.getText();
        String fName = fullname.getText();
        String YOB = yob.getText();
        String rMark = remark.getText();

        try {
            int i = Integer.parseInt(Utils.maxUID()) + 1;
            String s = "00"+String.valueOf(i);
            if(RegisterManager.createUser(s, pWord, uName, fName, "User", YOB, rMark) == RegisterStatus.SUCCESS) {
                JOptionPane.showMessageDialog(null, "User Register Successfully");
                frame.setVisible(false);
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "User Register Failure, Please ask Administrator for help.");
                frame.setVisible(false);
                frame.dispose();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
