import java.util.Scanner;

public class EvilNo {
	
	public static void main(String args[] ) {
		int n = new Scanner(System.in).nextInt();
		
		for(int i = 0; i < n; i++) {
			if(isEvil(i))
				System.out.println(i);
		}
	}
	
	private static boolean isEvil(int i) {
		int timesDivBy2 = 0;
		
		while(i > 0) {
			timesDivBy2 += i % 2;
			i /= 2;
		}
		
		return timesDivBy2 % 2 == 0;
	}
}