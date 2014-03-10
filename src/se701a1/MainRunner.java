package se701a1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import med.*;

public class MainRunner {

	public static void main(String[] args) {
		boolean debug = true; 
		for (int i = 1; i <= 22; i++ ) {
			String fil = "tests"+System.getProperty("file.separator")+"input"+i+".txt";
			File f = new File(fil);
			try {
				FileInputStream is = new FileInputStream(f);
				MedParser parser = new MedParser(is);
				if(debug) {
					try {
						parser.MedCenter();
						System.out.println(f.getName()+" OK");
						System.out.println("------------------------------------");
					} catch (TokenMgrError e) {
						System.err.print(f.getName()+" failed in the Scanner: ");
						System.err.println(e.getMessage());;
						System.err.println("------------------------------------");
					} catch (ParseException e) {
						System.err.print(f.getName()+" failed in the Parser: ");
						System.err.println(e.getMessage());;
						System.err.println("------------------------------------");
					}
				} else {

				}
			} catch (FileNotFoundException e) {
				System.err.println("Cannot find "+f.getName());
				System.err.println("------------------------------------");
			}
		}
	}
}