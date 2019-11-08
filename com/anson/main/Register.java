package com.anson.main;

import java.io.File;
import java.io.IOException;

public class Register {
    public static void createUser(String UID, String plainPwd, String name, String fullName, String YOB, String remark) throws IOException {
        /*Var*/
        String encryPwd = Encryption.encryption(plainPwd);
        String userPassCombo = UID+","+encryPwd+","+name+","+fullName+","+YOB+","+remark;
        /*File Create Process*/
        File file = new File(Config.uPath);
        FileUtils.writeToNewFile(file, userPassCombo);
    }
}
