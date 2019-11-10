package com.anson.main.Utils;

import com.anson.main.Config;
import com.anson.main.enums.Exception;

import java.io.*;

public class FileUtils {
	public static void writeToNewFile(File file, String data) throws IOException {
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

	public static void writeToExistFile(File file, String editFilePath, String data) throws IOException{
		String fileOrgData = "";
		String combData = "";
		fileOrgData = readFromFile(editFilePath);
		combData = fileOrgData+"\n"+data;
		System.out.println(combData);
		//writeToNewFile(file, combData);
	}
}
