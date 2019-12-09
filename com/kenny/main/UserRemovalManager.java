package com.kenny.main;

import com.anson.main.Config;
import com.anson.main.Encryption;
import com.anson.main.LoginManager;
import com.anson.main.PermissionManager;
import com.anson.main.Utils.GlobalUtils;
import com.anson.main.enums.LoginStatus;
import com.anson.main.enums.RemovalStatus;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserRemovalManager extends Config {
    private static Scanner x;

    private static boolean editPasswordAPI(String editUsername) {
        Integer resultSet = 0;
        String deleteSign = "----";
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
                if(UID.equalsIgnoreCase(editUsername)) {
                    pw.println(deleteSign+","+deleteSign+","+deleteSign+","+deleteSign+","+deleteSign+","+deleteSign+","+deleteSign);
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

    private static String UIDHandler(String username) throws IOException {
        ArrayList<String> list = GlobalUtils.splitUserPassFileByComma(Config.uPath);
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equalsIgnoreCase(username)) {
                String [] tempArray = list.get(i-2).split("\n");
                return tempArray[1];
            }
        }
        return "NOT_FOUND";
    }

    public static RemovalStatus userRemoval(String username) throws IOException {
        if(LoginManager.currentLoginUsername == LoginStatus.NOT_LOGIN.toString()) {return RemovalStatus.LOGIN_REQUIRED;}
        if(!PermissionManager.isAdministrator(username)) {return RemovalStatus.PERMISSION_DENIDED;}

        return RemovalStatus.REMOVAL_FAILURE;
    }
}
