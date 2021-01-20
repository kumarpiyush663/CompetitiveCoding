import java.util.Scanner;

public class CountCharacterAndWords {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String str= sc.nextLine();
		System.out.println(str.length());
		System.out.println(str.split(" ").length);

	}

}
