package internal;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public abstract class Portal {
	private String url;
	private String portalName;
	
	public Portal(String url, String portalName) {
		this.url = url;
		this.portalName = portalName;
	}
	
	public abstract boolean hasAccount() throws Exception;
	
	public final String getUrl() {
		return url;
	}
	
	public final String getPortalName() {
		return portalName;
	}
	
	protected static String getWebsitesHead(String url) throws Exception {
		Document html;
		try {
			html = Jsoup.connect(url).get();
		} catch (IOException e) {
			throw new Exception("problem connecting to the webside" + url + e);
		}
		return html.toString();
	}
}
