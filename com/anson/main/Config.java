package com.anson.main;

public class Config {
	static String FS = System.getProperty("file.separator");
	static String CDIR = System.getProperty("user.dir");
	static String ULFN = "G42User";
	static String ULFS = ".csv";
	
	protected static String uPath = CDIR+FS+ULFN+ULFS;
	public static LoginStatus loginStatus = LoginStatus.NULL;
	
	
}
