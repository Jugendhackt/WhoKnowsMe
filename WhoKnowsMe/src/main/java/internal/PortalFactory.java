package internal;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class PortalFactory {
	private List<Portal> allPortals = new ArrayList<Portal>();
	private static final String PLAIN_TEXT_URLS_JSON_FILE = "plainUrls.json";
	private static final String ESCAPED_TEXT_URLS_JSON_FILE = "escapedUrls.json";

	public List<Portal> loadPortals(String accountName) {
		if (allPortals.isEmpty()) {
			// add here any
			createPlainTextPortals(accountName, createJSON(PLAIN_TEXT_URLS_JSON_FILE));
			createEscapedPlainTextPortals(accountName, createJSON(ESCAPED_TEXT_URLS_JSON_FILE));
		}

		return allPortals;
	}

	@SuppressWarnings("resource")
	static JSONArray createJSON(String fileName) { // filename is in folder resources
		InputStream jsonStream = PortalFactory.class.getResourceAsStream("/" + fileName);
		String jsonText = new Scanner(jsonStream, "UTF-8").useDelimiter("\\A").next();
		return new JSONArray(jsonText);
	}

	void createPlainTextPortals(String accountName, JSONArray json) {
		for (Object obj : json) {
			JSONObject jsObj = (JSONObject) obj; // does this work?
			allPortals.add(new PlainTextPortal(jsObj.getString("generalUrl"), accountName,
					jsObj.getString("portalName"), jsObj.getString("successCondition")));
		}
	}
	
	void createEscapedPlainTextPortals(String accountName, JSONArray json) {
		for(Object obj : json) {
			JSONObject jsObj = (JSONObject) obj;
			allPortals.add(new SignEscapedPlainTextPortal(jsObj.getString("generalUrl"), accountName, jsObj.getString("portalName"), jsObj.getString("successCondition"),
					jsObj.getString("escape"), jsObj.getString("with")));
		}
	}
}
