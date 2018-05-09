package demo;

import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.Iterator;

import junit.framework.Assert;

import org.junit.Test;

public class ParserU {

	@Test
	public void parse() throws ParseException, FileNotFoundException{
		DemoParser template = new DemoParser(new StringReader("JavaCC Demo"));
		
		Iterator<String> iter = template.parseFile().iterator();
		Assert.assertEquals("JavaCC", iter.next());
		Assert.assertEquals("Demo", iter.next());
		Assert.assertFalse(iter.hasNext());
	}
}
