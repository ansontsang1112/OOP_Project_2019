package com.kc.main;

import com.anson.main.Config;
import com.anson.main.LoginManager;
import com.anson.main.PermissionManager;
import com.anson.main.Utils.GlobalUtils;
import com.anson.main.enums.ClassStatus;
import com.gordon.main.AboutUsGUI;
import com.gordon.main.AdminGUI;
import com.group.main.Utils;
import com.kenny.main.GUI.RegisterGUI;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class ControlPanelGUI {
    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void ControlPanelGUIEXE() {
        EventQueue.invokeLater(() -> {
            try {
                ControlPanelGUI window = new ControlPanelGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ControlPanelGUI() throws IOException {
        initialize();
    }

    private void initialize() throws IOException {
        frame = new JFrame();
        frame.setBounds(100, 100, 768, 507);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.setBounds(0, 0, 752, 25);
        frame.getContentPane().add(panel);

        JLabel lblWhiteFruitGaming = new JLabel("White Fruit Gaming Training Center");
        panel.add(lblWhiteFruitGaming);

        JLabel label = new JLabel("||");
        panel.add(label);

        JLabel lblControlPanel = new JLabel("Control Panel");
        panel.add(lblControlPanel);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_1.setBounds(0, 436, 752, 32);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel lblWriteFruitGaming = new JLabel("Write Fruit Gaming Training Center @ 2019");
        lblWriteFruitGaming.setBounds(280, 10, 222, 15);
        panel_1.add(lblWriteFruitGaming);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_2.setBounds(0, 405, 752, 32);
        frame.getContentPane().add(panel_2);
        panel_2.setLayout(null);

        JLabel lblWannaKnowMore = new JLabel("Wanna Know More about US? Click the Button Below and know our devlopers member");
        lblWannaKnowMore.setBounds(53, 9, 424, 15);
        panel_2.add(lblWannaKnowMore);

        JButton btnAboutUs = new JButton("About Us ");
        btnAboutUs.setBounds(500, 5, 178, 23);
        panel_2.add(btnAboutUs);
        btnAboutUs.addActionListener(arg0 -> {
            AboutUsGUI myGUI = new AboutUsGUI();
        });

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(0, 24, 752, 25);
        frame.getContentPane().add(panel_3);

        JLabel lblWelcomeLoginTo = new JLabel("Welcome "+ Utils.getFullName(LoginManager.currentLoginUsername) +" Login to White Fruit Gaming Training Center, You are " + PermissionManager.roleHandler(LoginManager.currentLoginUsername) + " .");
        panel_3.add(lblWelcomeLoginTo);

        JPanel panel_4 = new JPanel();
        panel_4.setBounds(0, 47, 375, 360);
        frame.getContentPane().add(panel_4);
        panel_4.setLayout(null);

        JLabel lblUserAdministration = new JLabel("User Administration & Control Section");
        lblUserAdministration.setBounds(99, 10, 191, 15);
        panel_4.add(lblUserAdministration);

        JButton btnChangePersonalPassword = new JButton("Change Personal Password");
        btnChangePersonalPassword.setBounds(10, 35, 175, 56);
        panel_4.add(btnChangePersonalPassword);
        btnChangePersonalPassword.addActionListener(arg0 -> {
            PasswordRecoveryGUI.PasswordRecoveryGUIEXE();
        });

        JButton btnCheckUserInformation = new JButton("Check User Information");
        btnCheckUserInformation.setBounds(203, 35, 162, 56);
        panel_4.add(btnCheckUserInformation);
        btnCheckUserInformation.addActionListener(arg0 -> {
            try {
                JOptionPane.showMessageDialog(null, Utils.informationStringFormatter(),
                        "Permission Checker - WFGTC", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        JButton btnEnterAdminPanel = new JButton("Enter Admin Panel");
        btnEnterAdminPanel.setBounds(10, 224, 355, 56);
        panel_4.add(btnEnterAdminPanel);
        btnEnterAdminPanel.addActionListener(arg0 -> {
            try {
                AdminGUI.AdminGUIEXE();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        JButton btnLogoutUserPanel = new JButton("Logout User Panel");
        btnLogoutUserPanel.setBounds(10, 294, 355, 56);
        panel_4.add(btnLogoutUserPanel);
        btnLogoutUserPanel.addActionListener(arg0 -> {
            JOptionPane.showMessageDialog(null, "Logout will be perform after press 'Okay'",
                        "Logout? - WFGTC", JOptionPane.INFORMATION_MESSAGE);
            frame.setVisible(false);
            frame.dispose();
        });

        JButton btnPermissionRoleCheck = new JButton("Permission Role Check");
        btnPermissionRoleCheck.setBounds(10, 102, 175, 56);
        panel_4.add(btnPermissionRoleCheck);
        btnPermissionRoleCheck.addActionListener(arg0 -> {
            try {
                JOptionPane.showMessageDialog(null, "Your Permission Role: " + PermissionManager.roleHandler(LoginManager.currentLoginUsername),
                        "Permission Checker - WFGTC", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        JButton btnRegisterNewAccount = new JButton("Register New Account");
        btnRegisterNewAccount.setBounds(203, 101, 162, 57);
        panel_4.add(btnRegisterNewAccount);
        btnRegisterNewAccount.addActionListener(arg0 -> RegisterGUI.RegisterGUIEXE());

        Component horizontalStrut = Box.createHorizontalStrut(20);
        horizontalStrut.setBounds(0, 181, 375, 20);
        panel_4.add(horizontalStrut);

        JLabel lblClassAttempt = new JLabel("Class Attempt & Management Section");
        lblClassAttempt.setBounds(465, 59, 182, 15);
        frame.getContentPane().add(lblClassAttempt);

        JButton btnMinecraftTechnicalClass = new JButton("Minecraft Technical Class");
        btnMinecraftTechnicalClass.setBounds(385, 84, 182, 125);
        frame.getContentPane().add(btnMinecraftTechnicalClass);
        btnMinecraftTechnicalClass.addActionListener(arg0 -> {
            String [] catagory = {"Redstone Tech.", "Building Tech.", "Command Tech."};
            String [] classLevel = {"New Player", "Beginner", "Intermediate Player", "hardcore Gamer"};
            String cInput = (String) JOptionPane.showInputDialog(null, "Please select the learning catagory.", "Minecraft Technical: The learning catagory", JOptionPane.QUESTION_MESSAGE, null, catagory, catagory[0]);
            String ccInput = (String) JOptionPane.showInputDialog(null, "Please select the Level of Minecraft Gaming.", "Minecraft Technical: Gaming Level", JOptionPane.QUESTION_MESSAGE, null, catagory, catagory[0]);
            try{
                if(Utils.classRegisterAPI(1, UUID.randomUUID().toString(), java.util.Calendar.getInstance().getTime().toString(), cInput, ccInput) == ClassStatus.CLASS_SUCCESS_APPOINTED) {
                    JOptionPane.showMessageDialog(null, "Appointment Success.", "Minecraft Technical: Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Appointment Fail.", "Minecraft Technical: Fail", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        JButton btnApexLegendTclass = new JButton("Apex Legend T.Class");
        btnApexLegendTclass.setBounds(577, 84, 165, 125);
        frame.getContentPane().add(btnApexLegendTclass);
        btnApexLegendTclass.addActionListener(arg0 -> {
            String [] rank = {"Bronze", "Silver", "Gold", "Platinum","Diamond","Apex Predator"};
            String [] mmr = {"LEVEL1", "LEVEL2", "LEVEL3", "LEVEL4"};
            String cInput = (String) JOptionPane.showInputDialog(null, "Please select the Rank", "Apex Legend Skills: Rank", JOptionPane.QUESTION_MESSAGE, null, rank, rank[0]);
            String ccInput = (String) JOptionPane.showInputDialog(null, "Please select the Level", "Apex Legend Skills: Level", JOptionPane.QUESTION_MESSAGE, null, mmr, mmr[0]);
            try{
                if(Utils.classRegisterAPI(2, UUID.randomUUID().toString(), java.util.Calendar.getInstance().getTime().toString(), cInput, ccInput) == ClassStatus.CLASS_SUCCESS_APPOINTED) {
                    JOptionPane.showMessageDialog(null, "Appointment Success.", "Apex Legend Skills: Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Appointment Fail.", "RApex Legend Skills: Fail", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        JButton btnCsgoTrainingClass = new JButton("CS:Go Training Class");
        btnCsgoTrainingClass.setBounds(385, 219, 182, 125);
        frame.getContentPane().add(btnCsgoTrainingClass);
        btnApexLegendTclass.addActionListener(arg0 -> {
            String [] choose1 = { "LEVEL1", "LEVEL2", "LEVEL3", "LEVEL4"};
            String [] choose2 = {"newplayer", "beginner", "Intermediate player", "hardcore gamer"};
            String cInput = (String) JOptionPane.showInputDialog(null, "Please select the Level", "CS:Go Skills: Level", JOptionPane.QUESTION_MESSAGE, null, choose1, choose1[0]);
            String ccInput = (String) JOptionPane.showInputDialog(null, "Please select the Power", "CS:Go Skills: Power", JOptionPane.QUESTION_MESSAGE, null, choose2, choose2[0]);
            try{
                if(Utils.classRegisterAPI(4, UUID.randomUUID().toString(), java.util.Calendar.getInstance().getTime().toString(), cInput, ccInput) == ClassStatus.CLASS_SUCCESS_APPOINTED) {
                    JOptionPane.showMessageDialog(null, "Appointment Success.", "CS:Go Skills: Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Appointment Fail.", "CS:Go Skills: Fail", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        JButton btnRainbowTraining = new JButton("Rainbow 6 Training Class");
        btnRainbowTraining.setBounds(577, 220, 165, 125);
        frame.getContentPane().add(btnRainbowTraining);
        btnApexLegendTclass.addActionListener(arg0 -> {
            String [] rank = {"Copper", "Bronze", "Sliver", "Gold", "Platinum", "Diamond", "Champion"};
            String [] mmr = {"0-1599", "1600-2099", "2100-2599", "2600-3199", "3200-4399", "4400-5000"};
            String cInput = (String) JOptionPane.showInputDialog(null, "Please select the Rank", "Rainbow 6 Skills: Rank", JOptionPane.QUESTION_MESSAGE, null, rank, rank[0]);
            String ccInput = (String) JOptionPane.showInputDialog(null, "Please select the MMR", "Rainbow 6 Skills: MMR", JOptionPane.QUESTION_MESSAGE, null, mmr, mmr[0]);
            try{
                if(Utils.classRegisterAPI(3, UUID.randomUUID().toString(), java.util.Calendar.getInstance().getTime().toString(), cInput, ccInput) == ClassStatus.CLASS_SUCCESS_APPOINTED) {
                    JOptionPane.showMessageDialog(null, "Appointment Success.", "Rainbow 6 Skills: Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Appointment Fail.", "Rainbow 6 Skills: Fail", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        JButton btnCheckAttemptedClass = new JButton("Check Attempted Class");
        btnCheckAttemptedClass.setBounds(385, 354, 357, 41);
        frame.getContentPane().add(btnCheckAttemptedClass);
    }

}
