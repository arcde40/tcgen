package me.FJEY.AST;

public class IntegerLiteralNode extends LiteralNode{
	
	int value;
	
	public IntegerLiteralNode(int value) {
		super("Integer", value);
		this.value = value;
		
	}
}
