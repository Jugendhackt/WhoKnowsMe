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

}
