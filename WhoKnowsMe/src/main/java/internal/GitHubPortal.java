package internal;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GitHubPortal extends Portal {
	Portal singlePortal = new GitHubPortal();

	@Override
	public Portal getInstance() {
		return singlePortal;
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
=======
package internal;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GitHubPortal extends Portal {

	public GitHubPortal() {
		super("https://github.com/", "GitHub");
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
