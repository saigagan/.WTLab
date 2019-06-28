import java.util.Scanner;

public class Denomination {
	
	static int denominations[] = {100, 50, 10, 5, 2, 1};
	
	public static void main(String args[] ) {
		int amount = new Scanner(System.in).nextInt();
		
		int no = 0;
		
		for(int i = 0; i < denominations.length; i++) {
			no += amount / denominations[i];
			amount = amount % denominations[i];
		}
		
		System.out.println(no);
	}
}