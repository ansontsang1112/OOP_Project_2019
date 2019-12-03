package com.anson.main.Utils;

import com.anson.main.Config;
import com.anson.main.enums.Exception;

import java.io.*;
import java.util.Scanner;

public class FileUtils {
	public static void writeToFile(File file, String data) throws IOException {
		FileWriter writer = new FileWriter(file);
		writer.write(data);
		writer.close();
	}

	public static String readFromFile(String path) throws IOException {
		String readerString = "";
		String returnString = "";
		String[] stringBuffer = {};
		BufferedReader csvReader = null;
		try {
			csvReader = new BufferedReader(new FileReader(path));
			while ((readerString = csvReader.readLine()) != null) {
				stringBuffer = readerString.split(",");
			}
		} catch (FileNotFoundException e) {
			Config.exceptionStatus = Exception.FileNotFound;
		} catch (IOException e) {
			Config.exceptionStatus = Exception.IO;
		} finally {
			try {
				if (csvReader != null) {
					csvReader.close();
				}
			} catch (IOException e) {
				Config.exceptionStatus = Exception.IO;
			}
		}
		returnString = StringUtils.csvFormatter(stringBuffer);
		return returnString;
	}

	public static boolean compareLineToFile(File file, String compareOrg) throws IOException {
		try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String fileLine;
			while((fileLine = reader.readLine()) != null) {
				if(fileLine.equalsIgnoreCase(compareOrg)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void appendToFile(File file, String data) throws IOException {
		FileWriter writer = new FileWriter(file, true);
		writer.write("\n");
		writer.write(data);
		writer.close();
	}
}
