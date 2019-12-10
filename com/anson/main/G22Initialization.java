package com.anson.main;

import com.anson.main.Utils.G22FileUtils;
import com.anson.main.enums.G22InitializationStatus;
import com.anson.main.enums.G22LoginStatus;
import com.kenny.main.G22RegisterManager;

import java.io.File;
import java.io.IOException;

public class G22Initialization {
	public static void boot() throws IOException {
		/*Set Login Status to INITIALIZATION*/
		G22Config.loginStatus = G22LoginStatus.INITIALIZATION;

		/*Create Default User-Pass File*/
		File defaultUserPassFile = new File(G22Config.uPath);
		G22FileUtils.writeToFile(defaultUserPassFile, G22Config.userHeader);

		/*Create Default Log-Record File*/
		File defaultLogRecordFile = new File(G22Config.lPath);
		G22FileUtils.writeToFile(defaultLogRecordFile, G22Config.logHeader);

		/*Create Default Class File*/
		for(int i = 0; i < 4; i++) {
			File file = new File(G22Config.pathHeader+ G22Config.classFilePath[i]);
			G22FileUtils.writeToFile(file, G22Config.classHeader);
		}

		/*Create the Default Accounts*/
		G22RegisterManager.createUser("001", "a", "a", "Ng Hoi Yun Gordon", "Administrator", "2000", "Eric Killer");
		G22RegisterManager.createUser("002", "g", "g1", "Tsang Cheuk Him Anson", "User","2000", "Eric Destroyer");
		G22RegisterManager.createUser("003", "g", "g2", "Chak Chun Yin Kenny", "Administrator","2000", "Eric Boomer");
		G22RegisterManager.createUser("004", "g", "g3", "Hung Ka Chun KC", "User", "2000", "Eric Operator");

		if(defaultLogRecordFile.createNewFile() && defaultUserPassFile.createNewFile()) {
			G22Config.iniStatus = G22InitializationStatus.SUCCESS;
		} else {
			G22Config.iniStatus = G22InitializationStatus.FAILURE;
		}
	}
}
