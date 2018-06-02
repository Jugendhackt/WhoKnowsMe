package internal;
import org.jsoup.Jsoup;

public class GitHubPortal extends Portal {

	@Override
	public Portal getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasAccount(String accountName) {
		String url = "https://github.com/" + accountName + "/";
		String html = Jsoup.connect(url).get;
		boolean member;
		if(html.contains("Page not found")) {	
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
