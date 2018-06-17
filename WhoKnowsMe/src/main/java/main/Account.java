package main;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import internal.Portal;

public class Account {
	private Portal portal;
	private String userName;
	
	public Account(Portal p, String userName) {
		this.portal = p;
		this.userName = userName;
	}
	
	public static JSONArray jsonAccountList(List<Account> accList) {
		JSONArray jsArr = new JSONArray();
		
		for(Account acc:accList) {
			JSONObject jsObj = new JSONObject();
			jsObj.put("url", acc.portal.getUrl());
			jsObj.put("name", acc.portal.getPortalName());
			
			jsArr.put(jsObj);
		}
		
		return jsArr;
	}
}
