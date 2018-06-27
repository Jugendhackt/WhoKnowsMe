package internal;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class PortalFactoryTest {
	
	public JSONArray createReferencePlainTextPortalJSON() {
		JSONArray compare = new JSONArray();
		JSONObject node = new JSONObject();
		node.put("generalUrl", "https://github.com/USER");
		node.put("portalName", "GitHub");
		node.put("successCondition", "Page not found");
		compare.put(node);
		
		return compare;
	}

	private JSONArray createReferenceEscapedTextPortalJSON() {
		JSONArray compare = new JSONArray();
		JSONObject node = new JSONObject();
		node.put("generalUrl", "https://gitlab.com/USER");
		node.put("portalName", "GitLab");
		node.put("successCondition", "Sign in");
		node.put("escape", " ");
		node.put("with", "-");
		compare.put(node);
		
		return compare;
	}

	
	@Test
	public void testCreateJSON() {
		JSONArray fromFile = PortalFactory.createJSON("test.json");
		assertTrue(fromFile.toString().equals(createReferencePlainTextPortalJSON().toString()));
	}
	
	@Test
	public void testCreatePlainTextPortals() {
		PortalFactory pf = new PortalFactory();
		pf.createEscapedPlainTextPortals("me", createReferenceEscapedTextPortalJSON());
		
		List<Portal> portals = pf.loadPortals("me");
		
		List<Portal> reference = new ArrayList<Portal>();
		reference.add(new SignEscapedPlainTextPortal("https://gitlab.com/USER","me","GitLab","Sign in"," ","-"));
		
		assertTrue(portals.equals(reference));
	}
	
	@Test
	public void testCreateEscapedTextPortalsWithoutEscaping() {
		PortalFactory pf = new PortalFactory();
		pf.createEscapedPlainTextPortals("me", createReferenceEscapedTextPortalJSON());
		
		List<Portal> portals = pf.loadPortals("me");
		
		List<Portal> reference = new ArrayList<Portal>();
		reference.add(new PlainTextPortal("https://gitlab.com/USER","me","GitLab","Sign in"));
		
		assertTrue(portals.equals(reference));
	}
}
