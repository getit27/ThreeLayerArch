package cn.edu.nju.businesslayer;

public class testing {

	public static void main(String[] args) {
		String result = null;
		String string = "123-345-3456";
		String stringNoSpace = string.replaceAll("^[\\s()]+|[\\s()]+$", "");
		
		String[] split = stringNoSpace.split("[\\s()-.]+");
		
		if (split.length == 1) {
			result = string.substring(6, 10);
			System.out.println(result); 
		} else if ( split.length == 4) {
				if (stringNoSpace.startsWith("1") || ( split[0].isEmpty())) {
					result = split[3].replaceAll("\\s","");
				}
		} else {
			result = split[2].replaceAll("\\s","");
			}
		System.out.println(result); 
	}
}
