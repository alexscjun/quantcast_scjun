package cookie;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CookieTest {
	
	Cookie c;
	
	/*
	 * Setup method
	 */
	@BeforeEach
	void setUp() {
		c = null;
	}
	
	/*
	 * Test that cookies throw errors with invalid input parameters
	 */
	@Test
	void testCookie1() throws Exception {
		assertThrows(Exception.class, () -> new Cookie("")); //empty
		assertThrows(Exception.class, () -> new Cookie("SAZuXPGUrfbcn5UA2018-12-09T10:13:00+00:00")); //no comma
	}
	
	/*
	 * Test several valid cookies
	 */
	@Test
	void testCookie2() throws Exception {
		assertDoesNotThrow(() -> new Cookie("AtY0laUfhglK3lC7,2018-12-09T14:19:00+00:00")); //basic valid input
		assertDoesNotThrow(() -> new Cookie("AtY0laUfhglK3lC7,2018-01-01T14:19:00+00:00")); //very low input values
		assertDoesNotThrow(() -> new Cookie("id,2018-01-01T14:19:00+00:00")); //very short id
		
		//check fields
		c = new Cookie("AtY0laUfhglK3lC7,2018-12-09T14:19:00+00:00");
		assertEquals("AtY0laUfhglK3lC7", c.getId());
		assertEquals("2018-12-09", c.getDate());
		assertEquals("14:19:00+00:00", c.getTime());
	}
}
