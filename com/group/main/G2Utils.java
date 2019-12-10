package com.group.main;

import com.anson.main.G22Config;
import com.anson.main.G22LoginManager;
import com.anson.main.Utils.G22FileUtils;
import com.anson.main.Utils.G22GlobalUtils;
import com.anson.main.enums.G22ClassStatus;
import com.anson.main.enums.G22LoginStatus;
import com.kenny.main.G2UserRemovalManager;

import java.time.Instant;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class G2Utils {
    public static boolean isFileExists(String path) {
        File tempFile = new File(path);
        return tempFile.exists();
    }

    public static String informationStringFormatter() throws IOException {
        String result = "";
        ArrayList<String> list = G22GlobalUtils.splitUserPassFileByComma(G22Config.getPath(1));
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equalsIgnoreCase(G22LoginManager.currentLoginUsername)) {
                String [] parts = list.get(i+4).split("\n");
                result = "User ID: " + list.get(i-2) + "\nPassword in MD5: " + list.get(i-1) + "\nUsername: " + list.get(i) +
                        "\nYour Register Name: " + list.get(i+1) + "\nRole: " + list.get(i+2) + "\nYear of Birth: " + list.get(i+3) +
                        "\nRemark: " + parts[0];
                return result;
            }
        }
        return null;
    }

    public static boolean isUserExist(String username) throws IOException {
        ArrayList<String> spiltWords = G22GlobalUtils.splitUserPassFileByComma(G22Config.getPath(1));
        for(int i = 0; i < spiltWords.size(); i++) {
            if(username.equalsIgnoreCase(spiltWords.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static String getFullName(String username) throws IOException {
        ArrayList<String> spiltWords = G22GlobalUtils.splitUserPassFileByComma(G22Config.getPath(1));
        for(int i = 0; i < spiltWords.size(); i++) {
            if(username.equalsIgnoreCase(spiltWords.get(i))) {
                return spiltWords.get(i+1);
            }
        }
        return null;
    }

    public static G22ClassStatus classRegisterAPI(int classNumber, String ARID, String rsTime, String aType, String remark) throws IOException {
        String filePathHandler = null;
        if(classNumber == 0) {filePathHandler = G22Config.getClassPath(0);}
        if(classNumber == 1) {filePathHandler = G22Config.getClassPath(1);}
        if(classNumber == 2) {filePathHandler = G22Config.getClassPath(2);}
        if(classNumber == 3) {filePathHandler = G22Config.getClassPath(3);}

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Instant instant = timestamp.toInstant();
        Timestamp currentTS = Timestamp.from(instant);
        long recordTime = currentTS.getTime();

        String currentUsername = G22LoginManager.currentLoginUsername;
        if(currentUsername == G22LoginStatus.NOT_LOGIN.toString()) {return G22ClassStatus.NOT_LOGIN;}
        String UID = G2UserRemovalManager.UIDHandler(currentUsername);

        /*Var*/
        String classCombo = ARID+","+UID+","+rsTime+","+aType+","+recordTime+","+remark;

        /*File Create Process*/
        File file = new File(filePathHandler);
        G22FileUtils.appendToFile(file, classCombo);
        return G22ClassStatus.CLASS_SUCCESS_APPOINTED;
    }

    public static String maxUID() throws IOException{
        ArrayList<String>list = G22GlobalUtils.splitUserPassFileByComma(G22Config.getPath(1));
        String [] w = list.get(list.size()-7).split("\n");
        return w[1];
    }

}
