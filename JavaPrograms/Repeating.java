import java.util.Scanner;

public class Repeating {
	
	public static void main(String args[] ) {
		String a = new Scanner(System.in).nextLine();
		
		System.out.println(isPeriodic(a)?"Yes":"No");
	}
	
	private static boolean isPeriodic(String a) {
		int period = period(a);
		
		if(period == a.length())
			return false;
		
		for(int i = 0; i < period; i++)
			if(a.charAt(i) != a.charAt(period + i))
				return false;
		
		return true;
	}
	
	private static int period(String a) {
		for(int i = 1; i < a.length(); i++)
			if(a.charAt(i) == a.charAt(0))
				return i;
		
		return a.length();
	}
}