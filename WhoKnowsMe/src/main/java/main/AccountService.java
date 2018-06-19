package main;
import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;

import internal.*;

//@Produces(MediaType.APPLICATION_JSON)
@Path("/AccountService")
public class AccountService {
	/* This is the interface that takes user input and searchs for
	 * accounts that are named similar */

	private AccountService() {} //no instances can be created
	
	@GET
	@Produces("text/plain")
	public static String testAccess() {
		return "Hello World!";
	}
	
	@GET
	@Path("findAccounts/{input}")
	@Produces(MediaType.APPLICATION_JSON)
//	@Produces("application/json")
	public static JSONArray findAccounts(@PathParam("input") String input) {
		List<Portal> allPortals = getAllPortals(input);
		List<Account> allAccounts = new ArrayList<Account>();	//empty!
		
		for(Portal p:allPortals) {
			try {
				if(p.hasAccount()) {
					allAccounts.add(new Account(p.getUrl(),p.getPortalName()));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return Account.jsonAccountList(allAccounts);
	}
	
	private static List<Portal> getAllPortals(String accountName) {
		List<Portal> allPortals = new ArrayList<Portal>();
		
		//add here any
		for(String[] inputSite:PlainTextPortal.PLAIN_TEXT_URLS) {
			allPortals.add(new PlainTextPortal(inputSite[0],accountName, inputSite[1], inputSite[2]));
		}
		
		return allPortals;
	}
}
