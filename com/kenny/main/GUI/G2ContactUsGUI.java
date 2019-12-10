package com.kenny.main.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class G2ContactUsGUI {

    private JFrame frame;
    private JTextField textField;

    public static void RegisterGUIEXE() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    G2ContactUsGUI window = new G2ContactUsGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public G2ContactUsGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblRemake = new JLabel("remakes:");
        lblRemake.setBounds(49, 54, 47, 41);
        frame.getContentPane().add(lblRemake);

        textField = new JTextField();
        textField.setBounds(106, 54, 273, 143);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton btnSummit = new JButton("summit");
        btnSummit.setBounds(142, 207, 87, 23);
        frame.getContentPane().add(btnSummit);
        String[] choices = {"question","Complaint","find teacher"};

        JComboBox <String> comboBox = new JComboBox<String>(choices);
        comboBox.setForeground(Color.PINK);
        comboBox.setBounds(106, 23, 273, 21);
        frame.getContentPane().add(comboBox);
    }
}