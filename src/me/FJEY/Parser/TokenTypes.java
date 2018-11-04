package me.FJEY.Parser;

public enum TokenTypes {
	
	TT_INTEGER("^INT", true),
	TT_FLOAT("^FLOAT", true),
	TT_DOUBLE("^DOUBLE", true),
	TT_STRING("^STRING", true),
	TT_BOOLEAN("^BOOLEAN", true),
	TT_OPENBRACK("\\{", true),
	TT_CLOSEBRACK("\\}", true),
	TT_RANGE("r\\:",true),
	TT_MINRANGE("m\\-\\d+", true),
	TT_MAXRANGE("m\\+\\d+", true),
	TT_FIXED("v\\:\\d+", true),
	TT_WS("^[ \t\r\n]+", false),
    TT_EOF(null, true);

	private String regex;
	
	private boolean output;
	
	
	TokenTypes(String regex, boolean output) {
        this.regex = regex;
        this.output = output;
    }
	
	String getRegex() {
		return this.regex;
	}
	
	boolean getIsOutput() {
		return this.output;
	}
	
	boolean hasRegex() {
		return (regex != null && !regex.isEmpty());
	}

}
