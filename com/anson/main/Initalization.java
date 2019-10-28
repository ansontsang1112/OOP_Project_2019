package com.anson.main;

public class Initalization {
	LoginStatus status = Config.loginStatus;
	
	public static void boot() {
		FileUtils.userLoginFileControl();
		System.out.print(Config.uPath);
	}
	
}
