package database;

import java.io.File;
import java.io.IOException;

public class DbHandler {
	protected File path;
	
	public DbHandler(String path) throws IOException {
		this.path = new File(path.concat(".txt"));
		
		try {
			this.path.createNewFile();
			
		} catch( IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
