package com.gordon.main;

import com.anson.main.LoginManager;
import com.anson.main.PermissionManager;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.*;

public class AdminGUI {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void AdminGUIEXE() throws IOException {
        if(PermissionManager.isAdministrator(LoginManager.currentLoginUsername)) {
            EventQueue.invokeLater(() -> {
                try {
                    AdminGUI window = new AdminGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        };

        JOptionPane.showMessageDialog(null, "You do not have enough Permission to access Admin Panel.", "Warning: Not enough Permission", JOptionPane.INFORMATION_MESSAGE);
    }

    public AdminGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 893, 490);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 859, 72);
        frame.getContentPane().add(panel);

        JLabel lblAdminFunction = new JLabel("Administrator Function");
        panel.add(lblAdminFunction);

        JButton btnCreateNewUser = new JButton("Create new User");
        btnCreateNewUser.setBounds(10, 105, 257, 82);
        frame.getContentPane().add(btnCreateNewUser);

        JButton btnDisplayAllUser = new JButton("Display All User");
        btnDisplayAllUser.setBounds(277, 105, 257, 82);
        frame.getContentPane().add(btnDisplayAllUser);

        JButton btnDeleteUser = new JButton("Delete User");
        btnDeleteUser.setBounds(544, 105, 257, 82);
        frame.getContentPane().add(btnDeleteUser);

        JButton btnDisplayLoginrecord = new JButton("Display LoginRecord");
        btnDisplayLoginrecord.setBounds(10, 197, 257, 82);
        frame.getContentPane().add(btnDisplayLoginrecord);

        JButton btnDeleteLoginrecord = new JButton("Delete LoginRecord");
        btnDeleteLoginrecord.setBounds(277, 197, 257, 82);
        frame.getContentPane().add(btnDeleteLoginrecord);

        JButton btnChangePermission = new JButton("Change Permission");
        btnChangePermission.setBounds(544, 197, 257, 82);
        frame.getContentPane().add(btnChangePermission);

        JButton btnChangePassword = new JButton("Change User Password");
        btnChangePassword.setBounds(10, 289, 257, 82);
        frame.getContentPane().add(btnChangePassword);

        JButton btnDeleteTheProgram = new JButton("Delete the Program");
        btnDeleteTheProgram.setBounds(277, 289, 257, 82);
        frame.getContentPane().add(btnDeleteTheProgram);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(544, 289, 257, 82);
        frame.getContentPane().add(btnLogout);
    }
}