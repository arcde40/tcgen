package me.FJEY.Parser;

public class TokenAttribute {
	private String[] attribute = new String[5];
	/* 0 - Type (0 - INT 1 - FLOAT 2 - DOUBLE 3 - STRING 4 - BOOLEAN)
	 * 1 - (B) Is Random
	 * 2 - (S) Min Range
	 * 3 - (S) Max Range
	 * 4 - (S) Fixed Value
	 * 
	 * 
	 */
	public TokenAttribute(TokenBuffer tb) {
		tb.first();
		while(tb.hasNext()) {
			/* Initialize Type */
			if(tb.currentToken().getType() == TokenTypes.TT_INTEGER) attribute[0] = "0";
			if(tb.currentToken().getType() == TokenTypes.TT_FLOAT) attribute[0] = "1";
			if(tb.currentToken().getType() == TokenTypes.TT_DOUBLE) attribute[0] = "2";
			if(tb.currentToken().getType() == TokenTypes.TT_STRING) attribute[0] = "3";
			if(tb.currentToken().getType() == TokenTypes.TT_BOOLEAN) attribute[0] = "4";
			
			/* Initialize Range */
			if(tb.currentToken().getType() == TokenTypes.TT_FIXED) {
				attribute[1] = "0"; 
				attribute[4] = tb.currentTokenValue().substring(2); 
				attribute[2] = "";
				attribute[3] = "";
			}else {
				attribute[1] = "1";
				attribute[4] = "";
			}
			
			/* Initialize Min, Max Range */
			if(tb.currentToken().getType() == TokenTypes.TT_MINRANGE) attribute[2] = tb.currentTokenValue().substring(2);
			if(tb.currentToken().getType() == TokenTypes.TT_MAXRANGE) attribute[3] = tb.currentTokenValue().substring(2);
			
			tb.moveNext();
		}
	}
	
	public String[] getAttribute() {
		return attribute;
	}
}
