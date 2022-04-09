package io;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cookie.Cookie;
import main.Main;

public class LogReaderTest {
	
	/*
	 * Setup method
	 */
	@BeforeEach
	void setUp() {
		
	}
	
	/*
	 * Test that the correct number of entries is read in the correct order
	 */
	@Test
	void LogReaderTest1() throws IOException {
		String file = Main.PATH_PREFIX + "test-files/cookie_log.csv";
		
		List<Cookie> list = LogReader.getCookiesFromFile(file);
		
		//check size
		assertEquals(8, list.size());
		
		//check that some were read in the right order
		//(delegate validating other fields to Cookie)
		assertEquals("AtY0laUfhglK3lC7", list.get(0).getId());
		assertEquals("SAZuXPGUrfbcn5UA", list.get(1).getId());
		assertEquals("5UAVanZf6UtGyKVS", list.get(2).getId());
		assertEquals("4sMM2LxV07bPJzwf", list.get(7).getId());
		
	}
}
