package com.group.main;

import com.anson.main.Config;
import com.anson.main.LoginManager;
import com.anson.main.Utils.FileUtils;
import com.anson.main.enums.ClassStatus;
import com.anson.main.enums.LoginStatus;
import com.kenny.main.UserRemovalManager;

import java.time.Instant;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

public class Utils {
    public static boolean isFileExists(String path) {
        File tempFile = new File(path);
        return tempFile.exists();
    }

    public static ClassStatus classRegisterAPI(int classNumber, String ARID, String rsTime, String aType, String remark) throws IOException {
        String filePathHandler = null;
        if(classNumber == 0) {filePathHandler = Config.getClassPath(0);}
        if(classNumber == 1) {filePathHandler = Config.getClassPath(1);}
        if(classNumber == 2) {filePathHandler = Config.getClassPath(2);}
        if(classNumber == 3) {filePathHandler = Config.getClassPath(3);}

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Instant instant = timestamp.toInstant();
        Timestamp currentTS = Timestamp.from(instant);
        long recordTime = currentTS.getTime();

        String currentUsername = LoginManager.currentLoginUsername;
        if(currentUsername == LoginStatus.NOT_LOGIN.toString()) {return ClassStatus.NOT_LOGIN;}
        String UID = UserRemovalManager.UIDHandler(currentUsername);

        /*Var*/
        String classCombo = ARID+","+UID+","+rsTime+","+aType+","+recordTime+","+remark;

        /*File Create Process*/
        File file = new File(filePathHandler);
        FileUtils.appendToFile(file, classCombo);
        return ClassStatus.CLASS_SUCCESS_APPOINTED;
    }


}
