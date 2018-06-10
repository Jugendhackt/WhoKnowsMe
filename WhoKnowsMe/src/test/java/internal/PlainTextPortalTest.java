package internal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PlainTextPortalTest {
	@Test
	public void testhasAccount() {
		PlainTextPortal portal = new PlainTextPortal("https://github.com/USER/","Jugendhackt","GitHub","Page not found");
		Boolean member = false;
		try {
			member = portal.hasAccount();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		assertTrue(member);
	}
	@Test
	public void testhasnoAccount() {
		PlainTextPortal portal = new PlainTextPortal("s", "s", "s","s");
		Boolean member = false;
		try {
			member = portal.hasAccount();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		assertFalse(member);	
	}

}
