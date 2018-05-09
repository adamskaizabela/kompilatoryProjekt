package boot;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import demo.DemoParser;
import demo.ParseException;

public class Parser {

	public static void main(String[] args) throws ParseException, FileNotFoundException {
		FileInputStream is = new FileInputStream(new File(args[0]));
		DemoParser parser = new DemoParser(new BufferedInputStream(is));
		parser.Start();
		
		/*for (Double name : parser.parseFile()) {
			System.out.println("Hello " + name + "!");
		}*/
		
		
	}
	
}
