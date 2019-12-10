package com.anson.main;

import com.anson.main.enums.G22Exception;
import com.anson.main.enums.G22InitializationStatus;
import com.anson.main.enums.G22LoginStatus;

public class G22Config {
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

	/*Public API Access for Class Path Get*/
	public static String getClassPath(int choose) {
		switch (choose) {
			case 0:
				return CDIR+FS+classFilePath[0];
			case 1:
				return CDIR+FS+classFilePath[1];
			case 2:
				return CDIR+FS+classFilePath[2];
			case 3:
				return CDIR+FS+classFilePath[3];
			default:
				return null;
		}
	}

	private static String FS = System.getProperty("file.separator");
	private static String CDIR = System.getProperty("user.dir");
	private static String userDataFile = "G42User.csv";
	private static String loginRecord = "G42LoginRecord.csv";

	protected static String [] classFilePath = {"G42M1TSANG.csv", "G42M2NG.csv", "G42M3HUNG.csv", "G42M4CHAK.csv"};

	/*File INI Header*/
	protected static String userHeader = "U_ID,Encrypted_Pwd,U_Name,Full_Name,U_Role,Year_of_Birth,Remarks";
	protected static String logHeader = "LR_ID,U_ID,Login_Time,Remarks";
	protected static String classHeader = "AR_ID,U_ID,Reserved_Time,Appointment_Type,Time_Record,Remarks";

	/*Path Config*/
	protected static String pathHeader = CDIR+FS;
	protected static String uPath = CDIR+FS+userDataFile;
	protected static String lPath = CDIR+FS+loginRecord;

	/*Default Status*/
	public static G22LoginStatus loginStatus = G22LoginStatus.NULL;
	public static G22InitializationStatus iniStatus = G22InitializationStatus.NULL;
	public static G22Exception exceptionStatus = G22Exception.NA;
}
