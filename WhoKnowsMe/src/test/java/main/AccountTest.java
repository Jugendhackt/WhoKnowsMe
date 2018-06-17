package main;

import static org.junit.Assert.assertTrue;
import java.util.*;
import org.junit.*;
import org.json.*;
import internal.*;

public class AccountTest {

	@Test
	public void testJSONAccountList() {
		List<Account> accs = new ArrayList<Account>();
		accs.add(new Account(new TestPortal("example.com", "COM"), "test"));
		accs.add(new Account(new TestPortal("example.net", "NET"), "test"));
		
		JSONArray result = Account.jsonAccountList(accs);
		
		assertTrue(result.toString().equals("[{\"name\":\"COM\",\"url\":\"example.com\"},{\"name\":\"NET\",\"url\":\"example.net\"}]"));
	}
}
