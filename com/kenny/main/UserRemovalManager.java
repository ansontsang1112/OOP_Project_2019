package com.kenny.main;

import com.anson.main.Config;
import com.anson.main.Utils.GlobalUtils;
import com.anson.main.enums.RemovalStatus;

import java.io.IOException;
import java.util.ArrayList;

public class UserRemovalManager extends Config {
    public static String userRemovalAPI(String username) throws IOException {
        ArrayList<String> list = GlobalUtils.splitUserPassFileByComma(Config.uPath);
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equalsIgnoreCase(username)) {
                return list.get(i);
            }
        }
        return "NOT_FOUND";
    }

    public static RemovalStatus userRemoval(String username) throws IOException {
        return RemovalStatus.REMOVAL_FAILURE;
    }
}
