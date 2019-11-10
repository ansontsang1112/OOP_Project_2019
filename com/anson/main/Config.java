package com.anson.main;

import com.anson.main.enums.Exception;
import com.anson.main.enums.InitializationStatus;
import com.anson.main.enums.LoginStatus;

public class Config {
	/*Public API Access for Path Get*/
	public static String getPath(int choose) {
		switch (choose) {
			case 1:
				return uPath;
			case 2:
				return lPath;
			default:
				return null;
		}
	}

	private static String FS = System.getProperty("file.separator");
	private static String CDIR = System.getProperty("user.dir");
	private static String userDataFile = "G42User.csv";
	private static String loginRecord = "G42LoginRecord.csv";

	/*File INI Header*/
	protected static String userHeader = "U_ID,Encrypted_Pwd,U_Name,Full_Name,U_Role,Year_of_Birth,Remarks";
	protected static String logHeader = "LR_ID,U_ID,Login_Time,Remarks";

	/*Path Config*/
	protected static String uPath = CDIR+FS+userDataFile;
	protected static String lPath = CDIR+FS+loginRecord;

	/*Default Status*/
	public static LoginStatus loginStatus = LoginStatus.NULL;
	public static InitializationStatus iniStatus = InitializationStatus.NULL;
	public static Exception exceptionStatus = Exception.NA;
}
