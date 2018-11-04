package me.FJEY.AST;

public class SingleOpNode extends Node{
	String op;
	Node val;
	public SingleOpNode(Node val, String op){
		super("SingleOpNode",null);
		this.val = val;
		this.op = op;
	}
	
	public Object getValue() {
		
		switch(op) {
		case "++": return ((int)val.getValue())+1;
		case "--": return ((int)val.getValue())-1;
		}
		return 0;
	}
}
