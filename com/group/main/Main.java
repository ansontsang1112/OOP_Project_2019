package com.group.main;

import com.anson.main.Initialization;
import com.gordon.main.GordonTest;
import com.kc.main.KCTest;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		/*Boot Up the Programme*/
		Initialization.boot();
		/*Create the Default Accounts*/

		System.out.println(GordonTest.accessPath);
		System.out.println(KCTest.fuckEric());
		}
}