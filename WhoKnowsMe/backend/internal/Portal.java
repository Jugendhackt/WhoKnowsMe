package internal;

public abstract class Portal {	
	private Portal() {};
	
	public abstract Portal getInstance();
	
	public abstract boolean hasAccount(String accountName);
	
	public abstract String getUrl();
}
