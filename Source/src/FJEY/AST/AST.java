package FJEY.AST;

import java.util.ArrayList;

public class AST {
	
	public static ArrayList<Node> array = new ArrayList<Node>();
	
	public static int getSize() {
		return array.size();
	}
	
	public static Node getContent(int idx) {
		return array.get(idx);
	}
	
	public static void push(Node n) {
		array.add(n);
	}
	 
}
