package com.anson.main;

import com.anson.main.enums.LoginStatus;
import com.anson.main.enums.PasswordStatus;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswordManager {
    private static boolean isEditable(String username) throws IOException {return PermissionManager.isAdministrator(username);}

    private static Scanner x;

    private static boolean editPasswordAPI(String editUsername, String newPassword) {
        String encryPwd = Encryption.encryption(newPassword);
        Integer resultSet = 0;
        String tempFile = "temp.csv";
        File originalFile = new File(Config.getPath(1));
        File newFile = new File(tempFile);
        String UID = ""; String pwd = ""; String username = "";  String fullName = ""; String role = ""; String YOB = ""; String remark = "";
        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            x = new Scanner(new File(Config.getPath(1)));
            x.useDelimiter("[,\n]");

            while(x.hasNext()) {
                UID = x.next();
                pwd = x.next();
                username = x.next();
                fullName = x.next();
                role = x.next();
                YOB = x.next();
                remark = x.next();
                if(username.equalsIgnoreCase(editUsername)) {
                    pw.println(UID+","+encryPwd+","+username+","+fullName+","+role+","+YOB+","+remark);
                    resultSet = 1;
                } else {
                    pw.println(UID + "," + pwd + "," + username + "," + fullName + "," + role + "," + YOB + "," + remark);
                }
            }
            x.close();
            pw.flush();
            pw.checkError();
            originalFile.delete();
            pw.close();
            bw.close();
            fw.close();
            newFile.renameTo(new File("G42User.csv"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(resultSet == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static PasswordStatus changePasswordwithAdminRole(String username, String newPassword) throws IOException {
        String currentUsername = LoginManager.currentLoginUsername;
        if(currentUsername == LoginStatus.NOT_LOGIN.toString()) {
            return PasswordStatus.LOGIN_REQUIRED;
        }
        if(!isEditable(currentUsername)) {return PasswordStatus.PERMISSION_DENIED;}
        boolean changeResult = editPasswordAPI(username, newPassword);
        if(changeResult) {
            return PasswordStatus.UPDATE_SUCCESS;
        } else {
            return PasswordStatus.UPDATE_FAILURE;
        }
    }

    public static PasswordStatus changePasswordwithPersonalRole(String newPassword) throws IOException {
        if(LoginManager.currentLoginUsername == LoginStatus.NOT_LOGIN.toString()) {
            return PasswordStatus.LOGIN_REQUIRED;
        }

        boolean changeResult = editPasswordAPI(LoginManager.currentLoginUsername, newPassword);
        if(changeResult) {
            return PasswordStatus.UPDATE_SUCCESS;
        } else {
            return PasswordStatus.UPDATE_FAILURE;
        }
    }
}
