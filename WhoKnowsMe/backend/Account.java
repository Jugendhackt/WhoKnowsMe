import internal.Portal;

public class Account {
	private String url;
	
	public Account(Portal p) {
		this.url = p.getUrl();
	}
}
