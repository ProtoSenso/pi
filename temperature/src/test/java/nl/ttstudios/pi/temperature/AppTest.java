package nl.ttstudios.pi.temperature;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import junit.framework.TestSuite;

public class AppTest {

	public AppTest(String testName) {
		
	}

	public static TestSuite suite() {
		return new TestSuite(AppTest.class);
	}

	@Test
	public void testApp() {
		assertTrue(true);
	}
}
