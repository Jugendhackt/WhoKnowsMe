package main;
import internal.Portal;

public class Account {
	private String url;
	private String portalName;
	
	public Account(Portal p, String userName) {
		this.url = p.getUrl(userName);
		this.portalName = p.getPortalName();
	}
}
