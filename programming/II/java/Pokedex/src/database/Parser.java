package database;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Parser extends DbHandler {
	public Parser(String path) throws IOException {
		super(path);
	}
	public Vector<DbScheme> read() throws IOException {
		Scanner scFile = new Scanner(path);
		Vector<DbScheme> readBuffer = new Vector<DbScheme>();
		
		while(scFile.hasNextLine()) {
			
			String line = scFile.nextLine();
			String[] colData = line.split("-");
			readBuffer.add(new DbScheme(
					colData[0],
					colData[1],
					colData[2],
					colData[3],
					colData[4],
					colData[5]
			));
		}
		scFile.close();
		return readBuffer;
		
	}
	public void write(ArrayList<String> data) throws IOException {
		FileWriter fw = new FileWriter(path, true);
		StringBuilder sb = new StringBuilder();
		for(int index = 0; index < data.size(); index++) {
			sb.append(data.get(index).concat("-"));
			if(index == 5) {
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
		fw.write(sb.toString());
		fw.flush();
		fw.close();
	}
}