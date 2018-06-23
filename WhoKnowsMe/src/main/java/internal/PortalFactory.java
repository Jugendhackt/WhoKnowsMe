package internal;

import java.util.ArrayList;
import java.util.List;

public class PortalFactory {
	public static List<Portal> createPortals(String accountName) {
		List<Portal> allPortals = new ArrayList<Portal>();
		
		//add here any
		for(String[] inputSite:PlainTextPortal.PLAIN_TEXT_URLS) {
			allPortals.add(new PlainTextPortal(inputSite[0],accountName, inputSite[1], inputSite[2]));
		}
		
		return allPortals;
	}
}
