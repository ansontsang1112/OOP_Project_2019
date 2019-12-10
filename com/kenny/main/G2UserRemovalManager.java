package com.kenny.main;

import com.anson.main.G22Config;
import com.anson.main.G22LoginManager;
import com.anson.main.G22PermissionManager;
import com.anson.main.Utils.G22GlobalUtils;
import com.anson.main.enums.G22LoginStatus;
import com.anson.main.enums.G22RemovalStatus;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class G2UserRemovalManager extends G22Config {
    private static Scanner x;

    private static boolean removalAPI(String editableUsername) {
        Integer resultSet = 0;
        String deleteSign = "----";
        String tempFile = "removalAPI.csv";
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
                if(UID.equalsIgnoreCase(UIDHandler(editableUsername))) {
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

    public static String UIDHandler(String username) throws IOException {
        ArrayList<String> list = G22GlobalUtils.splitUserPassFileByComma(G22Config.uPath);
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equalsIgnoreCase(username)) {
                if(list.get(i-2).equalsIgnoreCase("001")) {
                    return list.get(i-2);
                } else {
                    String[] tempArray = list.get(i - 2).split("\n");
                    return tempArray[1];
                }
            }
        }
        return "NOT_FOUND";
    }

    public static G22RemovalStatus userRemoval(String username) throws IOException {
        if(G22LoginManager.currentLoginUsername == G22LoginStatus.NOT_LOGIN.toString()) {return G22RemovalStatus.LOGIN_REQUIRED;}
        if(!G22PermissionManager.isAdministrator(G22LoginManager.currentLoginUsername)) {return G22RemovalStatus.PERMISSION_DENIDED;}
        boolean result = removalAPI(username);
        if(result) {
            return G22RemovalStatus.REMOVAL_SUCCESS;
        }
        return G22RemovalStatus.REMOVAL_FAILURE;
    }
}
