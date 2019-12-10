package com.group.main;

import com.gordon.main.AboutUsGUI;
import com.kc.main.LoginGUI;
import com.kenny.main.GUI.ContactUsGUI;
import com.kenny.main.GUI.RegisterGUI;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HomePageGUI {

    private JFrame frame;
    public static boolean ADM = false;

    public static void HomePageGUIEXE() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomePageGUI window = new HomePageGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public HomePageGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 847, 554);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        try {
        JPanel panel = new JPanel();
        panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel.setBounds(0, 0, 468, 517);
        frame.getContentPane().add(panel);
            BufferedImage myPicture = ImageIO.read(new File("homepage.jpg"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            panel.add(picLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_2.setBounds(471, 95, 192, 203);
        frame.getContentPane().add(panel_2);
        panel_2.setLayout(null);

        JLabel lblWantToKnow = new JLabel("Want To Know More Our Team?");
        lblWantToKnow.setBounds(10, 10, 163, 20);
        panel_2.add(lblWantToKnow);

        JButton btnAboutUs = new JButton("About Us");
        btnAboutUs.setBounds(10, 67, 163, 126);
        panel_2.add(btnAboutUs);
        btnAboutUs.addActionListener(arg0 -> {
            AboutUsGUI myGUI = new AboutUsGUI();
        });

        JLabel lblClickaboutUs = new JLabel("Click 'About Us' to Know More");
        lblClickaboutUs.setBounds(20, 40, 163, 15);
        panel_2.add(lblClickaboutUs);

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_3.setBounds(659, 95, 174, 203);
        frame.getContentPane().add(panel_3);
        panel_3.setLayout(null);

        JLabel lblWeProvides = new JLabel("We Provides");
        lblWeProvides.setBounds(58, 10, 77, 15);
        panel_3.add(lblWeProvides);

        JLabel lblAHugeVariety = new JLabel("a huge variety of courses");
        lblAHugeVariety.setBounds(32, 35, 132, 15);
        panel_3.add(lblAHugeVariety);

        JList list = new JList();
        list.setBackground(SystemColor.menu);
        list.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        list.setModel(new AbstractListModel() {
            String[] values = new String[] {"Minecraft Technical", "Apex Legend Skills", "CS:Go Skills", "Rainbow 6 Skills"};
            public int getSize() {
                return values.length;
            }
            public Object getElementAt(int index) {
                return values[index];
            }
        });
        list.setBounds(32, 60, 117, 78);
        panel_3.add(list);

        JLabel lblWantToHave = new JLabel("Want to have More");
        lblWantToHave.setBounds(39, 148, 125, 15);
        panel_3.add(lblWantToHave);

        JLabel lblContactUsFor = new JLabel("Contact Us For Details");
        lblContactUsFor.setBounds(32, 173, 125, 15);
        panel_3.add(lblContactUsFor);

        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_4.setBounds(471, 298, 362, 67);
        frame.getContentPane().add(panel_4);
        panel_4.setLayout(null);

        JLabel lblYouAreThe = new JLabel("You are the Staff Of WF Gaming Training Center? Login Here");
        lblYouAreThe.setBounds(33, 10, 319, 15);
        panel_4.add(lblYouAreThe);

        JButton btnStaffLogin = new JButton("Staff Login");
        btnStaffLogin.setBounds(43, 34, 281, 23);
        panel_4.add(btnStaffLogin);
        btnStaffLogin.addActionListener(arg0 -> {
            ADM = true;
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(false);
            frame.dispose();
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.setVisible(true);
        });

        JPanel panel_6 = new JPanel();
        panel_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_6.setBounds(471, 429, 362, 51);
        frame.getContentPane().add(panel_6);
        panel_6.setLayout(null);

        JLabel lblNoAccountRegister = new JLabel("No Account? Register For Game Training ?!");
        lblNoAccountRegister.setBounds(66, 10, 286, 15);
        panel_6.add(lblNoAccountRegister);

        JButton btnRegisterAccount = new JButton("Register Account");
        btnRegisterAccount.setBounds(105, 28, 144, 23);
        panel_6.add(btnRegisterAccount);
        btnRegisterAccount.addActionListener(arg0 -> {
            RegisterGUI.RegisterGUIEXE();
        });


        JPanel panel_7 = new JPanel();
        panel_7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_7.setBounds(473, 0, 360, 94);
        frame.getContentPane().add(panel_7);
        panel_7.setLayout(null);

        JLabel lblWhiteFruitGaming = new JLabel("White Fruit Gaming Training Center Co.");
        lblWhiteFruitGaming.setBounds(91, 10, 200, 15);
        panel_7.add(lblWhiteFruitGaming);

        JLabel label = new JLabel("\u8D85 \u2027 \u767D\u679C\u904A\u6232\u8A13\u7DF4\u4E2D\u5FC3");
        label.setBounds(120, 35, 157, 15);
        panel_7.add(label);

        JPanel panel_8 = new JPanel();
        panel_8.setBounds(91, 51, 177, 33);
        panel_7.add(panel_8);

        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_5.setBounds(469, 480, 364, 37);
        frame.getContentPane().add(panel_5);
        panel_5.setLayout(null);

        JLabel lblWhiteFruitGaming_1 = new JLabel("White Fruit Gaming Training Center Co. @ 2019");
        lblWhiteFruitGaming_1.setBounds(77, 10, 251, 15);
        panel_5.add(lblWhiteFruitGaming_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_1.setBounds(471, 367, 180, 61);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JButton btnCustomerLogin = new JButton("Customer Login");
        btnCustomerLogin.setBounds(10, 10, 160, 41);
        panel_1.add(btnCustomerLogin);
        btnCustomerLogin.addActionListener(arg0 -> {
            ADM = false;
            frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame.setVisible(false);
            frame.dispose();
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.setVisible(true);
        });

        JPanel panel_9 = new JPanel();
        panel_9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        panel_9.setBounds(653, 367, 180, 61);
        frame.getContentPane().add(panel_9);
        panel_9.setLayout(null);

        JButton btnContactUs = new JButton("Contact Us");
        btnContactUs.setBounds(10, 10, 160, 41);
        panel_9.add(btnContactUs);
        btnContactUs.addActionListener(arg0 -> ContactUsGUI.RegisterGUIEXE());
    }
}
