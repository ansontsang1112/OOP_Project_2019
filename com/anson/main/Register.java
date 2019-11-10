package com.anson.main;

import com.anson.main.Utils.FileUtils;

import java.io.File;
import java.io.IOException;

public class Register {
    public static void createUser(String UID, String plainPwd, String name, String fullName, String role, String YOB, String remark) throws IOException {
        /*Var*/
        String encryPwd = Encryption.encryption(plainPwd);
        String userPassCombo = UID+","+encryPwd+","+name+","+fullName+","+YOB+","+remark;
        /*File Create Process*/
        File file = new File(Config.uPath);
        FileUtils.writeToExistFile(file, Config.uPath, userPassCombo);
    }
}
