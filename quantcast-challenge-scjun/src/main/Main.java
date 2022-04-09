package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cookie.Cookie;
import io.LogReader;

/*
 * 
 * TOMORORW: IMPLEMENT JUNIT TESTING AND FIGURE OUT HOW TO GET THIS RUNNING FROM BASH!
 * 
 * 
 * 
 * 
 * 
 * 
 * https://stackoverflow.com/questions/18902934/compile-and-run-eclipse-project-from-command-prompt
 * 
 * 
 * https://stackoverflow.com/questions/2502518/eclipse-export-running-configuration
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

/**
 * Main class
 * @author storm
 */
public class Main {
	
	/** Error message for bad arguments **/
	public static final String ERROR_BAD_ARGS = "Invalid argument format. Please follow the correct convention: ./most_active_cookie [filename] [-d] [date]";
	
	/** Error message for file error **/
	public static final String ERROR_FILE = "Something went wrong. Please make sure your file is formatted correctly and exists";
	
	/** File path prefix **/
	public static final String PATH_PREFIX = "./";
	
	/**
	 * Main method for Most Active Cookie project.
	 * Evaluates CLI arguments and then gets most active cookies.
	 * @param args
	 */
	public static void main(String[] args) {
		
		/* Evaluate CLI input */
		
		//catch bad args
		if (args.length != 3) {
			System.out.println(ERROR_BAD_ARGS);
			return;
		}
		
		String file = PATH_PREFIX + args[0];
		String flag = args[1];
		String date = args[2];
		
		if(!flag.equals("-d")) {
			System.out.println(ERROR_BAD_ARGS);
			return;
		}
		
		/* Get most active cookies */
		try {
			List<String> res = getMostActiveCookies(file, date);
			
			//print the result
			for (String s : res) {
				System.out.println(s);
			}
			
		} catch (IOException e) {
			System.out.println(ERROR_FILE);
			return;
		}
		
	}
	
	/**
	 * Get the most active cookies for a given date from a cookie log file
	 * @param path the file path
	 * @param date the date to get
	 * @return a list of cookie ID's
	 * @throws IOException if the file could not be found
	 */
	public static List<String> getMostActiveCookies(String path, String date) throws IOException{
		//get cookies 
		List<Cookie> cookies;
		cookies = LogReader.getCookiesFromFile(path);
		
		//remove cookies with incorrect date
		for (int i = 0; i < cookies.size(); i++) {
			if (!cookies.get(i).getDate().equals(date)) {
				cookies.remove(i);
				i--;
			}
		}
		
		//record the number of each occurrence of a cookie in the given date
		Map<String, Integer> counts = new HashMap<>();
		for (Cookie s : cookies) {
			counts.put(s.getId(), counts.getOrDefault(s.getId(), 0) + 1);
		}
		
		//sort by occurrences
		final List<Map.Entry<String, Integer>> sorted = new ArrayList<>(counts.entrySet());
		sorted.sort((a, b) -> (b.getValue() - a.getValue()));
		
		//print out all of the cookies with most occurrences
		List<String> res = new ArrayList<>();
		
		int prev = Integer.MIN_VALUE;
		for (Map.Entry<String, Integer> entry : sorted) {
			if (entry.getValue() < prev) break;
			
			res.add(entry.getKey());
			prev = entry.getValue();
		}
		
		return res;
	}
}
