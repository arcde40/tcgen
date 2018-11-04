package FJEY.Manager;

import java.util.HashMap;

import FJEY.AST.VariableNode;

public class VariableManager {
	
	public static HashMap<String,VariableNode> var = new HashMap<String,VariableNode>();
	
	public static void declareVar(VariableNode v){
		var.put(v.getName(), v);
	}
	
	public static VariableNode getVar(String str) {
		return var.get(str);
	}
	
	public static boolean isDeclared(String v) {
		return var.containsKey(v);
	}
}
