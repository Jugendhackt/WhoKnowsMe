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
	
	protected static String getWebsitesTitle(String url) throws IOException {
		Document htmlDoc = Jsoup.connect(url).get();
		return htmlDoc.title();
	}

	
	//Equality check
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((portalName == null) ? 0 : portalName.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Portal))
			return false;
		Portal other = (Portal) obj;
		if (portalName == null) {
			if (other.portalName != null)
				return false;
		} else if (!portalName.equals(other.portalName))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
}
