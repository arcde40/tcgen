package main;

import java.util.concurrent.TimeUnit;

public class Messenger {
	
	public static String returnTimeStr(long l) {
		return String.format("%d 분 %d 초", 
			    TimeUnit.MILLISECONDS.toMinutes(l),
			    TimeUnit.MILLISECONDS.toSeconds(l) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l))
			);
	}

	
	public static void help() {
		System.out.println("tcgen <횟수> [-i] [-o] [-e] [-p <prefix>] [-d <path>] <InputFile path> <path> [-r <option>]\n\n");
		System.out.println("tcgen은 응용프로그램을 자식프로세스로 실행하여 스크립트에 기반하여 입출력을 받는 프로그램입니다.\n");
		System.out.println("\t<횟수> - 입출력 작업을 몇번 반복해서 할지 정합니다.");
		System.out.println("\t[-i] - 입력 스크립트의 값을 .in 파일로 남깁니다.");
		System.out.println("\t[-o] - 자식 프로세스의 출력값을 .out 파일로 남깁니다.");
		System.out.println("\t[-e] - 자식 프로세스의 에러 로그를 error.log 파일로 남깁니다.");
		System.out.println("\t[-p <prefix>] - -i나 -o 옵션이 지정되었을때 파일의 접두사를 정합니다. <기본 \"\">");
		System.out.println("\t[-d <path>] -i나 -o 옵션이 지정되어있을 경우 이 경로에 파일이 저장됩니다. <-i,-o 옵션 지정되었을 경우 필수>");
		System.out.println("\t<InputFile path> 입력 스크립트의 경로를 지정합니다.");
		System.out.println("\t<path> - 자식 프로세스의 실행파일의 경로를 지정합니다.");
		System.out.println("\t[-r <option>] - 자식 프로세스의 실행옵션을 지정합니다.");
	}
	
	public static ParsedOption parse(String[] args) {
		try {
		ParsedOption p = new ParsedOption();
		if(args.length <= 0) {help(); System.exit(1);}
		p.time = Integer.parseInt(args[0]);
		for(int i = 1; i < args.length; i++) {
			if(args[i].equals("-i")) {p.genInput = true;}
			else if(args[i].equals("-o")) { p.genOutput=true;}
			else if(args[i].equals("-e")) {p.genErrLog=true;}
			else if(args[i].equals("-p")) {
				p.isPrefix = true;
				if(i+1 >= args.length) {help(); System.exit(1);}
				p.prefix = args[++i].replaceAll("\"", "");
			}else if(args[i].equals("-d")) {
				p.isDirectory = true;
				if(i+1 >= args.length) {help(); System.exit(1);}
				p.dirPath = args[++i].replaceAll("\"", "");
			}else {
				if(i+1 >= args.length) {System.out.println("else");help(); System.exit(1);}
				p.inputfilepath = args[i]; p.path = args[i+1]; 
				p.option="";
				if(i+2 < args.length) {
					for(int j = i+2; j < args.length; j++) {
						p.option += args[j];
					}
				}
				if(p.genInput || p.genOutput) if(p.dirPath.length() <= 0) {help(); System.exit(1);}
				return p;
			}
		}
		}catch(Exception e) {help(); System.exit(1);}
		return null;
	}
}
