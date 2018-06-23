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
}
