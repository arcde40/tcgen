package me.FJEY.Parser;

public class Token {

	    private TokenTypes type;

	    private String value;
	    
	    public Token(TokenTypes type, String value) {
	        this.type = type;
	        this.value = value;
	    }
	    
	    /** 
	     * Get type of TOKEN ( Ex. TT_INTEGER )
	     * @param None
	     * @return Type of TOKEN
	     */
	    public TokenTypes getType() {
	        return type;
	    }
	    
	    /**
	     * Get type name of TOKEN (Ex. TT_INTEGER in String)
	     * @return Type name of TOKEN
	     */
	    public String getTypeString() {
	    	return type.name();
	    }

	    /**
	     * Get TOKEN's content (Ex. INT)
	     * @return TOKEN's content
	     */
	    public String getValue() {
	        return value;
	    }
}
