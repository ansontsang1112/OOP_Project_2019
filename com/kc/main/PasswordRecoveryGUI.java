package com.kc.main;

import com.anson.main.G22PasswordManager;
import com.anson.main.enums.G22PasswordStatus;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class PasswordRecoveryGUI implements ActionListener {
    private JFrame frame;
    private JTextField newPassword;
    private JTextField replyEnterPassword;

    public static void PasswordRecoveryGUIEXE() {
        EventQueue.invokeLater(() -> {
            try {
                PasswordRecoveryGUI window = new PasswordRecoveryGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public PasswordRecoveryGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 454, 301);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 438, 25);
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        frame.getContentPane().add(panel);

        JLabel lblUserPersonal = new JLabel("User - Personal Password Recovery Form");
        panel.add(lblUserPersonal);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 25, 438, 207);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewPassword = new JLabel("New Password");
        lblNewPassword.setBounds(41, 34, 89, 15);
        panel_1.add(lblNewPassword);

        newPassword = new JTextField();
        newPassword.setBounds(159, 31, 237, 21);
        panel_1.add(newPassword);
        newPassword.setColumns(10);

        JLabel lblPasswordAgain = new JLabel("Password Again");
        lblPasswordAgain.setBounds(41, 79, 89, 15);
        panel_1.add(lblPasswordAgain);

        replyEnterPassword = new JTextField();
        replyEnterPassword.setBounds(159, 76, 237, 21);
        panel_1.add(replyEnterPassword);
        replyEnterPassword.setColumns(10);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(82, 159, 87, 23);
        panel_1.add(btnSubmit);
        btnSubmit.addActionListener(this);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(281, 159, 87, 23);
        panel_1.add(btnReset);

        JLabel lblWhiteFruitGame = new JLabel("White Fruit Game Training Center");
        lblWhiteFruitGame.setBounds(142, 242, 228, 15);
        frame.getContentPane().add(lblWhiteFruitGame);
    }

    public void actionPerformed(ActionEvent ae) {
        String nPassword = newPassword.getText();
        String replyPassword = replyEnterPassword.getText();

        if(!nPassword.equals(replyPassword)) {JOptionPane.showMessageDialog(null, "Password are not equal, please try again"); frame.setVisible(false); frame.dispose();}

        try {
            if(G22PasswordManager.changePasswordByUser(nPassword) == G22PasswordStatus.UPDATE_SUCCESS) {
                JOptionPane.showMessageDialog(null, "Password Successfully Changed");
                frame.setVisible(false);
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Password Change Failure, Please ask Administrator for help.");
                frame.setVisible(false);
                frame.dispose();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
