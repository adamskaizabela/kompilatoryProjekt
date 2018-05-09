package boot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import demo.DemoParser;
import demo.DemoParserConstants;
import demo.Token;

public class Tokens {

	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream is = new FileInputStream(new File(args[0]));

		String[] tokenImage = DemoParserConstants.tokenImage;
		for (Token token : tokenize(new DemoParser(is))) {
			String id = token.beginLine + ":" + tokenImage[token.kind];
			System.out.println(id + " => " + token.image);
		}
	}

	public static List<Token> tokenize(DemoParser template)
			throws FileNotFoundException {
		List<Token> tokens = new ArrayList<>();

		Token token = template.getNextToken();
		while (token.kind != DemoParserConstants.EOF) {
			tokens.add(token);
			token = template.getNextToken();
		}
		return tokens;
	}
}
