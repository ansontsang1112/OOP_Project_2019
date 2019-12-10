package com.group.main;

import com.anson.main.G22Config;
import com.anson.main.G22Initialization;

import java.io.IOException;

public class Main {
    public static String tempName = "";
    public static Integer tempInt = -1;
    public static void main(String[] args) throws IOException {
        /*Boot Up the Programme*/
        if (!G2Utils.isFileExists(G22Config.getPath(1)) || !G2Utils.isFileExists(G22Config.getPath(2))) {
            G22Initialization.boot();
        }
        G22HomePageGUI.HomePageGUIEXE();
    }
}