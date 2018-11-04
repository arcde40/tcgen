package me.FJEY.Parser;

public class LexerTest {

    public void noTokens() throws Exception {

        Lexer lexer = new Lexer("INT r:m-10 m+10");

        TokenBuffer tokenBuffer = lexer.tokenize();
        while(tokenBuffer.hasNext()) {
        	System.out.println(tokenBuffer.currentToken().getValue()+" "+tokenBuffer.currentTokenByName()+" " +equals(eofToken()));

            //System.out.println(tokenBuffer.hasNext()+" "+ equals(false));
        	tokenBuffer.moveNext();
        }
        TokenAttribute ta = new TokenAttribute(tokenBuffer);
        
        for(String s : ta.getAttribute()) {
        	System.out.println(s);
        }
        
        Parser p = new Parser(ta.getAttribute());
        System.out.println("Val: "+p.getFinalValue());

    }
    
    public static void main(String[] args) {
		try {
			LexerTest lx = new LexerTest();
			lx.noTokens();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    /*public void twoTokens() throws Exception {

        Lexer lexer = new Lexer("INT");

        TokenBuffer tokenBuffer = lexer.tokenize();

        assertThat(tokenBuffer.returnCurrNGoNext(), 

                    equalTo(token(TokenTypes.TT_INTEGER, "allow")));

        assertThat(tokenBuffer.returnCurrNGoNext(), 

                    equalTo(token(TokenTypes.TT_IPRANGE, "1.2.3.4")));

        assertThat(tokenBuffer.nextTokenAndMoveNext(), equalTo(eofToken()));

        assertThat(tokenBuffer.hasNext(), equalTo(false));

        assertThat(tokenBuffer.hasCurrent(), equalTo(false));

    }*/

    /*public void invalidToken() throws Exception {

        Lexer lexer = new Lexer("allow 1.2.3.4 noToken");

        try {

            lexer.tokenize();

            fail();

        } catch(Exception ex) {

        }

    }*/


   /* public void invalidToken2() throws Exception {

        Lexer lexer = new Lexer("allow 1.2.3.4/");

        try {

            lexer.tokenize();

            fail();

        } catch(Exception ex) {

        }

    }*/



    private static Token token(TokenTypes type, String value) {

        return new Token(type, value);

    }



    private static Token eofToken() {

        return new Token(TokenTypes.TT_EOF, null);

    }
}
