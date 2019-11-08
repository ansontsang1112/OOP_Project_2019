package com.group.main;

import com.anson.main.Config;
import com.anson.main.FileUtils;
import com.anson.main.Initialization;
import com.anson.main.Register;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		/*Boot Up the Programme*/
		Initialization.boot();
		System.out.println(FileUtils.readFromFile(Config.getPath(1)));
		/*Create the Default Accounts*/
		//Register.createUser("001", "a", "a", "Ng Hoi Yun, Gordon", "2000", "Eric Killer");
	}
}