package internal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class PortalFactory {
	private static List<Portal> allPortals = new ArrayList<Portal>();
	private static final String PLAIN_TEXT_URLS_JSON_FILE = "plainUrls.json";

	public static List<Portal> loadPortals(String accountName) {
		if (allPortals.isEmpty()) {
			// add here any
			createPlainTextPortals(accountName, createJSON(PLAIN_TEXT_URLS_JSON_FILE));
		}

		return allPortals;
	}

	@SuppressWarnings("resource")
	static JSONArray createJSON(String fileName) { // filename is in folder resources
		InputStream jsonStream = PortalFactory.class.getResourceAsStream("/" + fileName);
		String jsonText = new Scanner(jsonStream, "UTF-8").useDelimiter("\\A").next();
		return new JSONArray(jsonText);
	}

	static void createPlainTextPortals(String accountName, JSONArray json) {
		for (Object obj : json) {
			JSONObject jsObj = (JSONObject) obj; // does this work?
			allPortals.add(new PlainTextPortal(jsObj.getString("generalUrl"), accountName,
					jsObj.getString("portalName"), jsObj.getString("successCondition")));
		}
	}

	public static void reset() {
		allPortals = new ArrayList<Portal>(); // so loadPortals will load any again
	}
}
