import java.util.Scanner;

public class StringMatching {
	
	public static void main(String args[] ) {
		Scanner in = new Scanner(System.in);
		
		String A = in.nextLine().toLowerCase();
		String B = in.nextLine().toLowerCase();
		
		System.out.println(match(A, B)?"Yes":"No");
	}
	
	private static boolean match(String a, String b) {
		if(a.length() != b.length())
			return false;
		
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) == '?' || b.charAt(i) == '?')
				continue;
			
			if(a.charAt(i) != b.charAt(i))
				return false;
		}
		
		return true;
	}
}