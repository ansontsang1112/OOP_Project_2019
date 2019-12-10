package com.gordon.main;

import javax.swing.*;

public class G22AboutUsGUI extends JFrame{
    public G22AboutUsGUI() {
        JOptionPane.showMessageDialog(null,
                "Members(left to right):\n" +
                        "Name&Number\n Ng Hoi Yun 20089244\n Tsang Cheuk Him 20089261\n Hung Ka Chun 20079467\n Chak Chun Yin 20089310",
                "About Me: G22m2, 2019-2020, OOP",
                JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon("us.png"));
    }
}
