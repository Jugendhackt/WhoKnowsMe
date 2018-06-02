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
		List<Portal> allPortals = getAllPortals();
		List<Account> allAccounts = new ArrayList<Account>();	
		
		for(Portal p:allPortals) {
			try {
				if(p.hasAccount(input)) {
					allAccounts.add(new Account(p,input));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return allAccounts;
	}
	
	private static List<Portal> getAllPortals() {
		List<Portal> allPortals = new ArrayList<Portal>();
		
		//add here any
		
		return allPortals;
	}
}
