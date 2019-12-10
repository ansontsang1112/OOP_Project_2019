package com.kenny.main.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class G22m4ClassSystem {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    G22m4ClassSystem window = new G22m4ClassSystem();
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
    public G22m4ClassSystem() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 174);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblGame = new JLabel("games");
        lblGame.setBounds(28, 36, 59, 15);
        frame.getContentPane().add(lblGame);

        JLabel lblGameLevel = new JLabel("game LEVEL");
        lblGameLevel.setBounds(118, 36, 74, 15);
        frame.getContentPane().add(lblGameLevel);

        JLabel lblGradeClass = new JLabel("Grade class");
        lblGradeClass.setBounds(229, 36, 100, 15);
        frame.getContentPane().add(lblGradeClass);


        String[] choices2 = { "newplayer", "beginner", "Intermediate player", "hardcore gamer"};
        JComboBox <String>comboBox_1 = new JComboBox<String>(choices2);
        comboBox_1.setBounds(118, 61, 74, 21);
        frame.getContentPane().add(comboBox_1);

        String[] choices3 = { "LEVEL1", "LEVEL2", "LEVEL3", "LEVEL4"};
        JComboBox <String>comboBox_2 = new JComboBox<String>(choices3);
        comboBox_2.setBounds(229, 61, 112, 21);
        frame.getContentPane().add(comboBox_2);

        JButton btnOk = new JButton("ok");
        btnOk.setBounds(154, 102, 87, 23);
        frame.getContentPane().add(btnOk);
    }
}
