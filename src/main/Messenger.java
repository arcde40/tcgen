package main;

import java.util.concurrent.TimeUnit;

public class Messenger {
	
	public static String returnTimeStr(long l) {
		return String.format("%d �� %d ��", 
			    TimeUnit.MILLISECONDS.toMinutes(l),
			    TimeUnit.MILLISECONDS.toSeconds(l) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(l))
			);
	}

	
	public static void help() {
		System.out.println("tcgen <Ƚ��> [-i] [-o] [-e] [-p <prefix>] [-d <path>] <InputFile path> <path> [-r <option>]\n\n");
		System.out.println("tcgen�� �������α׷��� �ڽ����μ����� �����Ͽ� ��ũ��Ʈ�� ����Ͽ� ������� �޴� ���α׷��Դϴ�.\n");
		System.out.println("\t<Ƚ��> - ����� �۾��� ��� �ݺ��ؼ� ���� ���մϴ�.");
		System.out.println("\t[-i] - �Է� ��ũ��Ʈ�� ���� .in ���Ϸ� ����ϴ�.");
		System.out.println("\t[-o] - �ڽ� ���μ����� ��°��� .out ���Ϸ� ����ϴ�.");
		System.out.println("\t[-e] - �ڽ� ���μ����� ���� �α׸� error.log ���Ϸ� ����ϴ�.");
		System.out.println("\t[-p <prefix>] - -i�� -o �ɼ��� �����Ǿ����� ������ ���λ縦 ���մϴ�. <�⺻ \"\">");
		System.out.println("\t[-d <path>] -i�� -o �ɼ��� �����Ǿ����� ��� �� ��ο� ������ ����˴ϴ�. <-i,-o �ɼ� �����Ǿ��� ��� �ʼ�>");
		System.out.println("\t<InputFile path> �Է� ��ũ��Ʈ�� ��θ� �����մϴ�.");
		System.out.println("\t<path> - �ڽ� ���μ����� ���������� ��θ� �����մϴ�.");
		System.out.println("\t[-r <option>] - �ڽ� ���μ����� ����ɼ��� �����մϴ�.");
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
