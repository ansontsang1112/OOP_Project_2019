package com.anson.main;

import com.anson.main.Utils.FileUtils;
import com.anson.main.Utils.GlobalUtils;
import com.anson.main.enums.LoginStatus;
import com.kenny.main.UserRemovalManager;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.UUID;

public class LoginManager {

    /* Get the Username By Password*/
    public static String getUsername(String password) throws IOException {
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
                String logs = UUID.randomUUID() + "," + UserRemovalManager.UIDHandler(username) + "," + java.util.Calendar.getInstance().getTime() + "," + "Success";
                FileUtils.appendToFile(new File(Config.lPath), logs);
                return LoginStatus.LOGIN_SUCCESS;
            } else {
                String logs = UUID.randomUUID() + "," + UserRemovalManager.UIDHandler(username) + "," + java.util.Calendar.getInstance().getTime() + "," + "Failure";
                FileUtils.appendToFile(new File(Config.lPath), logs);
                return LoginStatus.LOGIN_FAIL;
            }
        }
        return LoginStatus.LOGIN_FAIL;
    }
}
