package internal;

public abstract class Portal {	
	public abstract Portal getInstance();
	
	public abstract boolean hasAccount(String accountName);
	
	public abstract String getUrl(String accountName);
	
	public abstract String getPortalName();
}
