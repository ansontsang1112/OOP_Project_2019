package com.group.main;

import com.anson.main.Config;
import com.anson.main.Initialization;
import com.anson.main.Utils.FileUtils;


import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        /*Boot Up the Programme*/
        if (!Utils.isFileExists(Config.getPath(1)) || !Utils.isFileExists(Config.getPath(2))) {
            Initialization.boot();
        }
        /*Create the Default Accounts*/
        System.out.println(FileUtils.compareLineToFile(new File(Config.getPath(1)), "001,cc175b9c0f1b6a831c399e269772661,a,Ng Hoi Yun Gordon,2000,Eric Killer"));
    }
}