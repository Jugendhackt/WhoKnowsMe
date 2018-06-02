package internal;

public abstract class Portal {	
	public abstract Portal getInstance();
	
	public abstract boolean hasAccount(String accountName) throws Exception;
	
	public abstract String getUrl(String accountName);
	
	public abstract String getPortalName();
}
