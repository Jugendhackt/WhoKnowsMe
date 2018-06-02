package main;
import java.util.*;
import internal.*;

public class BackendInterface {
	/* This is the interface that takes user input and searchs for
	 * accounts that are named similar */

	private BackendInterface() {} //no instances can be created
	
	public static List<Account> findAccounts(String input) {
		List<Portal> allPortals = getAllPortals();
		List<Account> allAccounts = new ArrayList<Account>();	
		
		for(Portal p:allPortals) {
			if(p.hasAccount(input)) {
				allAccounts.add(new Account(p,input));
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
