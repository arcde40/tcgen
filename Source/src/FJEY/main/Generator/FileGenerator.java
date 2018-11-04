package FJEY.main.Generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import FJEY.AST.AST;
import FJEY.AST.Node;

public class FileGenerator {
	
	static String path;
	
	public FileGenerator(String path) {
		this.path = path;
	}
	
	public static String appendInputString() {
		try {
			String str="";
			for(Node n : AST.array) {
				if(n.getValue().equals("\n")) str+="\n";
				else str+=(n.getValue().toString()+" ");
			}

			return str;
		}catch(Exception e) {System.out.println(e.getMessage());}
		return null;
	}
	
	public static void appendFileByString(String str, String prefix,int idx,String extension) {
		try {
			File f = new File(path+"\\"+prefix+idx+"."+extension);
			if(f.exists()) f.createNewFile();
			BufferedWriter bf = new BufferedWriter(new FileWriter(f));
			bf.write(str);
			bf.flush();
			bf.close();
		}catch(Exception e) {}
	}
	
}
