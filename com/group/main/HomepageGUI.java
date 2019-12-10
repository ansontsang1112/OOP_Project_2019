package com.group.main;
import com.gordon.main.AboutUsGUI;
import com.kc.main.LoginGUI;
import com.kc.main.RegisterGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

public class HomepageGUI {
    private JFrame frame;
    public static boolean ADM = false;

    public static void HomePageEXE() {
        EventQueue.invokeLater(() -> {
            try {
                HomepageGUI window = new HomepageGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public HomepageGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 533, 361);;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.setBounds(0, 0, 265, 377);
        frame.getContentPane().add(panel);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(263, 0, 262, 25);
        frame.getContentPane().add(panel_1);

        JLabel lblWhiteFruitGame = new JLabel("White Fruit Gaming Training Center");
        panel_1.add(lblWhiteFruitGame);

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_2.setBounds(263, 25, 140, 131);
        frame.getContentPane().add(panel_2);

        JLabel lblWannaKnow = new JLabel("Wanna Know");
        panel_2.add(lblWannaKnow);

        JLabel lblMoreAbout = new JLabel("More About");
        panel_2.add(lblMoreAbout);

        JLabel lblOurTeam = new JLabel("Our Team");
        panel_2.add(lblOurTeam);

        JLabel lblCheckItOut = new JLabel("Check It Out !! ~");
        panel_2.add(lblCheckItOut);

        JButton btnAboutUs = new JButton("About US");
        panel_2.add(btnAboutUs);
        btnAboutUs.addActionListener(arg0 -> {
            AboutUsGUI myGUI = new AboutUsGUI();
        });

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), null));
        panel_3.setBounds(403, 25, 122, 131);
        frame.getContentPane().add(panel_3);

        JLabel lblWeProvides = new JLabel("We Provides");
        panel_3.add(lblWeProvides);

        JList list = new JList();
        list.setBorder(new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), null));
        list.setBackground(SystemColor.menu);
        list.setForeground(Color.BLACK);
        list.setModel(new AbstractListModel() {
            String[] values = new String[] {"Minecraft Techical", "Apex Legend", "Rainbow 6", "CS:Go"};
            public int getSize() {
                return values.length;
            }
            public Object getElementAt(int index) {
                return values[index];
            }
        });
        panel_3.add(list);

        JLabel lblTrainings = new JLabel("Trainings");
        panel_3.add(lblTrainings);

        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_4.setBounds(263, 156, 265, 48);
        frame.getContentPane().add(panel_4);
        panel_4.setLayout(null);

        JButton btnCustomerLogin = new JButton("Customer Login");
        btnCustomerLogin.setBounds(10, 15, 109, 23);
        panel_4.add(btnCustomerLogin);
        btnCustomerLogin.addActionListener(arg0 -> {
            ADM = false;
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(false);
            frame.dispose();
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.setVisible(true);
        });

        JButton btnAdminLogin = new JButton("Admin Login");
        btnAdminLogin.setBounds(129, 15, 97, 23);
        panel_4.add(btnAdminLogin);
        btnAdminLogin.addActionListener(arg0 -> {
            ADM = true;
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(false);
            frame.dispose();
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.setVisible(true);
        });

        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_5.setBounds(263, 204, 262, 58);
        frame.getContentPane().add(panel_5);

        JLabel lblNoAccountRegister = new JLabel("No Account? Register for Game Training !");
        panel_5.add(lblNoAccountRegister);

        JButton btnRegisterNewAccount = new JButton("Register New Account !!");
        panel_5.add(btnRegisterNewAccount);
        btnRegisterNewAccount.addActionListener(arg0 -> {
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(false);
            frame.dispose();
            RegisterGUI registerGUI = new RegisterGUI();
            registerGUI.setVisible(true);
        });
    }
}
