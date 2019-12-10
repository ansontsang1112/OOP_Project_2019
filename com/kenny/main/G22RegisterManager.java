package com.kenny.main;

import com.anson.main.G22Config;
import com.anson.main.G22Encryption;
import com.anson.main.Utils.G22FileUtils;
import com.anson.main.enums.G22RegisterStatus;

import java.io.File;
import java.io.IOException;

public class G22RegisterManager {
    public static G22RegisterStatus createUser(String UID, String plainPwd, String name, String fullName, String role, String YOB, String remark) throws IOException {
        /*Var*/
        String encryPwd = G22Encryption.encryption(plainPwd);
        String userPassCombo = UID+","+encryPwd+","+name+","+fullName+","+role+","+YOB+","+remark;

        /*File Create Process*/
        File file = new File(G22Config.getPath(1));
        G22FileUtils.appendToFile(file, userPassCombo);

        return G22RegisterStatus.SUCCESS;
    }
}
