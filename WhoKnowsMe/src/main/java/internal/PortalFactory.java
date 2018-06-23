package internal;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class PortalFactory {
	private static List<Portal> allPortals = new ArrayList<Portal>();
	private static final String PLAIN_TEXT_URLS_JSON_FILE = "plainUrls.json";
	
	
	public static List<Portal> createPortals(String accountName) {
		if(allPortals.isEmpty()) {
			//add here any
			createPlainTextPortals(accountName, createJSON(PLAIN_TEXT_URLS_JSON_FILE));			
		}
			
		return allPortals;
	}
	
	static JSONArray createJSON(String fileName) { //filename is in folder resources
		//TODO
		return null;
	}
	
	static void createPlainTextPortals(String accountName, JSONArray json) {
		for(Object obj:json) {
			JSONObject jsObj = (JSONObject) obj; //does this work?
			allPortals.add(new PlainTextPortal(jsObj.getString("generalUrl"),accountName, jsObj.getString("portalName"), jsObj.getString("successCondition")));
		}
	}
	
	static void reset() {
		allPortals = new ArrayList<Portal>();
	}
}
