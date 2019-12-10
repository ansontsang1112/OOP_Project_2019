package com.kc.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class G22m3ClassSystemGUI {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void G22m3ClassSystemGUIEXE() {
        EventQueue.invokeLater(() -> {
            try {
                G22m3ClassSystemGUI window = new G22m3ClassSystemGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public G22m3ClassSystemGUI() {
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

        JLabel lblGame = new JLabel("Rainbow Six Siege");
        lblGame.setBounds(28, 36, 120, 15);
        frame.getContentPane().add(lblGame);

        JLabel lblGameLevel = new JLabel("Rank");
        lblGameLevel.setBounds(150, 36, 74, 15);
        frame.getContentPane().add(lblGameLevel);

        JLabel lblGradeClass = new JLabel("MMR");
        lblGradeClass.setBounds(229, 36, 100, 15);
        frame.getContentPane().add(lblGradeClass);


        String[] choices2 = { "Copper", "Bronze", "Sliver", "Gold", "Platinum", "Diamond", "Champion"};
        JComboBox <String>comboBox_1 = new JComboBox<String>(choices2);
        comboBox_1.setBounds(150, 61, 74, 21);
        frame.getContentPane().add(comboBox_1);

        String[] choices3 = { "0-1599", "1600-2099", "2100-2599", "2600-3199", "3200-4399", "4400-5000"};
        JComboBox <String>comboBox_2 = new JComboBox<String>(choices3);
        comboBox_2.setBounds(229, 61, 112, 21);
        frame.getContentPane().add(comboBox_2);

        JButton btnOk = new JButton("ok");
        btnOk.setBounds(154, 102, 87, 23);
        frame.getContentPane().add(btnOk);
    }
}