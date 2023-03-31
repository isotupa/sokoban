package es.upm.pproject.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import es.upm.pproject.exceptions.IllegalFileFormatException;


public class Parse {
	
	/*
	 * Parses a .txt file and outputs a Level object
	 */
	public static Level parseTxt(File file) throws IllegalFileFormatException{
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			// Reads first and second lines
			String title = br.readLine();
			String dim = br.readLine();
			
			Level lvl = new Level(Integer.parseInt(dim.charAt(0)+""), Integer.parseInt(dim.charAt(0)+""));
			lvl.setLvlTitle(title);
			
			int manCount = 0, boxCount = 0, goalCount = 0;
			int x = 0, y = 0, c;
			// Reads the other lines
			while((c = br.read()) != -1) {
				char character = (char)c;
				switch(character) {
				case '+':
					lvl.set(x, y, '+');
					break;
				case '.':
					lvl.set(x, y, '.');
					break;
				case '*':
					goalCount++;
					lvl.set(x, y, '*');
					break;
				case '#':
					boxCount++;
					lvl.set(x, y, '#');
					break;
				case 'W':
					manCount++;
					lvl.set(x, y, 'W');
					break;
				case '\n':
					y++;
					x = -1;
					break;
				case '\r':
					break;
				default:
					throw new IllegalFileFormatException((int)character + " is not recognized as a valid character in the format.");
				}
				x++;
			}
			br.close();
			
			// Check preconditions
			if(boxCount == 0 || goalCount == 0) {
				throw new IllegalFileFormatException("There must be at least one goal and one box position.");
			}
			if(manCount != 1) {
				throw new IllegalFileFormatException("There must be only one warehouse man.");
			}
			if(boxCount != goalCount) {
				throw new IllegalFileFormatException("There must be an equal amount of goals and boxes.");
			}
			return lvl;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
