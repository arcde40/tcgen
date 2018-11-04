package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Attachjar {
	
	static BufferedReader reader;
	static BufferedWriter writer;
	static String output;
	static File f,errlog;
	static boolean generateErrLog;
	static int runtime=0,all,errcount=0, successcount=0;
	static long time;
	public Attachjar(File f,int all) {
		this.f = f;
		generateErrLog = false;
		this.all = all;
	}
	
	public Attachjar(File f , File errlog,int all) {
		this.f= f;
		generateErrLog = true;
		this.errlog = errlog;
		this.all = all;
	}
	
	public static void runProcess(String input, String option) {
		try {
			long cm = System.currentTimeMillis();
			runtime++;
			String extension;
			String path = f.getAbsolutePath();
			extension = f.getAbsolutePath().substring(path.lastIndexOf(".")+1);
			
			//System.out.println("File Extension - " + extension);
			
			ProcessBuilder builder;
			switch (extension) {
			case "jar": builder = new ProcessBuilder("java" , "-jar", f.getAbsolutePath() + option); builder.directory(new File(System.getProperty("java.home")+"\\bin\\")); break;
			case "class" : builder = new ProcessBuilder("java", f.getAbsolutePath() + option); builder.directory(new File(System.getProperty("java.home")+"\\bin\\")); break;
			default: builder = new ProcessBuilder(f.getAbsolutePath() + option); break;
			}
			
			Process process = builder.start();
			System.out.println(runtime +" / " + all +" ("+new DecimalFormat("0.#").format(((float)runtime/(float)all)*100)+"%)..\r\n");
			OutputStream stdin = process.getOutputStream();
			InputStream stdout = process.getInputStream();
			InputStream stderr = process.getErrorStream();
	
			
			writer = new BufferedWriter(new OutputStreamWriter(stdin));
			try {
					writer.write(input);
					writer.flush();
				writer.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Scanner sc = new Scanner(stderr);
			String err="";
			while(sc.hasNext()) {
				err+="\t"+sc.nextLine()+"\r\n";
			}
			time = System.currentTimeMillis() - cm;
			System.out.println(err.length() <= 0 ? "성공. ("+time+"ms)  \r\n" : "실패(에러): " + err+"\r\n"+ " ("+time+"ms)");
			if(err.length() > 0) errcount++; else successcount++;
			if(generateErrLog && err.length() > 0 ) generateLog(err);
			Scanner scanner = new Scanner(stdout);
			String out="";
			String s;
			
			while(scanner.hasNextLine()) {
				s = scanner.nextLine();
				out+=s;
			}
			output = out;
			scanner.close();
		}catch(Exception e) {e.printStackTrace();}
	}
	
	public static String getOutput() {
		return output;
	}
	
	public static void generateLog(String err) {
		if(generateErrLog) {
			try {
				System.out.println(errlog.getAbsolutePath());
				if(!errlog.exists()) errlog.createNewFile();
				BufferedWriter bf = new BufferedWriter(new FileWriter(errlog,true));
				bf.write("============ 런타임 에러 ============\r\n자식 프로세스에서 오류가 발생했습니다.\r\n오류 내용:\r\n"+err+"\r\n");
				bf.close();
				bf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
