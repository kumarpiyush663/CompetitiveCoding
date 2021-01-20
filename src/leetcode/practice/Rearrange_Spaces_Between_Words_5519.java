package leetcode.practice;

public class Rearrange_Spaces_Between_Words_5519 {

	public static void main(String[] args) {
		String text = "   this   is  a sentence  ";

		System.out.println(reorderSpaces(text));
		
		System.out.println(reorderSpaces("a"));
		System.out.println(reorderSpaces(" b"));
		System.out.println(reorderSpaces("c "));
		System.out.println(reorderSpaces("  d  "));

	}

	public static String reorderSpaces(String text) {

		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == ' ')
				count++;
		}
		text = text.trim();
		String textArr[] = text.split(" +");
		if (textArr.length > 1) {
			int temp = count / (textArr.length - 1);
			int flag = count % (textArr.length - 1);

			StringBuilder appendStr = new StringBuilder();
			for (int i = 0; i < temp; i++)
				appendStr.append(" ");

			StringBuilder buffer = new StringBuilder();
			for (int i = 0; i < textArr.length; i++) {
				buffer.append(textArr[i]);
				if (i < textArr.length - 1) {
					buffer.append(appendStr);
					// for(int j=0;j<temp;j++) buffer.append(" ");
				}
			}
			for (int i = 0; i < flag; i++)
				buffer.append(" ");
			return buffer.toString();
		}
		else {
			StringBuilder buffer = new StringBuilder();
			for (int i = 0; i < textArr.length; i++) {
				buffer.append(textArr[i]);
			}
			for (int i = 0; i < count; i++)
				buffer.append(" ");
			return buffer.toString();
		}
	}

}
