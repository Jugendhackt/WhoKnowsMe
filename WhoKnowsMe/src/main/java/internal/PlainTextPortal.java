package internal;

import java.io.IOException;

public class PlainTextPortal extends Portal {
	//if this is a substring of the head of the website, condition fails (== no account)
	private String successCondition;

	public PlainTextPortal(String generalUrl, String accountName, String portalName, String successCondition) {
		super(createSpecificUrl(generalUrl,accountName), portalName);
		this.successCondition = successCondition;
	}

	@Override
	public boolean hasAccount() throws Exception {
		String head;
		try {
			head = Portal.getWebsitesHead(getUrl());
		} catch(IOException ex) {
			throw new Exception("problem connecting to the webside" + getUrl() + ex);
		}
		//TODO: TEST THIS!!!!
		return head.contains(successCondition); //means, that there is no profile		
	}
	
	public static final String[][] URLS = {
			{"https://github.com/USER/","GitHub","Page not found"}
	};
	
	//Just a helper method
	private static String createSpecificUrl(String generalUrl, String accountName) {
		return generalUrl.replaceAll("USER", accountName);
	}
	
	public static final String[][] PLAIN_TEXT_URLS = {
			{"https://github.com/USER/","GitHub","Page not found"}
	};
}