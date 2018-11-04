package me.FJEY.Parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexer {
	private String line;
	private List<Token> tokenList = new ArrayList<>();
	private List<TokenTypePattern> tP = new ArrayList<>();
	
	public Lexer(String line) {
		this.line = line;
		for(TokenTypes type : TokenTypes.values()) {
			if(type.hasRegex()) {
				tP.add(new TokenTypePattern(type));
			}
		}
	}
	
	public TokenBuffer tokenize() throws Exception {
		while(matchToken() && !eof()) {
		}
		if(!eof()) {
			throw new Exception("Lexademical analzye failed. No token starts with : " + line);
		}
		tokenList.add(new Token(TokenTypes.TT_EOF , null));
		return new TokenBuffer(tokenList);
	}
	
	private boolean matchToken() {
		boolean match = false;
		Iterator<TokenTypePattern> it = tP.iterator();
		while(!match && it.hasNext()) {
			TokenTypePattern ttPattern = it.next();
			Matcher matcher = ttPattern.pattern.matcher(line);
			if(matcher.find()) {
				if(ttPattern.type.getIsOutput()) {
					tokenList.add(new Token(ttPattern.type, matcher.group()));
				}
				match = true;
				line = line.substring(matcher.end());
			}
		}
		return match;
	}
	
	private boolean eof() {
		return line.length() == 0;
	}
	
	
	private class TokenTypePattern {

        private TokenTypes type;
        private Pattern pattern;

        public TokenTypePattern(TokenTypes type) {
            this.type = type;
            this.pattern = Pattern.compile(type.getRegex());

        }

    }
}
