package internal;

public class SignEscapedPlainTextPortal extends PlainTextPortal {

	public SignEscapedPlainTextPortal(String generalUrl, String accountName, String portalName, String successCondition, String replace, String replaceby) {
		super(generalUrl, escape(accountName, replace, replaceby), portalName, successCondition);
	}
	
	protected static  String escape(String unescaped, String replace, String replaceby) {
		return unescaped.replaceAll(replace,  replaceby);
	}
}
