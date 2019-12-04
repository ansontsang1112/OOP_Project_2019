package com.anson.main;

import com.anson.main.enums.LoginStatus;
import com.anson.main.enums.PasswordStatus;

import java.io.IOException;

public class PasswordManagement {
    private static boolean isEditable(String username) throws IOException {return PermissionManagement.isAdministrator(username);}

    public static PasswordStatus changePassword(String username, String newPassword) throws IOException {
        String currentUsername = Login.currentLoginUsername;
        if(currentUsername == LoginStatus.NOT_LOGIN.toString()) {
            return PasswordStatus.LOGIN_REQUIRED;
        }
        if(!isEditable(currentUsername)) {return PasswordStatus.PERMISSION_DENIED;}

        return PasswordStatus.UPDATE_FAILURE;
    }
}
