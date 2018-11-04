package FJEY.AST;

public class VariableNode extends Node{
	
	String name,type;
	Node value;
	
	public VariableNode(String name, String type) {
		this.type = type;
		this.name = name;
	}
	
	public VariableNode(String name) {
		super("VariableNode",null);
		this.name = name;
		this.type = "NULL";
	}
	
	public VariableNode(String name, String type, Node value) {
		super("VariableNode",value.getValue());
		this.name = name;
		this.type = type;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
}
