package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests main class
 * @author storm
 *
 */
public class MainTest {
	
	/*
	 * Setup method
	 */
	@BeforeEach
	void setUp() {

	}
	
	/*
	 * Provided test 1
	 */
	@Test
	void testMain1() throws Exception {
		System.out.println("Running system test 1:");
		String file = Main.PATH_PREFIX + "test-files/cookie_log.csv";
		String date = "2018-12-09"; 
		
		List<String> res = Main.getMostActiveCookies(file, date);
		
		//print the result
		for (String s : res) {
			System.out.println(s);
		}
		
		//assertions
		assertEquals(1, res.size());
		assertEquals("AtY0laUfhglK3lC7", res.get(0));
		System.out.println("");
	}
	
	/*
	 * Provided test 2
	 */
	@Test
	void testMain2() throws Exception {
		System.out.println("Running system test 2:");
		String file = Main.PATH_PREFIX + "test-files/cookie_log.csv";
		String date = "2018-12-08"; 
		
		List<String> res = Main.getMostActiveCookies(file, date);
		
		//print the result
		for (String s : res) {
			System.out.println(s);
		}
		
		//assertions
		assertEquals(3, res.size());
		assertTrue(res.contains("SAZuXPGUrfbcn5UA"));
		assertTrue(res.contains("4sMM2LxV07bPJzwf"));
		assertTrue(res.contains("fbcn5UAVanZf6UtG"));
		System.out.println("");
	}
	
	/*
	 * Test a large file
	 * Each id has a tag corresponding to the number of times it occurs
	 */
	@Test
	void testMain3() throws Exception {
		System.out.println("Running system test 3:");
		String file = Main.PATH_PREFIX + "test-files/large_cookie_log.csv";
		String date = "2018-12-09"; 
		
		List<String> res = Main.getMostActiveCookies(file, date);
		
		//print the result
		for (String s : res) {
			System.out.println(s);
		}
		
		//assertions
		assertEquals(1, res.size());
		assertTrue(res.contains("id15"));
		System.out.println("");
	}
	
	/*
	 * Test a large file with a duplicate id with max occurrences
	 */
	@Test
	void testMain4() throws Exception {
		System.out.println("Running system test 4:");
		String file = Main.PATH_PREFIX + "test-files/large_cookie_log_duplicate_max.csv";
		String date = "2018-12-09"; 
		
		List<String> res = Main.getMostActiveCookies(file, date);
		
		//print the result
		for (String s : res) {
			System.out.println(s);
		}
		
		//assertions
		assertEquals(2, res.size());
		assertTrue(res.contains("id25"));
		assertTrue(res.contains("id_25_duplicate"));
		System.out.println("");
	}
	
	/*
	 * Test a file with several id's with max occurrences
	 */
	@Test
	void testMain5() throws Exception {
		System.out.println("Running system test 5:");
		String file = Main.PATH_PREFIX + "test-files/large_cookie_log_repeated_max.csv";
		String date = "2018-12-09"; 
		
		List<String> res = Main.getMostActiveCookies(file, date);
		
		//print the result
		for (String s : res) {
			System.out.println(s);
		}
		
		//assertions
		assertEquals(10, res.size());
		System.out.println("");
	}
	
}
