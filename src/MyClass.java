
import java.util.Scanner;

class MyClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int b, temp;	
		b = sc.nextInt();
		if(b>=2) System.out.print(2 + " ");
		
		for (int i = 3; i <= b; i = i + 2) {
			temp = 1;
			for (int j = 2; j * j <= i; ++j) {
				if (i % j == 0) {
					temp = 0;
					break;
				}
			}
			if (temp == 1)
				System.out.print(i + " ");
		}

		System.out.println(); 
	}
}
