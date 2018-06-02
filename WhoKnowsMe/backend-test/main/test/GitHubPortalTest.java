package main.test;
import org.junit.Test;

import internal.GitHubPortal;
import junit.framework.Assert;

public class GitHubPortalTest {
	@Test
	public void testGetUrl() {
		
		GitHubPortal portal = new GitHubPortal ();
		String Url = portal.getUrl("jugendhackt");
		Assert.assertEquals("https://github.com/jugendhackt/",Url);
		
	}
	@Test
	public void testGetPortalName () {
		
		GitHubPortal portal = new GitHubPortal ();
		String portalName = portal.getPortalName();
		Assert.assertEquals("GitHub", portalName);
	}
	@Test
	public void  testHasAccount () {
		GitHubPortal portal = new GitHubPortal ();
		Boolean member = false;
		try {
			member = portal.hasAccount("Wutchilli");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(member);
		
		
		
	}

}
