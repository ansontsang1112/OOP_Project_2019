package com.anson.main;

import com.anson.main.Utils.FileUtils;
import com.anson.main.enums.InitializationStatus;
import com.anson.main.enums.LoginStatus;
import com.kenny.main.RegisterManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Initialization {
	public static void boot() throws IOException {
		/*Set Login Status to INITIALIZATION*/
		Config.loginStatus = LoginStatus.INITIALIZATION;

		/*Create Default User-Pass File*/
		File defaultUserPassFile = new File(Config.uPath);
		FileUtils.writeToFile(defaultUserPassFile, Config.userHeader);

		/*Create Default Log-Record File*/
		File defaultLogRecordFile = new File(Config.lPath);
		FileUtils.writeToFile(defaultLogRecordFile, Config.logHeader);

		/*Create Default Class File*/
		for(int i = 0; i < 4; i++) {
			File file = new File(Config.pathHeader+Config.classFilePath[i]);
			FileUtils.writeToFile(file, Config.classHeader);
		}

		/*Create the Default Accounts*/
		RegisterManager.createUser("001", "a", "a", "Ng Hoi Yun Gordon", "Administrator", "2000", "Eric Killer");
		RegisterManager.createUser("002", "b", "b", "Tsang Cheuk Him Anson", "User","2000", "Eric Destroyer");
		RegisterManager.createUser("003", "c", "c", "Chak Chun Yin Kenny", "Administrator","2000", "Eric Boomer");
		RegisterManager.createUser("004", "d", "d", "Hung Ka Chun KC", "User", "2000", "Eric Operator");

		if(defaultLogRecordFile.createNewFile() && defaultUserPassFile.createNewFile()) {
			Config.iniStatus = InitializationStatus.SUCCESS;
		} else {
			Config.iniStatus = InitializationStatus.FAILURE;
		}
	}
}
