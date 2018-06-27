package internal;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SignEscapedPlainTextPortalTest {
	@Test
	public void testEscape() {
		String unescaped = "a me";
		String escaped = SignEscapedPlainTextPortal.escape(unescaped, " ", "-");
		
		assertTrue(escaped.equals("a-me"));
	}
}
