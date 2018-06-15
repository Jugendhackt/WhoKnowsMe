package main;
import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import internal.*;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("AccountService")
public class AccountService {
	/* This is the interface that takes user input and searchs for
	 * accounts that are named similar */

	private AccountService() {} //no instances can be created
	
	@GET
	@Path("findAccounts/{input}")
	public static List<Account> findAccounts(@PathParam("input") String input) {
		List<Portal> allPortals = getAllPortals(input);
		List<Account> allAccounts = new ArrayList<Account>();	//empty!
		
		for(Portal p:allPortals) {
			try {
				if(p.hasAccount()) {
					allAccounts.add(new Account(p,input));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
//		return Account.jsonAccountList(allAccounts);
		return allAccounts;
	}
	
	private static List<Portal> getAllPortals(String accountName) {
		List<Portal> allPortals = new ArrayList<Portal>();
		
		//add here any
		//allPortals.add(new GitHubPortal(accountName)); //this is test-only by now
		
		for(String[] inputSite:PlainTextPortal.PLAIN_TEXT_URLS) {
			allPortals.add(new PlainTextPortal(inputSite[0],accountName, inputSite[1], inputSite[2]));
		}
		
		return allPortals;
	}
}
