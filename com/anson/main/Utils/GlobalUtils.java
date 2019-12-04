package com.anson.main.Utils;

import com.anson.main.Config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GlobalUtils extends Config {
    /* Split User-Pass File By Comma */
    public static ArrayList splitUserPassFileByComma(String filePath) throws IOException {
        String textFromFile = FileUtils.readAllFromFile(new File(filePath));
        String tempArr[] = {};
        ArrayList<String> words = new ArrayList<>();
        tempArr = textFromFile.split(",");
        for(String word : tempArr) {
            words.add(word);
        }
        return words;
    }

    /* Check is the Word Exist in User Pass File */
    public static boolean isWordExist(String string, String filePath) throws IOException {
        ArrayList<String> compareDatabase = splitUserPassFileByComma(filePath);
        for(int i = 0; i < compareDatabase.size(); i++) {
            if(string.equalsIgnoreCase(compareDatabase.get(i))) {
                return true;
            }
        }
        return false;
    }
}
