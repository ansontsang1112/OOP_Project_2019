package com.anson.main;

import com.anson.main.Utils.G22FileUtils;
import com.anson.main.Utils.G22GlobalUtils;
import com.anson.main.enums.G22LoginStatus;
import com.kenny.main.G2UserRemovalManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class G22LoginManager {

    /* Get the Username By Password*/
    public static String getUsername(String password) throws IOException {
        ArrayList<String> wordDatabase = G22GlobalUtils.splitUserPassFileByComma(G22Config.uPath);
        for (int i = 0; i < wordDatabase.size(); i++) {
            if(wordDatabase.get(i).equalsIgnoreCase(password)) {
                return wordDatabase.get(i+1);
            }
        }
        return null;
    }

    public static String currentLoginUsername = G22LoginStatus.NOT_LOGIN.toString();

    public static G22LoginStatus authentication(String username, String plainPassword) throws IOException {
        String encryPassword = G22Encryption.encryption(plainPassword);
        boolean isPassExist = G22GlobalUtils.isWordExist(encryPassword, G22Config.uPath);
        if(isPassExist) {
            if(getUsername(encryPassword).equalsIgnoreCase(username)) {
                currentLoginUsername = username;
                String logs = UUID.randomUUID() + "," + G2UserRemovalManager.UIDHandler(username) + "," + java.util.Calendar.getInstance().getTime() + "," + "Success";
                G22FileUtils.appendToFile(new File(G22Config.lPath), logs);
                return G22LoginStatus.LOGIN_SUCCESS;
            } else {
                String logs = UUID.randomUUID() + "," + G2UserRemovalManager.UIDHandler(username) + "," + java.util.Calendar.getInstance().getTime() + "," + "Failure";
                G22FileUtils.appendToFile(new File(G22Config.lPath), logs);
                return G22LoginStatus.LOGIN_FAIL;
            }
        }
        return G22LoginStatus.LOGIN_FAIL;
    }
}
