package com.group.main;

import java.io.File;

public class Utils {
    public static boolean isFileExists(String path) {
        File tempFile = new File(path);
        return tempFile.exists();
    }
}
