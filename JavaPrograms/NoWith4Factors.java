import java.util.Scanner;

public class NoWith4Factors {
	
	public static void main(String args[] ) {
		int n = new Scanner(System.in).nextInt();
		
		for(int i = 3; i <= n; i++) {
			if(noOfFactors(i) == 4)
				System.out.println(i);
		}
	}
	
	private static int noOfFactors(int n) {
		int factors = 0;
		
		for(int i = 2; i < Math.sqrt(n); i++)
			if(n % i == 0)
				factors++;
		return 2 * factors + 2;
	}
}