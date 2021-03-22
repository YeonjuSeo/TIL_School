import java.util.Scanner;

public class Main {
	public static void main (String [] args) {
		String A,B;
		Scanner scanner = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		A=scanner.next();
		B=scanner.next();
		for(int i=2;i>=0;i--) {
			if(A.charAt(i) > B.charAt(i)) {
				sb.append(A);
				System.out.println(sb.reverse());
				break;
			}
			else if(A.charAt(i) < B.charAt(i)) {
				sb.append(B);
				System.out.println(sb.reverse());
				break;
			}
		}
	}
}
