package com.anson.main.Utils;

import com.anson.main.G22Config;

import java.io.*;

public class G22FileUtils extends G22Config {
	public static void writeToFile(File file, String data) throws IOException {
		FileWriter writer = new FileWriter(file);
		writer.write(data);
		writer.close();
	}

	public static String readAllFromFile(File file) throws IOException {
		try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String returnText = "";
			String fileLine;
			while((fileLine = reader.readLine()) != null) {
				if(!fileLine.equalsIgnoreCase(G22Config.userHeader)) {
					returnText += fileLine+"\n";
				}
			}
			return returnText;
		}
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
