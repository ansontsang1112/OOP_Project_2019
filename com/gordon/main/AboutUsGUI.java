package com.gordon.main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class AboutUsGUI extends JFrame{
    JPanel panelTop = new JPanel();
    JButton butAboutMe = new JButton("About US");

    JButton LogIn = new JButton("login");
    JLabel labelImg = new JLabel(); // label to show image
    JScrollPane sPImg = new JScrollPane(labelImg); //
    JLabel labelStatus = new JLabel(); // label to show status info

    BufferedImage orgImg;

    public AboutUsGUI() { // A No-Argument Constructor
        setTitle("MyName Image Viewer");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initGUI();
    }

    void initGUI(){ // Method for initializing GUI (layout, components)
        add(LogIn, BorderLayout.NORTH);
        add(butAboutMe, BorderLayout.NORTH);
        add(sPImg, BorderLayout.CENTER);
        add(labelStatus, BorderLayout.SOUTH);

        butAboutMe.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                JOptionPane.showMessageDialog(null,
                        "Members(left to right):\n" +
                                "Name&Number\n Ng Hoi Yun 20089244\n Tsang Cheuk Him 20089261\n Hung Ka Chun 20079467\n Chak Chun Yin 20089310",
                        "About Me: G22m2, 2019-2020, OOP",
                        JOptionPane.INFORMATION_MESSAGE,
                        new ImageIcon("us.png"));
            } });
    }
}
