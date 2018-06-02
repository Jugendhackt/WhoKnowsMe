package internal;

public abstract class Portal {
	private String url;
	private String portalName;
	
	public Portal(String url, String portalName) {
		this.url = url;
		this.portalName = portalName;
	}
	
	public abstract boolean hasAccount(String accountName) throws Exception;
	
	public abstract String getUrl(String accountName);
	
	public abstract String getPortalName();
}
