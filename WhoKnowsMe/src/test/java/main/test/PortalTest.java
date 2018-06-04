package main.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import internal.Portal;

public class PortalTest {
	
@Test
public void getWebsideTitleTest() throws Exception {
	String title = Portal.getWebsitesTitle("https://example.com/");
			 assertTrue(title.equals("Examplee Domain"));
			 System.out.println(title);
	
}

	

}
