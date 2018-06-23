package internal;

import static org.junit.Assert.assertTrue;
import java.util.*;
import org.junit.*;

import internal.Account;

import org.json.*;

public class AccountTest {

	@Test
	public void testJSONAccountList() {
		List<Account> accs = new ArrayList<Account>();
		accs.add(new Account("example.com", "COM"));
		accs.add(new Account("example.net", "NET"));
		
		JSONArray result = Account.jsonAccountList(accs);
		
		assertTrue(result.toString().equals("[{\"name\":\"COM\",\"url\":\"example.com\"},{\"name\":\"NET\",\"url\":\"example.net\"}]"));
	}
}
