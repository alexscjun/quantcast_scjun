package io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cookie.Cookie;

/**
 * Reads CSV logs
 * @author storm
 *
 */
public class LogReader {
	
	/**
	 * Returns a list of cookies read from a file
	 * Invalid cookies are simply ignored
	 * @param path the file path to read from
	 * @return a list of cookies
	 * @throws IOException if an io error occurred
	 */
	public static List<Cookie> getCookiesFromFile(String path) throws IOException{
		
		//initialize file scanner
		Scanner fs;
		try {
			fs = new Scanner(new File(path));
		} catch (Exception e) {
			throw new IOException();
		}
		
		//initialize return variable
		List<Cookie> res = new ArrayList<>();
		
		//skip first line 
		if (fs.hasNextLine()) fs.nextLine();
		
		//read file line by line
		while (fs.hasNextLine()) {
			String line = fs.nextLine();
			try {
				res.add(new Cookie(line));
			} catch (Exception e) {
				//simply ignore invalid cookies
			}
			
		}
		
		return res;
	}
}
