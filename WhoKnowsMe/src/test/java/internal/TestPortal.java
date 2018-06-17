package internal;

public class TestPortal extends Portal {

	public TestPortal(String url, String portalName) {
		super(url, portalName);
	}

	@Override
	public boolean hasAccount() throws Exception {
		return true;
	}

}
