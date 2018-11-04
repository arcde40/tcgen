package FJEY.main;

import java.io.File;
import java.sql.Timestamp;
import java.util.Calendar;

import FJEY.JavaCC.JavaCC;
import FJEY.main.Generator.FileGenerator;

public class Main {
	
	public static void main(String[] args) {
		ParsedOption p=Messenger.parse(args);
		JavaCC.parse(new File(p.inputfilepath));
		int errcount = 0, successcount = 0;
		long time=0;
		for(int i =0 ; i < p.time; i++) {
		try {
		FileGenerator fgen = new FileGenerator(p.dirPath);
		String s = fgen.appendInputString();
		Attachjar jar;
		if(!p.genErrLog)  jar = new Attachjar(new File(p.path),p.time);
		else jar = new Attachjar(new File(p.path), new File(p.dirPath+"\\error.log"),p.time);
		jar.runProcess(s,p.option);
		if(p.genInput) fgen.appendFileByString(s, p.isPrefix ? p.prefix : "Input", i+1, "in");
		if(p.genOutput) fgen.appendFileByString(jar.getOutput(), p.isPrefix ? p.prefix : "Output", i+1, "out");
		if(jar.errcount == 1) errcount++; else successcount++;
		time += jar.time;
		}catch(Exception e) {System.err.println(e.getMessage()); return;}
		}
		System.out.println("\r\nDone! - 성공: "  + successcount +" 실패(에러): "+errcount+" ("+Messenger.returnTimeStr(time)+")");
		
	}
	
	
	
	
}
