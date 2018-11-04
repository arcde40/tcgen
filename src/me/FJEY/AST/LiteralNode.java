package me.FJEY.AST;

public class LiteralNode extends Node{
	
	String type;
	Object value;
	
	public LiteralNode() {
		
	}
	
	public LiteralNode(String type, Object value) {
		this.type = type;
		this.value = value;
	}
	
	public Object getValue() {
		return value;
	}
	
	public String getType() {
		return type;
	}
	
}
