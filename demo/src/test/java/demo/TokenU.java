package demo;

import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import boot.Tokens;

public class TokenU {

	@Test
	public void tokenize() {
		Iterator<Token> iter = tokenize("JavaCC Demo").iterator();

		Assert.assertEquals("JavaCC", iter.next().image);
		Assert.assertEquals("Demo", iter.next().image);
		Assert.assertFalse(iter.hasNext());
	}
	
	@Test(expected=TokenMgrError.class)
	public void tokenizeError() {
		tokenize(" * ");
	} 
	
	public static List<Token> tokenize(String raw) {
		try {
			return Tokens.tokenize(new DemoParser(new StringReader(raw)));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}


}
