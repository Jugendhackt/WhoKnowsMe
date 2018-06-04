package main.test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import internal.GitHubPortal;
//import junit.framework.Assert;

public class GitHubPortalTest {

	@Test
	public void testUnitTest() {
		System.out.println("testing testUnitTest");
		assertTrue(true);
	}
	
	@Test
	public void testGetUrl() {
		System.out.println("testing getUrl");
		
		//create a portal and get its url
		GitHubPortal portal = new GitHubPortal("jugendhackt");
		String url = portal.getUrl();
		
		//test, whether the url is right
		//Assert.assertEquals("https://github.com/jugendhackt/",url);
		assertTrue(url.equals("https://github.com/jugendhackt/") || url.equals("https://github.com/jugendhackt"));
	}
	
	@Test
	public void testGetPortalName() {
		System.out.println("testing getPortalName");
		
		GitHubPortal portal = new GitHubPortal(""); //empty, we need no username
		String portalName = portal.getPortalName();
		//Assert.assertEquals("GitHub", portalName);
		assertTrue(portalName.equals("GitHub"));
	}
	
	@Test
	public void  testHasAccount() {
		System.out.println("testing has account");
		
		GitHubPortal portal = new GitHubPortal("Wutchilli");
		Boolean member = false;
		try {
			member = portal.hasAccount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(member);
	}
	
	@Test
	public void testHasNoAccount() {
		System.out.println("testing has no account");
		
		GitHubPortal portal = new GitHubPortal("000wasd");
		boolean member = false;
		try {
			member = portal.hasAccount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertFalse(member);
	}
	

}
