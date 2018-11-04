package FJEY.AST;

public class Node extends AST{
	
	String type;
	Object val;
	
	public Node() {}
	
	public Node(String type, Object val) {
		this.type = type;
		this.val = val;
	}
	
	public String getType() {
		return type;
	}
	
	public Object getValue(){
		return val;
	}
	
}
