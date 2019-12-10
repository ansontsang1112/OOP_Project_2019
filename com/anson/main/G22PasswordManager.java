package com.anson.main;

import com.anson.main.enums.G22LoginStatus;
import com.anson.main.enums.G22PasswordStatus;

import java.io.*;
import java.util.Scanner;

public class G22PasswordManager {
    private static boolean isEditable(String username) throws IOException {return G22PermissionManager.isAdministrator(username);}

    private static Scanner x;

    private static boolean editPasswordAPI(String editUsername, String newPassword) {
        String encryPwd = G22Encryption.encryption(newPassword);
        Integer resultSet = 0;
        String tempFile = "temp.csv";
        File originalFile = new File(G22Config.getPath(1));
        File newFile = new File(tempFile);
        String UID = ""; String pwd = ""; String username = "";  String fullName = ""; String role = ""; String YOB = ""; String remark = "";
        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            x = new Scanner(new File(G22Config.getPath(1)));
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

    public static G22PasswordStatus changePasswordByAdministrator(String username, String newPassword) throws IOException {
        String currentUsername = G22LoginManager.currentLoginUsername;
        if(currentUsername == G22LoginStatus.NOT_LOGIN.toString()) {
            return G22PasswordStatus.LOGIN_REQUIRED;
        }
        if(!isEditable(currentUsername)) {return G22PasswordStatus.PERMISSION_DENIED;}
        boolean changeResult = editPasswordAPI(username, newPassword);
        if(changeResult) {
            return G22PasswordStatus.UPDATE_SUCCESS;
        } else {
            return G22PasswordStatus.UPDATE_FAILURE;
        }
    }

    public static G22PasswordStatus changePasswordByUser(String newPassword) throws IOException {
        String username = G22LoginManager.currentLoginUsername;
        if(username == G22LoginStatus.NOT_LOGIN.toString()) {
            return G22PasswordStatus.LOGIN_REQUIRED;
        }
        boolean changeResult = editPasswordAPI(username, newPassword);
        if(changeResult) {
            return G22PasswordStatus.UPDATE_SUCCESS;
        } else {
            return G22PasswordStatus.UPDATE_FAILURE;
        }
    }
}
