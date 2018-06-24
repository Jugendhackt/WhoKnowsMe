package main;

import static org.junit.Assert.assertTrue;

import java.util.*;

import org.junit.Test;

import internal.*;

public class AccountServiceTest {

	@Test
	public void testFindAccounts() {
		List<Portal> portals = new ArrayList<Portal>();
		portals.add(new PlainTextPortal("https://github.com/USER","me","GitHub","Page not found"));
		portals.add(new PlainTextPortal("https://example.com/","nouser","Example Domain", "Example Domain"));
		
		List<Account> accounts = AccountService.findAccounts(portals);
		
		List<Account> referenceAccounts = new ArrayList<Account>();
		referenceAccounts.add(new Account("https://github.com/me","GitHub"));
		
		assertTrue(accounts.equals(referenceAccounts));
	}
}
