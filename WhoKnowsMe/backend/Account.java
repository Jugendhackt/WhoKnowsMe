import internal.Portal;

public class Account {
	private String url;
	private String portalName;
	
	public Account(Portal p) {
		this.url = p.getUrl();
		this.portalName = p.getName();
	}
}
