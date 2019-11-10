package com.anson.main;

import com.anson.main.Utils.FileUtils;
import com.anson.main.enums.InitializationStatus;
import com.anson.main.enums.LoginStatus;

import java.io.File;
import java.io.IOException;

public class Initialization {
	public static void boot() throws IOException {
		/*Set Login Status to INITIALIZATION*/
		Config.loginStatus = LoginStatus.INITIALIZATION;

		/*Create Default User-Pass File*/
		File defaultUserPassFile = new File(Config.uPath);
		FileUtils.writeToNewFile(defaultUserPassFile, Config.userHeader);

		/*Create Default Log-Record File*/
		File defaultLogRecordFile = new File(Config.lPath);
		FileUtils.writeToNewFile(defaultLogRecordFile, Config.logHeader);

		if(defaultLogRecordFile.createNewFile() && defaultUserPassFile.createNewFile()) {
			Config.iniStatus = InitializationStatus.SUCCESS;
		} else {
			Config.iniStatus = InitializationStatus.FAILURE;
		}

	}
}
