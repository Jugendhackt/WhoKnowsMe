package internal;

import java.io.IOException;

public class PlainTextPortal extends Portal {
	//if this is a substring of the head of the website, condition fails (== no account)
	private String successCondition;
	public static final String PLACE_HOLDER = "USER";

	public PlainTextPortal(String generalUrl, String accountName, String portalName, String successCondition) {
		super(createSpecificUrl(generalUrl,accountName), portalName);
		this.successCondition = successCondition;
	}

	@Override
	public boolean hasAccount() throws Exception {
		String head;
		try {
			head = Portal.getWebsitesTitle(getUrl());
		} catch(IOException ex) {
			throw new Exception("problem connecting to the webside" + getUrl() + ex);
		}
		return !head.contains(successCondition); //means, that there is no profile		
	}
	
	//Just a helper method
	private static String createSpecificUrl(String generalUrl, String accountName) {
		return generalUrl.replaceAll(PLACE_HOLDER, accountName);
	}	
	
	public static final String[][] PLAIN_TEXT_URLS = {
			{"https://github.com/USER/","GitHub","Page not found"},
			{"https://twitter.com/USER/","Twitter","Twitter / ?"},
			{"https://www.instagram.com/USER/","Instagram","Seite nicht gefunden &bull; Instagram"},
			{"https://www.deviantart.com/USER/","Deviantart","Browse  on DeviantArt"},
			{"https://pixabay.com/users/USER/","Pixabay","Error 404"},
			{"https://www.fanfiktion.de/u/USER","Fanfiktion.de","Benutzerprofil nicht gefunden | FanFiktion.de"},
			{"https://www.wattpad.com/user/USER","Wattpad","BenutzerIn nicht gefunden - Wattpad"},
			{"https://USER.slack.com/","Slack","Es ist ein Fehler aufgetreten ... | Slack"},
			{"https://discuss.codecademy.com/u/USER/","Codecademy","Codecademy Discuss"},
			{"https://gitlab.com/","Gitlab","Sign in � GitLab"},
			{"https://www.youtube.com/user/USER","YouTube","YouTube"},
			{"https://www.gutefrage.net/nutzer/USER","Gutefrage","Gutefrage - die gr��te deutschsprachige Frage-Antwort-Plattform"},
			{"https://soundcloud.com/USER","Soundcloud","SoundCloud - Hear the world�s sounds"},
			{"https://disqus.com/by/USER","Disqus","Page not found (404) - Disqus"},
			{"https://USER.slack.com","Slack","Es ist ein Fehler aufgetreten...|Slack"},
			{"https://www.minecraftforum.net/members/USER/","Minecraft Forum","Not found - Minecraft Forum"},//possible not working (Site got a DDoS protection))
			{"https://9gag.com/u/USER","9GAG","9GAG - 404 Nothing here"},
			{"https://USER.tumblr.com/","Tumblr","Not found."},
			{"https://USER.bandcamp.com/","Bandcamp","Signup | Bandcamp"},
			//{"https://community.zeit.de/user/USER","Zeit",""}	title dont change 
			{"https://boards.euw.leagueoflegends.com/de/player/EUW/USER","League of Legendes","League of Legendes"},// only EuWest for now
			{}	
			
	};
}