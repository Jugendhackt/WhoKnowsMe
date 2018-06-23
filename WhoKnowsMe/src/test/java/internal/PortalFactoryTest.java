package internal;

import static org.junit.Assert.assertTrue;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class PortalFactoryTest {
	
	@Test
	public void testCreateJSON() {
		JSONArray fromFile = PortalFactory.createJSON("test.json");
		
		JSONArray compare = new JSONArray();
		JSONObject node = new JSONObject();
		node.put("generalUrl", "https://jugendhackt/USER");
		node.put("portalName", "GitHub");
		node.put("successCondition", "Page not found");
		compare.put(node);
		
		assertTrue(fromFile.equals(compare));
	}

}
