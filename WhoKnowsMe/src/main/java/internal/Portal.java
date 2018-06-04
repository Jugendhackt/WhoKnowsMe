package internal;

import java.io.*;
import java.net.*;

import javax.swing.text.html.HTMLDocument;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
import javax.swing.text.html.HTMLEditorKit;

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
	
	protected static String getWebsitesTitle(String url) throws IOException {
//		Document html;
//		html = Jsoup.connect(url).get();
//		return html.toString();
		
		URL urlObject = new URL(url);
		URLConnection connection = urlObject.openConnection();
		InputStream is = connection.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		HTMLEditorKit htmlKit = new HTMLEditorKit();

		//Only start from body
		HTMLDocument htmlDoc = (HTMLDocument) htmlKit.createDefaultDocument();
		return (String) htmlDoc.getProperty(HTMLDocument.TitleProperty);
	}
}
