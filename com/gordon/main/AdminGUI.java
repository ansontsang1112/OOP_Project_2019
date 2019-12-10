package com.gordon.main;

import com.anson.main.Encryption;
import com.anson.main.GUI.PermissionGUI;
import com.anson.main.LoginManager;
import com.anson.main.PasswordManager;
import com.anson.main.PermissionManager;
import com.anson.main.enums.PasswordStatus;
import com.anson.main.enums.RemovalStatus;
import com.group.main.Main;
import com.group.main.Utils;
import com.kenny.main.GUI.RegisterGUI;
import com.kenny.main.UserRemovalManager;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.*;

public class AdminGUI {

    private JFrame frame;
    private static String tmpPass;
    private static String tmpPassAuth;

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
        } else {
            JOptionPane.showMessageDialog(null, "You do not have enough Permission to access Admin Panel.", "Warning: Not enough Permission", JOptionPane.INFORMATION_MESSAGE);
        }
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
        btnCreateNewUser.addActionListener(arg0 -> {
            RegisterGUI.RegisterGUIEXE();
        });

        JButton btnDisplayAllUser = new JButton("Display All User");
        btnDisplayAllUser.setBounds(277, 105, 257, 82);
        frame.getContentPane().add(btnDisplayAllUser);
        btnDisplayAllUser.addActionListener(arg0 -> {
            DisplayUserGUI.DisplayUserEXE();
        });

        JButton btnDeleteUser = new JButton("Delete User");
        btnDeleteUser.setBounds(544, 105, 257, 82);
        frame.getContentPane().add(btnDeleteUser);
        btnDeleteUser.addActionListener(arg0 -> {
            Main.tempName = JOptionPane.showInputDialog(null, "Which User you are going to remove!!");
            try{
                if(Utils.isUserExist(Main.tempName)) {
                   String accept = "";
                   accept = JOptionPane.showInputDialog(null, "Are you sure to remove the User <" + Main.tempName + ">? Please enter 'YES' to continue.");
                   if(accept.equalsIgnoreCase("YES")) {
                       if(UserRemovalManager.userRemoval(Main.tempName) == RemovalStatus.REMOVAL_SUCCESS) {
                           JOptionPane.showMessageDialog(null, "User <" + Main.tempName + "> are successfully removed.", "Notice: Removed Successfully", JOptionPane.INFORMATION_MESSAGE);
                       } else {
                           JOptionPane.showMessageDialog(null, "User <" + Main.tempName + "> removed failure. Please try later.", "Warning: Removal Failure", JOptionPane.INFORMATION_MESSAGE);
                       }
                   } else {
                       JOptionPane.showMessageDialog(null, "You need to type 'YES' to accept the T&C", "Warning: Please accept the T&C", JOptionPane.INFORMATION_MESSAGE);
                   }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        JButton btnDisplayLoginrecord = new JButton("Display LoginRecord");
        btnDisplayLoginrecord.setBounds(10, 197, 257, 82);
        frame.getContentPane().add(btnDisplayLoginrecord);
        btnDisplayLoginrecord.addActionListener(arg0 -> {
            DisplayRecordGUI.DisplayRecordGUIEXE();
        });
        btnDisplayLoginrecord.addActionListener(arg0 -> {
            JOptionPane.showMessageDialog(null, "This Function are not available yet. Thank you.",
                    "Sorry? - WFGTC", JOptionPane.INFORMATION_MESSAGE);
        });

        JButton btnDeleteLoginrecord = new JButton("Delete LoginRecord");
        btnDeleteLoginrecord.setBounds(277, 197, 257, 82);
        frame.getContentPane().add(btnDeleteLoginrecord);

        JButton btnChangePermission = new JButton("Change Permission");
        btnChangePermission.setBounds(544, 197, 257, 82);
        frame.getContentPane().add(btnChangePermission);
        btnChangePermission.addActionListener(arg0 -> {
            Main.tempName = JOptionPane.showInputDialog(null, "Which User's Permission You are gonna edit?");
            try{
                if(Utils.isUserExist(Main.tempName)) {
                    PermissionGUI.PermissionGUIEXE();
                } else {
                    JOptionPane.showMessageDialog(null, "User " + Main.tempName + " are not exist. Please try again.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        JButton btnChangePassword = new JButton("Change User Password");
        btnChangePassword.setBounds(10, 289, 257, 82);
        frame.getContentPane().add(btnChangePassword);
        btnChangePassword.addActionListener(arg0 -> {
            Main.tempName = JOptionPane.showInputDialog(null, "Which User's Password You are gonna edit?");
            try{
                if(Utils.isUserExist(Main.tempName)) {
                    tmpPass = JOptionPane.showInputDialog(null, "Please Enter the new Password for " + Main.tempName);
                    tmpPassAuth = JOptionPane.showInputDialog(null, "Please enter the password again.");
                    if(!tmpPass.equals(tmpPassAuth)) {
                        JOptionPane.showMessageDialog(null, "The two password you type are not the same, please try again.");
                    } else {
                        if(PasswordManager.changePasswordByAdministrator(LoginManager.currentLoginUsername, tmpPass) == PasswordStatus.UPDATE_SUCCESS) {
                            JOptionPane.showMessageDialog(null, "User <" + Main.tempName + ">'s Password successfully update to " + Encryption.encryption(tmpPass),
                                    "Password Update - Admin ONLY", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "User <" + Main.tempName + ">'s Password Fail update to " + Encryption.encryption(tmpPass),
                                    "Password Update - Admin ONLY", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "User " + Main.tempName + " are not exist. Please try again.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        JButton btnDeleteTheProgram = new JButton("Delete the Program");
        btnDeleteTheProgram.setBounds(277, 289, 257, 82);
        frame.getContentPane().add(btnDeleteTheProgram);
        btnDeleteTheProgram.addActionListener(arg0 -> {
            JOptionPane.showMessageDialog(null, "This Function are not available yet. Thank you.",
                    "Sorry? - WFGTC", JOptionPane.INFORMATION_MESSAGE);
        });

        JButton btnLogout = new JButton("Logoff");
        btnLogout.setBounds(544, 289, 257, 82);
        frame.getContentPane().add(btnLogout);
        btnLogout.addActionListener(arg0 -> {
            JOptionPane.showMessageDialog(null, "Logout will be perform after press 'Okay'",
                    "Logoff Admin Panel? - WFGTC", JOptionPane.INFORMATION_MESSAGE);
            frame.setVisible(false);
            frame.dispose();
        });
    }
}