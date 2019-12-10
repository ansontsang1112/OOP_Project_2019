package com.anson.main;

import com.anson.main.Utils.GlobalUtils;

import java.io.IOException;
import java.util.ArrayList;

public class PermissionManager extends Config{
    public static String roleHandler(String username) throws IOException {
        ArrayList<String>list = GlobalUtils.splitUserPassFileByComma(Config.uPath);
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equalsIgnoreCase(username)) {
                if(list.get(i+2).equalsIgnoreCase("Administrator")) {
                    return "Administrator";
                }
            }
        }
        return "User";
    }

    public static boolean isAdministrator(String username) throws IOException {
        ArrayList<String>list = GlobalUtils.splitUserPassFileByComma(Config.uPath);
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equalsIgnoreCase(username)) {
                if(list.get(i+2).equalsIgnoreCase("Administrator")) {
                    return true;
                }
            }
        }
        return false;
    }
}
