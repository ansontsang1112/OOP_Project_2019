package com.anson.main;

import com.anson.main.Utils.GlobalUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PermissionManager extends Config{
    public static String roleHandler(String username) throws IOException {
        ArrayList<String>list = GlobalUtils.splitUserPassFileByComma(Config.uPath);
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equalsIgnoreCase(username)) {
                if(list.get(i+2).equalsIgnoreCase("Administrator")) {
                    return "Administrator";
                }
            }
        }
        return "User";
    }

    private static Scanner x;

    public static boolean editPermission(String editUsername, String newRole) {
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
                    pw.println(UID+","+pwd+","+username+","+fullName+","+newRole+","+YOB+","+remark);
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

    public static boolean isAdministrator(String username) throws IOException {
        ArrayList<String>list = GlobalUtils.splitUserPassFileByComma(Config.uPath);
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equalsIgnoreCase(username)) {
                if(list.get(i+2).equalsIgnoreCase("Administrator")) {
                    return true;
                }
            }
        }
        return false;
    }
}
