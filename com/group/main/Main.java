package com.group.main;

import com.anson.main.Config;
import com.anson.main.Initialization;
import com.anson.main.LoginManager;
import com.anson.main.PasswordManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /*Boot Up the Programme*/
        if (!Utils.isFileExists(Config.getPath(1)) || !Utils.isFileExists(Config.getPath(2))) {
            Initialization.boot();
        }

        System.out.println(LoginManager.authentication("a", "a"));
        System.out.println(PasswordManager.changePassword("a", "b"));
    }
}