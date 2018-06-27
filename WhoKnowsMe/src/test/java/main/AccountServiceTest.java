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
	
	@Test
	public void testFindAccountsWithEscaped() {
		List<Portal> portals = new ArrayList<Portal>();
		portals.add(new SignEscapedPlainTextPortal("https://github.com/USER", "ms", "GitHub2", "Page not found", "s", "e"));
		portals.add(new PlainTextPortal("https://github.com/USER","me not","GitHub","Page not found"));
		portals.add(new PlainTextPortal("https://example.com/","me not","Example Domain", "Example Domain"));
		
		
		List<Account> accounts = AccountService.findAccounts(portals);
		
		List<Account> referenceAccounts = new ArrayList<Account>();
		referenceAccounts.add(new Account("https://github.com/me","GitHub2"));
		
		assertTrue(accounts.equals(referenceAccounts));
	}
}
