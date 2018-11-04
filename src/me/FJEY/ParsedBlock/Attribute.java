package me.FJEY.ParsedBlock;

public class Attribute {
	static String minRange;
	static String maxRange;
	static String StaticValue;
	static String[] moreAttribute;
	static ParseBlockMain t;
	
	public Attribute(ParseBlockMain t, String[] moreAttribute) {
		this.t = t;
		this.moreAttribute = moreAttribute;
		if(moreAttribute[0].equals("1")) { // Index 0 : Is Static
			StaticValue = moreAttribute[3]; // Index 3 : Fixed Value (All Type)
		}else {
			minRange = moreAttribute[1]; // Index 1 : Minimum Range (Integer / Double / Float) - Not supported by boolean
			maxRange = moreAttribute[2]; // Index 2 : Maximum Range (Integer / Double / Float) - Not supported by boolean
		}
	}
	
}
