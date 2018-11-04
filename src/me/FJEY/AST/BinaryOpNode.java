package me.FJEY.AST;

public class BinaryOpNode extends Node{
	
	Node left,right;
	String op;
	
	public BinaryOpNode(Node left, Node right, String op) {
		super("BinaryOpNode", null);
		this.left = left;
		this.right = right;
		this.op = op;
	}
	
	@Override
	public Object getValue(){
		if(op.equals("+")) {
			if(left.getValue() instanceof String && right.getValue() instanceof String) return  (String)left.getValue() + (String)right.getValue();
			else if(left.getValue() instanceof Integer && right.getValue() instanceof Integer) return (Integer)left.getValue() + (Integer)right.getValue();
		}
		if(op.equals("-")) {
			if(left.getValue() instanceof Integer && right.getValue() instanceof Integer) return (Integer)left.getValue() - (Integer)right.getValue();
		}
		if(op.equals("*")) {
			if(left.getValue() instanceof Integer && right.getValue() instanceof Integer) return (Integer)left.getValue() * (Integer)right.getValue();
		}
		if(op.equals("/")) {
			if(left.getValue() instanceof Integer && right.getValue() instanceof Integer) return (Integer)left.getValue() / (Integer)right.getValue();
		}
		if(op.equals("%")) {
			if(left.getValue() instanceof Integer && right.getValue() instanceof Integer) return (Integer)left.getValue() % (Integer)right.getValue();
		}
		if(op.equals("<")) {
			if(left.getValue() instanceof Integer && right.getValue() instanceof Integer) return (Integer)left.getValue() < (Integer)right.getValue();

		}
		if(op.equals("<=")) {
			if(left.getValue() instanceof Integer && right.getValue() instanceof Integer) return (Integer)left.getValue() <= (Integer)right.getValue();

		}
		if(op.equals(">")) {
			if(left.getValue() instanceof Integer && right.getValue() instanceof Integer) return (Integer)left.getValue() > (Integer)right.getValue();

		}
		if(op.equals(">=")) {
			if(left.getValue() instanceof Integer && right.getValue() instanceof Integer) return (Integer)left.getValue() >= (Integer)right.getValue();

		}
		if(op.equals("==")) {
				return left.getValue().equals(right.getValue());
		}
		return null;
	}
	
}
