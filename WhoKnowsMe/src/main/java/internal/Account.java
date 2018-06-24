package internal;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Account {
	private String profileURL;
	private String portalName;
	
	public Account(String url, String portalName) {
		this.profileURL = url;
		this.portalName = portalName;
	}
	
	public static JSONArray jsonAccountList(List<Account> accList) {
		JSONArray jsArr = new JSONArray();
		
		for(Account acc:accList) {
			JSONObject jsObj = new JSONObject();
			jsObj.put("url", acc.profileURL);
			jsObj.put("name", acc.portalName);
			
			jsArr.put(jsObj);
		}
		
		return jsArr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((portalName == null) ? 0 : portalName.hashCode());
		result = prime * result + ((profileURL == null) ? 0 : profileURL.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Account))
			return false;
		Account other = (Account) obj;
		if (portalName == null) {
			if (other.portalName != null)
				return false;
		} else if (!portalName.equals(other.portalName))
			return false;
		if (profileURL == null) {
			if (other.profileURL != null)
				return false;
		} else if (!profileURL.equals(other.profileURL))
			return false;
		return true;
	}
}
