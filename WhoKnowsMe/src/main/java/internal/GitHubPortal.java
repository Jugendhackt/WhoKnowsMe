package internal;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GitHubPortal extends Portal {

	public GitHubPortal(String accountName) {
		super("https://github.com/"+accountName, "GitHub");
	}

	@Override
	public boolean hasAccount() throws Exception {
		Document html;
		try {
			html = Jsoup.connect(getUrl()).get();
		} catch (IOException e) {
			throw new Exception("problem connecting to the webside" + getUrl() + e);
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
}
