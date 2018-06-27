package main;

import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import internal.Portal;
import internal.PortalFactory;
import internal.Account;

@Path("/AccountService")
public class AccountService {
	/*
	 * This is the interface that takes user input and searchs for accounts that are
	 * named similar
	 */

	@GET
	@Path("serve/{input}")
	@Produces(MediaType.APPLICATION_JSON)
	public String serve(@PathParam("input") String input) {
		String realInput = unescape(input);
		
		PortalFactory factory = new PortalFactory();
		List<Portal> allPortals = factory.loadPortals(realInput);

		return Account.jsonAccountList(findAccounts(allPortals)).toString();
	}

	
	static List<Account> findAccounts(List<Portal> allPortals) {
		List<Account> allAccounts = new ArrayList<Account>(); // empty!

		for (Portal p : allPortals) {
			try {
				if (p.hasAccount()) {
					allAccounts.add(new Account(p.getUrl(), p.getPortalName()));
				}
			} catch (Exception e) {
				//e.printStackTrace();
			}
		}
		return allAccounts;
	}
	
	static String unescape(String in) {
		String out = in.replaceAll("%20", " ");
		return out;
	}
}
