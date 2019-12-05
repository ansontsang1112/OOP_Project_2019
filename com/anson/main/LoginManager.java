package com.anson.main;

import com.anson.main.Utils.FileUtils;
import com.anson.main.Utils.GlobalUtils;
import com.anson.main.enums.LoginStatus;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LoginManager {

    /* Get the Username By Password*/
    private static String getUsername(String password) throws IOException {
        ArrayList<String> wordDatabase = GlobalUtils.splitUserPassFileByComma(Config.uPath);
        for (int i = 0; i < wordDatabase.size(); i++) {
            if(wordDatabase.get(i).equalsIgnoreCase(password)) {
                return wordDatabase.get(i+1);
            }
        }
        return null;
    }

    public static String currentLoginUsername = LoginStatus.NOT_LOGIN.toString();

    public static LoginStatus authentication(String username, String plainPassword) throws IOException {
        String encryPassword = Encryption.encryption(plainPassword);
        boolean isPassExist = GlobalUtils.isWordExist(encryPassword, Config.uPath);
        if(isPassExist) {
            if(getUsername(encryPassword).equalsIgnoreCase(username)) {
                currentLoginUsername = username;
                return LoginStatus.LOGIN_SUCCESS;
            } else {
                return LoginStatus.LOGIN_FAIL;
            }
        }
        return LoginStatus.NULL;
    }
}
