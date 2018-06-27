package internal;

import java.io.IOException;

public class PlainTextPortal extends Portal {
	//if this is a substring of the head of the website, condition fails (== no account)
	private String successCondition;
	public static final String PLACE_HOLDER = "USER";

	public PlainTextPortal(String generalUrl, String accountName, String portalName, String successCondition) {
		super(createSpecificUrl(generalUrl,accountName), portalName);
		this.successCondition = successCondition;
	}

	@Override
	public boolean hasAccount() throws Exception {
		String head ="";
		try {
			head = Portal.getWebsitesTitle(getUrl());
		} catch(IOException ex) {
			throw new Exception("problem connecting to the website: " + getUrl() + ex);
		}
		return !head.contains(successCondition); //means, that there is no profile		
	}
	
	//TODO: better escaping
	private static String createSpecificUrl(String generalUrl, String accountName) {
		String escapedAccountName = accountName.replaceAll(" ", "+");
		return generalUrl.replaceAll(PLACE_HOLDER, escapedAccountName);
	}	
}