package internal;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import internal.Portal;

public class PortalTest {

	@Test
	public void testGetWebsitesTitle() throws Exception {
		String title = Portal.getWebsitesTitle("https://example.com/");
		assertTrue(title.equals("Example Domain"));
	}

	@Test
	public void testEquals() {
		Portal ptp = new PlainTextPortal("https://site/USER","me","Site","not found");
		Portal septp = new SignEscapedPlainTextPortal("https://site/USER","ae","Site","not found", "a","m");

		assertTrue(ptp.equals(septp));
	}
	
}
