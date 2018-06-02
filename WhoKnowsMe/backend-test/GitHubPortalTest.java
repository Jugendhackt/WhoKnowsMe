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
		Boolean member = portal.hasAccount("Wutchilli");
		Assert.assertTrue(member);
		
		
		
	}

}
