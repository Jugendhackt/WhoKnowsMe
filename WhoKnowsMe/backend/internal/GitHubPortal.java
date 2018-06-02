package internal;

public class GitHubPortal extends Portal {

	@Override
	public Portal getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasAccount(String accountName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getUrl(String accountName) {
		// TODO Auto-generated method stub
		return "https://github.com/" + accountName + "/";
	}

	@Override
	public String getPortalName() {
		
		return "GitHub";
	}

}
