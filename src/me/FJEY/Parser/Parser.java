package me.FJEY.Parser;

import java.util.Random;

import me.FJEY.ParsedBlock.ParseBlockMain;

public class Parser {
	
	private String val;
	private Random r = new Random();
	
	public Parser(String[] at) throws ParseException {
		checkGrammar(at);
		if(at[0] == "0") {
			if(at[1] == "1") {
				if(at[2] != "") {
					if(at[3] != "") {
						val = String.valueOf(r.nextInt(toInt(at[3])-toInt(at[2])+1) + toInt(at[2]));
					}else {
						val = String.valueOf(r.nextInt(Integer.MAX_VALUE- toInt(at[2])) + toInt(at[2]));
					}
				}
				else{
					if(at[3] != "") {
						val = String.valueOf(r.nextInt(toInt(at[3]) + 1));
					}else {
						val = String.valueOf(r.nextInt());
					}
				}
			}else {
				if(at[4] != "") {
					val = at[4];
				}else {
					throw new ParseException("Fixed Token Declared, but nothing given.");
				}
			}
		}
	}
	
	
	public static void checkGrammar(String[] at) throws ParseException{
		if(at[1].equals("1")) {
			if(!at[4].equals("")) {
				throw new ParseException("Fixed value and Random value cannot be declared at the same time!");
			}
		}
	}
	
	
	
	private ParseBlockMain getParsed() {
		return null;
	}
	
	public String getFinalValue() throws Exception {
		if(val.isEmpty()) {
			throw new Exception("Parsing not finished!");
		}
		return val;
	}
	
	private int toInt(String s) {
		return Integer.parseInt(s);
	}
	
}
