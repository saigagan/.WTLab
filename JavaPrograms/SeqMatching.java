import java.util.Scanner;

public class SeqMatching {
	
	public static void main(String args[] ) {
		Scanner in = new Scanner(System.in);
		
		int seqLen = in.nextInt();
		int seq[] = new int[seqLen];
		for(int i = 0; i < seqLen; i++)
			seq[i] = in.nextInt();
		
		int favLen = in.nextInt();
		int fav[] = new int[favLen];
		for(int i = 0; i < favLen; i++)
			fav[i] = in.nextInt();
		
		System.out.println(contains(seq, fav)?"Yes":"No");
	}
	
	private static boolean contains(int a[], int b[]) {
		for(int i = 0; i < a.length - b.length + 1; i++)
			for(int j = 0; j < b.length; j++) {
				if(a[i] != b[j])
					break;
				
				i++;
				
				if(j == b.length - 1)
					return true;
			}
		
		return false;
	}
}