package main;
import internal.Portal;

public class Account {
	private Portal portal;
	private String userName;
	
	public Account(Portal p, String userName) {
		this.portal = p;
		this.userName = userName;
	}
}
