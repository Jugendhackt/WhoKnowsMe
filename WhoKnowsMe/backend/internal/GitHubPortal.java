package internal;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GitHubPortal extends Portal {

	@Override
	public Portal getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasAccount(String accountName) throws Exception {
		String url = "https://github.com/" + accountName + "/";
		Document html;
		try {
			html = Jsoup.connect(url).get();
		} catch (IOException e) {
			throw new Exception("problem connecting to the webside" + url + e);
		}
		String htmlString = html.toString();
		boolean member;
		if(htmlString.contains("Page not found")) {	
			member=false;
		}
		else
		{
			member=true;
		}
				
		return member;
	}

	@Override
	public String getUrl(String accountName) {
		return "https://github.com/" + accountName + "/";
	}

	@Override
	public String getPortalName() {
		
		return "GitHub";
	}

}
