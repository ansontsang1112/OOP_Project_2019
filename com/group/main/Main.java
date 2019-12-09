package com.group.main;

import com.anson.main.Config;
import com.anson.main.Initialization;
import com.anson.main.LoginManager;
import com.anson.main.PasswordManager;
import com.anson.main.enums.LoginStatus;
import com.anson.main.enums.RegisterStatus;
import com.kc.main.LoginGUI;
import com.kenny.main.RegisterManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /*Boot Up the Programme*/
        if (!Utils.isFileExists(Config.getPath(1)) || !Utils.isFileExists(Config.getPath(2))) {
            Initialization.boot();
        }
        LoginGUI myApp = new LoginGUI();// Create object of our JFrame
        myApp.setVisible(true); // show our JFrame (set visible)
        System.out.println("END of main() method!");

    }
}