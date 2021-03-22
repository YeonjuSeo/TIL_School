import java.util.Scanner;

public class Main {
	public static void main (String [] args) {
		int T;
		String temp;
		Scanner scanner = new Scanner(System.in);
		T=scanner.nextInt();
		temp=scanner.nextLine();
		for(int i=0;i<T;i++) {
			String result;
			int answer=0, cnt=0;
			result=scanner.nextLine();
			for(int j=0;j<result.length();j++) {
				if(result.charAt(j) == 'O') {
					cnt++;
					answer+=cnt;
				}
				else {
					cnt=0;
				}
			}
			System.out.println(answer);
		}
	}
}
