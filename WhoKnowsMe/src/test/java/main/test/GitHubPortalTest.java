package main.test;
import org.junit.Test;

import internal.GitHubPortal;
import junit.framework.Assert;

public class GitHubPortalTest {
	@Test
	public void testGetUrl() {
		//create a portal and get its url
		GitHubPortal portal = new GitHubPortal("jugendhackt");
		String url = portal.getUrl();
		
		//test, whether the url is right
		Assert.assertEquals("https://github.com/jugendhackt/",url);
		
	}
	@Test
	public void testGetPortalName () {
		GitHubPortal portal = new GitHubPortal(""); //empty, we need no username
		String portalName = portal.getPortalName();
		Assert.assertEquals("GitHub", portalName);
	}
	
	@Test
	public void  testHasAccount () {
		GitHubPortal portal = new GitHubPortal("Wutchilli");
		Boolean member = false;
		try {
			member = portal.hasAccount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(member);
		
		//evtl: in neuen Test auslagern (für error testen)
		//need a second, portal have to know username, in cause of specific url (including username)
		GitHubPortal portal2 = new GitHubPortal("000wasd");
		try {
			member = portal2.hasAccount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertFalse(member);
	}

}
