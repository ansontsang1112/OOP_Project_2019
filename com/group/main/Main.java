package com.group.main;

import com.anson.main.Register;
import com.anson.main.Initialization;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		/*Boot Up the Programme*/
		Initialization.boot();
		/*Create the Default Accounts*/
		Register.createUser("001", "a", "a", "Ng Hoi Yun Gordon", "2000", "Eric Killer");
		Register.createUser("002", "b", "b", "Tsang Cheuk Him Anson", "2000", "Super Saiyan");
		Register.createUser("003", "c", "c", "Chak Chun Yin Kenny", "2000", "Eric Boomer");
	}
}