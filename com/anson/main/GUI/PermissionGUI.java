package com.anson.main.GUI;
import com.anson.main.PermissionManager;
import com.group.main.Main;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class PermissionGUI {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void PermissionGUIEXE() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PermissionGUI window = new PermissionGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public PermissionGUI() throws IOException {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() throws IOException {
        frame = new JFrame();
        frame.setBounds(100, 100, 459, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.setBounds(0, 0, 443, 30);
        frame.getContentPane().add(panel);

        JLabel lblPermissionEditor = new JLabel("Permission Editor - Admin ONLY");
        panel.add(lblPermissionEditor);

        JButton btnUser = new JButton("User");
        btnUser.setBounds(10, 151, 197, 100);
        frame.getContentPane().add(btnUser);
        btnUser.addActionListener(arg0 -> {
            if(PermissionManager.editPermission(Main.tempName, "User")) {
                JOptionPane.showMessageDialog(null, "Permission of User <" + Main.tempName + "> are successfully updated to <User>",
                        "Update: Permission Update Successful", JOptionPane.INFORMATION_MESSAGE);
                frame.setVisible(false);
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Permission of User <" + Main.tempName + "> are Failure updated to <User>",
                        "Update: Permission Update Failure", JOptionPane.INFORMATION_MESSAGE);
                frame.setVisible(false);
                frame.dispose();
            }
        });

        JButton btnAdministrator = new JButton("Administrator");
        btnAdministrator.setBounds(229, 151, 204, 100);
        frame.getContentPane().add(btnAdministrator);
        btnAdministrator.addActionListener(arg0 -> {
            if(PermissionManager.editPermission(Main.tempName, "Administrator")) {
                JOptionPane.showMessageDialog(null, "Permission of User <" + Main.tempName + "> are successfully updated to <Administrator>",
                        "Update: Permission Update Successful", JOptionPane.INFORMATION_MESSAGE);
                frame.setVisible(false);
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Permission of User <" + Main.tempName + "> are Failure updated to <Administrator>",
                        "Update: Permission Update Failure", JOptionPane.INFORMATION_MESSAGE);
                frame.setVisible(false);
                frame.dispose();
            }
        });

        JLabel lblUserIsNow = new JLabel("User <" + Main.tempName + "> is now in <" + PermissionManager.roleHandler(Main.tempName) + ">");
        lblUserIsNow.setBounds(145, 40, 197, 15);
        frame.getContentPane().add(lblUserIsNow);

        JLabel lblYouWannaChange = new JLabel("You wanna change to");
        lblYouWannaChange.setBounds(169, 126, 126, 15);
        frame.getContentPane().add(lblYouWannaChange);
    }
}
