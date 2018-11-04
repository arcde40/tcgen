package FJEY.main;

public class ParsedOption {
	int time;
	boolean genInput, genOutput, genErrLog;
	boolean isPrefix;
	String prefix;
	boolean isDirectory;
	String dirPath;
	String inputfilepath, path;
	String option;

	public ParsedOption() {
	}

	public ParsedOption(int time, boolean b1, boolean b2, boolean b3, boolean b4, boolean b5, String s1, String s2,
			String ipath, String path, String option) {
		this.time = time;
		this.option = option;
		this.genErrLog = b5;
		this.genInput = b1;
		this.genOutput = b2;
		this.isPrefix = b3;
		this.isDirectory = b4;
		this.prefix = s1;
		this.dirPath = s2;
		this.inputfilepath = ipath;
		this.path = path;
	}
}
