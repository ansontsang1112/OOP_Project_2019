package com.anson.main;

import java.io.*;

public class FileUtils {
	public static void writeToNewFile(File file, String data) throws IOException {
		FileWriter writer = new FileWriter(file);
		writer.write(data);
		writer.close();
	}

	public static String readFromFile(String path) throws IOException {
		String resultString = "";
		/*InI of Reader*/
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(path));
			String resultLine = reader.readLine();
			/*Read Next Line*/
			while(resultLine!=null) {
				resultLine = reader.readLine();
			}
			reader.close();
			resultString = resultLine;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resultString;
	}

	public static void writeToExistFile() {}
}
