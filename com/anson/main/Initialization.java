package com.anson.main;

import com.anson.main.Utils.FileUtils;
import com.anson.main.enums.InitializationStatus;
import com.anson.main.enums.LoginStatus;
import com.kenny.main.Register;

import java.io.File;
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

		if(defaultLogRecordFile.createNewFile() && defaultUserPassFile.createNewFile()) {
			Config.iniStatus = InitializationStatus.SUCCESS;
		} else {
			Config.iniStatus = InitializationStatus.FAILURE;
		}

		/*Create the Default Accounts*/
		Register.createUser("001", "a", "a", "Ng Hoi Yun Gordon", "Administrator", "2000", "Eric Killer");
		Register.createUser("002", "b", "b", "Tsang Cheuk Him Anson", "User","2000", "Eric Destroyer");
		Register.createUser("003", "c", "c", "Chak Chun Yin Kenny", "Administrator","2000", "Eric Boomer");

	}
}
