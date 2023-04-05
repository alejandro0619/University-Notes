package file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Parser {
	File path;
	
	public Parser() throws IOException {
		this.path = new File("./db.txt");
		
	}
}
