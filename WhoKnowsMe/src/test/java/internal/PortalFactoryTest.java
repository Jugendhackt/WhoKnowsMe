package internal;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class PortalFactoryTest {
	
	public JSONArray createReferenceJSON() {
		JSONArray compare = new JSONArray();
		JSONObject node = new JSONObject();
		node.put("generalUrl", "https://jugendhackt/USER");
		node.put("portalName", "GitHub");
		node.put("successCondition", "Page not found");
		compare.put(node);
		
		return compare;
	}
	
	@Test
	public void testCreateJSON() {
		JSONArray fromFile = PortalFactory.createJSON("test.json");
		assertTrue(fromFile.equals(createReferenceJSON()));
	}
	
	@Test
	public void testCreatePlainTextPortals() {
		PortalFactory.reset();
		PortalFactory.createPlainTextPortals("me", createReferenceJSON());
		
		List<Portal> portals = PortalFactory.createPortals("me");
		
		List<Portal> reference = new ArrayList<Portal>();
		reference.add(new PlainTextPortal("https://jugendhackt/USER","me","GitHub","Page not found"));
		
		assertTrue(portals.equals(reference));
	}

}
