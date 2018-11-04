package me.FJEY.Parser;

public class ParseException extends Exception {
	
	ParseException(String token, int errcode){
		super("Invailed token : " + token +". Error code : " + errcode);
	}
	
	ParseException(String msg){
		super(msg);
	}
	
}
