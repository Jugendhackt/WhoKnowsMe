package internal;

import java.io.*;
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
	
	public static String getWebsitesTitle(String url) throws IOException {
		Document htmlDoc = Jsoup.connect(url).get();
		return htmlDoc.title();
	}
}
