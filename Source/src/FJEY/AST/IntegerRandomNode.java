package FJEY.AST;

import java.util.Random;

public class IntegerRandomNode extends LiteralNode{
	
	long min, max;
	Random r = new Random();
	
	public IntegerRandomNode(int max, int min) {
		super();
		this.min = min; this.max = max;
	}
	
	public IntegerRandomNode() {
		super();
		min = 0; max = Integer.MAX_VALUE;
	}
	
	@Override
	public String getType() {
		return "Integer";
	}
	
	@Override
	public Object getValue() {
		if(max == min) return max;
		return (long)(Math.random()*Math.pow(10, 10) % (max - min + 1) +min);
	}
}
