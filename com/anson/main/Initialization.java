package com.anson.main;

public class Initialization {
	public static void boot() {
		Config.loginStatus = LoginStatus.INITALIZATION;
		FileUtils.userLoginFileControl();
		System.out.print(Config.uPath);
	}
	
}
