package com.anson.main;

import com.anson.main.Utils.FileUtils;
import com.anson.main.enums.LoginStatus;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Login {
    private static ArrayList splitUserPassFileByComma() throws IOException{
        String textFromFile = FileUtils.readAllFromFile(new File(Config.uPath));
        String tempArr[] = {};
        ArrayList<String> words = new ArrayList<>();
        tempArr = textFromFile.split(",");
        for(String word : tempArr) {
            words.add(word);
        }
        return words;
    }

    private static boolean isWordExist(String string) throws IOException {
        ArrayList<String> compareDatabase = splitUserPassFileByComma();
        for(int i = 0; i < compareDatabase.size(); i++) {
            if(string.equalsIgnoreCase(compareDatabase.get(i))) {
                return true;
            }
        }
        return false;
    }

    private static String getUsername(String password) throws IOException {
        ArrayList<String> wordDatabase = splitUserPassFileByComma();
        for (int i = 0; i < wordDatabase.size(); i++) {
            if(wordDatabase.get(i).equalsIgnoreCase(password)) {
                return wordDatabase.get(i+1);
            }
        }
        return null;
    }


    public static LoginStatus authentication(String username, String plainPassword) throws IOException {
        String encryPassword = Encryption.encryption(plainPassword);
        boolean isPassExist = isWordExist(encryPassword);
        ArrayList<String> spiltedWords = splitUserPassFileByComma();
        if(isPassExist) {
            if(getUsername(encryPassword).equalsIgnoreCase(username)) {
                return LoginStatus.LOGIN_SUCCESS;
            } else {
                return LoginStatus.LOGIN_FAIL;
            }
        }
        return LoginStatus.LOGIN_FAIL;
    }
}
